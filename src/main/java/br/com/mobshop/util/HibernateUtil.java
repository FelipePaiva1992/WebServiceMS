package br.com.mobshop.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class HibernateUtil {

	static EntityManagerFactory emf;
	
	public static EntityManager getEntityManager(String pu){
		try{
			emf.close();
		}catch(Exception e){
			//e.printStackTrace();
		}
		emf = Persistence.createEntityManagerFactory(pu);
		return emf.createEntityManager();
	}
}
