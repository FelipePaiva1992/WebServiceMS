package br.com.mobshop.ws.dao;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.mobshop.util.HibernateUtil;
import br.com.mobshop.ws.model.Cliente;

public class ClienteDao  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Cliente encontrarCliente(String cpfCliente){		
		EntityManager em = HibernateUtil.getEntityManager("posmobile");
		Cliente cliente = new Cliente();
		Query query = em.createQuery("FROM Cliente WHERE cpfCliente = :cpfCliente");
		query.setParameter("cpfCliente", cpfCliente);
		try{
			cliente = (Cliente) query.getSingleResult();
		}catch(Exception e){
			e.printStackTrace();
			cliente = null;
		}
		return cliente;	
	}
	
	public Cliente inserirCliente(String nmCliente, String cpfCliente, String logradouro , String endereco , String numero , String bairro , String cidade , String estado, String vlTelefone, String email, String dtNascimento){
		EntityManager em = HibernateUtil.getEntityManager("posmobile");
		Cliente cliente = new Cliente();
		try{			
			cliente.setCpfCliente(cpfCliente);
			cliente.setNmCliente(nmCliente);
			cliente.setLogradouro(logradouro);
			cliente.setEndereco(endereco);
			cliente.setNumero(numero);
			cliente.setBairro(bairro);
			cliente.setCidade(cidade);
			cliente.setEstado(estado);
			cliente.setVlTelefone(vlTelefone);
			cliente.setEmail(email);
			cliente.setDtNascimento(dtNascimento);
			em.getTransaction().begin();
			em.persist(cliente);
			em.getTransaction().commit();
		}catch(Exception e){
			em.getTransaction().rollback();
			e.printStackTrace();
			cliente = null;
		}
		return cliente;	
	}

}
