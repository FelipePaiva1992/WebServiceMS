package br.com.mobshop.ws.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;


/**
 * The persistent class for the produto database table.
 * 
 */
@Entity
@Table(name="produto")
@NamedQuery(name="produto.findAll", query="SELECT p FROM Produto p")
@XmlRootElement
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_REF_PRODUTO")
	private Long idRefProduto;

	@Column(name="COD_BARRAS")
	private String codBarras;

	@Column(name="MR_PRODUTO")
	private String mrProduto;

	@Column(name="NM_PRODUTO")
	private String nmProduto;

	@Column(name="PR_PRODUTO")
	private BigDecimal prProduto;

	@Column(name="VL_QUANTIDADE")
	private int vlQuantidade;
	
	//bi-directional many-to-one association to ProdutoCor
	@ManyToOne
	@JoinColumn(name="FK_ID_COR")
	private ProdutoCor produtoCor;

	//bi-directional many-to-one association to ProdutoTamanho
	@ManyToOne
	@JoinColumn(name="FK_ID_CAPACIDADE")
	private ProdutoCapacidade produtoCapacidade;

	//bi-directional many-to-one association to VendaItem
	@OneToMany(mappedBy="produto")
	private List<VendaItem> vendaItems;

	public Produto() {
	}

	public Long getIdRefProduto() {
		return this.idRefProduto;
	}

	public void setIdRefProduto(Long idRefProduto) {
		this.idRefProduto = idRefProduto;
	}

	public String getCodBarras() {
		return this.codBarras;
	}

	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}

	public String getMrProduto() {
		return this.mrProduto;
	}

	public void setMrProduto(String mrProduto) {
		this.mrProduto = mrProduto;
	}

	public String getNmProduto() {
		return this.nmProduto;
	}

	public void setNmProduto(String nmProduto) {
		this.nmProduto = nmProduto;
	}

	public BigDecimal getPrProduto() {
		return this.prProduto;
	}

	public void setPrProduto(BigDecimal prProduto) {
		this.prProduto = prProduto;
	}

	public int getVlQuantidade() {
		return vlQuantidade;
	}

	public void setVlQuantidade(int vlQuantidade) {
		this.vlQuantidade = vlQuantidade;
	}

	public ProdutoCor getProdutoCor() {
		return this.produtoCor;
	}

	public void setProdutoCor(ProdutoCor produtoCor) {
		this.produtoCor = produtoCor;
	}

	public ProdutoCapacidade getProdutoCapacidade() {
		return this.produtoCapacidade;
	}

	public void setProdutoCapacidade(ProdutoCapacidade produtoCapacidade) {
		this.produtoCapacidade = produtoCapacidade;
	}

	@JsonIgnore
	public List<VendaItem> getVendaItems() {
		return this.vendaItems;
	}

	public void setVendaItems(List<VendaItem> vendaItems) {
		this.vendaItems = vendaItems;
	}

	public VendaItem addVendaItem(VendaItem vendaItem) {
		getVendaItems().add(vendaItem);
		vendaItem.setProduto(this);

		return vendaItem;
	}

	public VendaItem removeVendaItem(VendaItem vendaItem) {
		getVendaItems().remove(vendaItem);
		vendaItem.setProduto(null);

		return vendaItem;
	}

}