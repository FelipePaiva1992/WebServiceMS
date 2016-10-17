package br.com.mobshop.ws.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.mobshop.util.HibernateUtil;
import br.com.mobshop.ws.model.AcessoSistema;
import br.com.mobshop.ws.model.PerfilAcesso;

public class AcessoSistemaDao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AcessoSistema logarUsuarioSenha(String nmUsuario, String vlSenha){		
		EntityManager em = HibernateUtil.getEntityManager("posmobile");
		AcessoSistema acessoSistema = new AcessoSistema();
		Query query = em.createQuery("FROM AcessoSistema WHERE usUsuario = :usUsuario AND vlSenha = :vlSenha");
		query.setParameter("usUsuario", nmUsuario);
		query.setParameter("vlSenha", vlSenha);
		try{
			acessoSistema = (AcessoSistema) query.getSingleResult();
		}catch(Exception e){
			e.printStackTrace();
			acessoSistema = null;
		}
		return acessoSistema;	
	}
	
	public AcessoSistema criarUsuarioSistema(String usUsuario, String nmUsuario, String vlSenha, String idPerfil){		
		EntityManager em = HibernateUtil.getEntityManager("posmobile");
		AcessoSistema acessoSistema = new AcessoSistema();
		acessoSistema.setNmUsuario(nmUsuario);
		acessoSistema.setUsUsuario(usUsuario);
		acessoSistema.setVlSenha(vlSenha);
		
		try{
			PerfilAcesso perfilAcesso = em.find(PerfilAcesso.class, Long.parseLong(idPerfil));
			acessoSistema.setPerfilAcesso(perfilAcesso);
			em.getTransaction().begin();
			em.persist(acessoSistema);
			em.getTransaction().commit();
		}catch(Exception e){
			em.getTransaction().rollback();
			e.printStackTrace();
			acessoSistema = null;
		}
		return acessoSistema;	
	}
}
