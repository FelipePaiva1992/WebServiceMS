package br.com.mobshop.ws.dao;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.mobshop.util.HibernateUtil;
import br.com.mobshop.ws.model.Cliente;
import br.com.mobshop.ws.model.Produto;
import br.com.mobshop.ws.model.TipoPagamento;
import br.com.mobshop.ws.model.Venda;
import br.com.mobshop.ws.model.VendaAux;
import br.com.mobshop.ws.model.VendaItem;
import br.com.mobshop.ws.model.Vendedor;

public class VendaDao  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public VendaAux iniciarVenda(int idVendedor, String cpfCliente){
		EntityManager em = HibernateUtil.getEntityManager("posmobile");
		Vendedor vendedor = em.find(Vendedor.class, idVendedor);
		TipoPagamento tipoPagamento = em.find(TipoPagamento.class, 4);
		Query query = em.createQuery("FROM Cliente WHERE cpfCliente = :cpfCliente");
		query.setParameter("cpfCliente", cpfCliente);
		Cliente cliente = (Cliente) query.getSingleResult();
		
		VendaAux venda = new VendaAux();
		venda.setCliente(cliente);
		venda.setVendedor(vendedor);
		venda.setDtVenda(new Date());
		venda.setVfEntrege(false);
		venda.setVfCancelado(false);
		venda.setVfPago(false);
		venda.setTipoPagamento(tipoPagamento);
		venda.setVlCodigoConfirmacao("0");
		
		try{
			em.getTransaction().begin();
			em.persist(venda);	
			em.getTransaction().commit();
		}catch(Exception e){
			em.getTransaction().rollback();
			e.printStackTrace();
			venda = null;
		}
		return venda;	
	}
	
	public VendaAux encerrarVenda(Long idVenda){
		EntityManager em = HibernateUtil.getEntityManager("posmobile");
		VendaAux venda = null;
		TipoPagamento tipoPagamento = null;
		try{
			tipoPagamento = em.find(TipoPagamento.class, 4);
			
			venda = em.find(VendaAux.class, idVenda);
			venda.setVfEntrege(false);
			venda.setVfPago(false);	
			venda.setVfCancelado(true);
			venda.setTipoPagamento(tipoPagamento);
			
			List<VendaItem> item = venda.getVendaItems();
			for(int i =0; i< item.size(); i++){
				Produto produto = item.get(i).getProduto();
				produto.setVlQuantidade(produto.getVlQuantidade() + item.get(i).getVlQuantidade());
				item.get(i).setProduto(produto);
			}
			venda.setVendaItems(item);
			em.getTransaction().begin();
			em.merge(venda);
			em.getTransaction().commit();
		}catch(Exception e){
			em.getTransaction().rollback();
			e.printStackTrace();
			venda = null;
		}
		return venda;	
	}
	
	public VendaAux pagarVenda(Long idVenda, String codConfirmacao, String tpPagamento){
		EntityManager em = HibernateUtil.getEntityManager("posmobile");
		VendaAux venda = null;
		TipoPagamento tipoPagamento = null;
		try{
			tipoPagamento = em.find(TipoPagamento.class, Integer.valueOf(tpPagamento)+1);
			
			venda = em.find(VendaAux.class, idVenda);
			venda.setVfPago(true);	
			venda.setTipoPagamento(tipoPagamento);
			venda.setVlCodigoConfirmacao(codConfirmacao);
			
			List<VendaItem> item = venda.getVendaItems();
			for(int i =0; i< item.size(); i++){
				Produto produto = item.get(i).getProduto();
				produto.setVlQuantidade(produto.getVlQuantidade() + item.get(i).getVlQuantidade());
				item.get(i).setProduto(produto);
			}
			venda.setVendaItems(item);
			em.getTransaction().begin();
			em.merge(venda);
			em.getTransaction().commit();
		}catch(Exception e){
			em.getTransaction().rollback();
			e.printStackTrace();
			venda = null;
		}
		return venda;	
	}
	
	@SuppressWarnings("unchecked")
	public List<Venda> obterUltimasVendas(){
		EntityManager em = HibernateUtil.getEntityManager("posmobile");
		List<Venda> vendas = null;
		try{
			Query query = em.createQuery("FROM Venda WHERE vfCancelado=0 AND vfPago=1 AND vfEntrege=0 ORDER BY dtVenda ASC");
			vendas = query.getResultList();
		}catch(Exception e){
			e.printStackTrace();
			vendas = null;
		}
		return vendas;	
	}
	
	public Venda entregarVenda(Long idVenda){
		EntityManager em = HibernateUtil.getEntityManager("posmobile");
		Venda venda = null;
		try{			
			venda = em.find(Venda.class, idVenda);
			venda.setVfEntrege(true);
			em.getTransaction().begin();
			em.merge(venda);
			em.getTransaction().commit();
		}catch(Exception e){
			em.getTransaction().rollback();
			e.printStackTrace();
			venda = null;
		}
		return venda;	
	}
}
