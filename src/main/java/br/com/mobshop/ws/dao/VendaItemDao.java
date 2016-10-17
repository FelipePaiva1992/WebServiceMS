package br.com.mobshop.ws.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.mobshop.util.HibernateUtil;
import br.com.mobshop.ws.model.Produto;
import br.com.mobshop.ws.model.Venda;
import br.com.mobshop.ws.model.VendaItem;

public class VendaItemDao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unchecked")
	public List<VendaItem> encontrarProdutosNaVenda(String idVenda){
		EntityManager em = HibernateUtil.getEntityManager("posmobile");
		List<VendaItem> vendaItems = new ArrayList<VendaItem>();
		try{
			Query query = em.createQuery("FROM VendaItem WHERE venda.idVenda = :idVenda");
			query.setParameter("idVenda", Long.parseLong(idVenda));
			vendaItems = query.getResultList();			
		}catch(Exception e){
			e.printStackTrace();
			vendaItems = null;
		}
		return vendaItems;	
	}
	
	public VendaItem inserirProdutoNaVenda(String idProduto, String idVenda, int vlQuantidade){
		EntityManager em = HibernateUtil.getEntityManager("posmobile");
		Produto produto ;
		Venda venda;
		VendaItem vendaItem = new VendaItem();
		
		try{
			Query query = em.createQuery("FROM VendaItem WHERE produto.idRefProduto = :idRefProduto AND venda.idVenda = :idVenda");
			query.setParameter("idRefProduto", Long.parseLong(idProduto));
			query.setParameter("idVenda", Long.parseLong(idVenda));
			vendaItem = (VendaItem) query.getSingleResult();
			
			int estoque = vendaItem.getProduto().getVlQuantidade()-vlQuantidade;
			if(estoque < 0){
				return null;
			}else{				
				int quant = vendaItem.getVlQuantidade();
				quant = quant + vlQuantidade;
				vendaItem.setVlQuantidade(quant);
				Produto produto2 = vendaItem.getProduto();
			
				produto2.setVlQuantidade(produto2.getVlQuantidade()-vlQuantidade);
				vendaItem.setProduto(produto2);
				try{
					em.getTransaction().begin();
					em.persist(vendaItem);
					em.getTransaction().commit();
				}catch(Exception ee){
					em.getTransaction().rollback();
				}
			}			
		}catch(Exception e){
			venda = em.find(Venda.class, Long.parseLong(idVenda));
			produto = em.find(Produto.class, Long.parseLong(idProduto));

			int estoque = produto.getVlQuantidade()-vlQuantidade;	
			if(estoque < 0){
				vendaItem = null;
			}else{
				produto.setVlQuantidade(produto.getVlQuantidade()-vlQuantidade);			
				vendaItem.setProduto(produto);
				vendaItem.setVenda(venda);
				vendaItem.setVlQuantidade(vlQuantidade);
				try{
					em.getTransaction().begin();
					em.persist(vendaItem);
					em.getTransaction().commit();
				}catch(Exception ex){
					em.getTransaction().rollback();
				}
				
			}			
		}
		return vendaItem;	
	}
	
	public VendaItem removerProdutoDaVenda(String idProduto, String idVenda){
		EntityManager em = HibernateUtil.getEntityManager("posmobile");
		VendaItem vendaItem = new VendaItem();
		
		try{
			Query query = em.createQuery("FROM VendaItem WHERE produto.idRefProduto = :idRefProduto AND venda.idVenda = :idVenda");
			query.setParameter("idRefProduto", Long.parseLong(idProduto));
			query.setParameter("idVenda", Long.parseLong(idVenda));
			vendaItem = (VendaItem) query.getSingleResult();
			em.getTransaction().begin();
			em.remove(vendaItem);
			em.getTransaction().commit();
		}catch(Exception e){
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		return vendaItem;	
	}
}
