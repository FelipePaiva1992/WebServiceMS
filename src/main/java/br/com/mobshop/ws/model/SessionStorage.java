package br.com.mobshop.ws.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class SessionStorage {

	/* VENDEDOR */
	private String idVendedor;
	
	/* CLIENTE */
	private String cpfCliente;
	private String nmCliente;
	
	/* VENDA */
	private String idVenda;
	
	public String getIdVendedor() {
		return idVendedor;
	}
	public void setIdVendedor(String idVendedor) {
		this.idVendedor = idVendedor;
	}
	public String getCpfCliente() {
		return cpfCliente;
	}
	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}
	public String getNmCliente() {
		return nmCliente;
	}
	public void setNmCliente(String nmCliente) {
		this.nmCliente = nmCliente;
	}	
	public String getIdVenda() {
		return idVenda;
	}
	public void setIdVenda(String idVenda) {
		this.idVenda = idVenda;
	}
}
