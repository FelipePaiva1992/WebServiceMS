package br.com.mobshop.ws.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.mobshop.util.HibernateUtil;
import br.com.mobshop.ws.model.Produto;

public class ProdutoDao  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Produto encontrarProduto(String codBarras){
		EntityManager em = HibernateUtil.getEntityManager("posmobile");
		Produto produto = new Produto();
		Query query = em.createQuery("FROM Produto WHERE codBarras = :codBarras");
		query.setParameter("codBarras", codBarras);		
		try{
			produto = (Produto) query.getSingleResult();
		}catch(Exception e){
			e.printStackTrace();
			produto = null;
		}
		return produto;	
	}

}
