package br.com.mobshop.ws.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;


/**
 * The persistent class for the venda_item database table.
 * 
 */
@Entity
@Table(name="venda_item")
@NamedQuery(name="vendaItem.findAll", query="SELECT v FROM VendaItem v")
@XmlRootElement
public class VendaItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_VENDA_ITEM")
	private Long idVendaItem;

	@Column(name="VL_QUANTIDADE")
	private int vlQuantidade;

	//bi-directional many-to-one association to Produto
	@ManyToOne
	@JoinColumn(name="FK_ID_REF_PRODUTO")
	private Produto produto;

	//bi-directional many-to-one association to Venda
	@ManyToOne
	@JoinColumn(name="FK_ID_VENDA")
	private Venda venda;

	public VendaItem() {
	}

	public Long getIdVendaItem() {
		return this.idVendaItem;
	}

	public void setIdVendaItem(Long idVendaItem) {
		this.idVendaItem = idVendaItem;
	}

	public int getVlQuantidade() {
		return this.vlQuantidade;
	}

	public void setVlQuantidade(int vlQuantidade) {
		this.vlQuantidade = vlQuantidade;
	}

	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@JsonIgnore
	public Venda getVenda() {
		return this.venda;
	}

	public void setVenda(Venda venda) {
		this.venda = venda;
	}

}