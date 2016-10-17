package br.com.mobshop.ws.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * The persistent class for the tipo_pagamento database table.
 * 
 */
@Entity
@Table(name="tipo_pagamento")
@NamedQuery(name="tipoPagamento.findAll", query="SELECT v FROM TipoPagamento v")
@XmlRootElement
public class TipoPagamento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_TIPO_PAGAMENTO")
	private int idTipoPagamento;
	
	@Column(name="NM_TIPO_PAGAMENTO")
	private String nmTipoPagamento;
	
	//bi-directional many-to-one association to Produto
	@OneToMany(mappedBy="tipoPagamento")
	private List<Venda> vendas;

	public int getIdTipoPagamento() {
		return idTipoPagamento;
	}

	public void setIdTipoPagamento(int idTipoPagamento) {
		this.idTipoPagamento = idTipoPagamento;
	}

	public String getNmTipoPagamento() {
		return nmTipoPagamento;
	}

	public void setNmTipoPagamento(String nmTipoPagamento) {
		this.nmTipoPagamento = nmTipoPagamento;
	}
	
	@JsonIgnore
	public List<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}
}
