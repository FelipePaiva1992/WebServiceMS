package br.com.mobshop.ws.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.mobshop.util.HibernateUtil;
import br.com.mobshop.ws.model.Vendedor;

public class VendedorDao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Vendedor logarVendedor(int idVendedor, String vlSenha){
		EntityManager em = HibernateUtil.getEntityManager("posmobile");
		Vendedor vendedor = new Vendedor();
		Query query = em.createQuery("FROM Vendedor WHERE idVendedor = :idVendedor AND vlSenha = :vlSenha");
		query.setParameter("idVendedor", idVendedor);
		query.setParameter("vlSenha", vlSenha);
		try{
			vendedor = (Vendedor) query.getSingleResult();
		}catch(Exception e){
			e.printStackTrace();
			vendedor = null;
		}
		return vendedor;	
	}
	
	public Vendedor cadastrarVendedor(int idVendedor, String nmVendedor, String vlSenha) {
		EntityManager em = HibernateUtil.getEntityManager("posmobile");
		Vendedor vendedor = new Vendedor();
		vendedor.setIdVendedor(idVendedor);
		vendedor.setNmVendedor(nmVendedor);
		vendedor.setVlSenha(vlSenha);
		try{
			em.getTransaction().begin();
			em.persist(vendedor);
			em.getTransaction().commit();
		}catch(Exception e){
			em.getTransaction().rollback();
			e.printStackTrace();
			vendedor = null;
		}
		return vendedor;
	}
	public Vendedor cadastrarVendedor(String nmVendedor, String vlSenha) {
		EntityManager em = HibernateUtil.getEntityManager("posmobile");
		Vendedor vendedor = new Vendedor();
		vendedor.setNmVendedor(nmVendedor);
		vendedor.setVlSenha(vlSenha);
		try{
			em.getTransaction().begin();
			em.persist(vendedor);
			em.getTransaction().commit();
		}catch(Exception e){
			em.getTransaction().rollback();
			e.printStackTrace();
			vendedor = null;
		}
		return vendedor;
	}
}
