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
 * The persistent class for the produto_cor database table.
 * 
 */
@Entity
@Table(name="produto_cor")
@NamedQuery(name="produtoCor.findAll", query="SELECT p FROM ProdutoCor p")
@XmlRootElement
public class ProdutoCor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_COR")
	private int idCor;

	@Column(name="DS_COR")
	private String dsCor;

	//bi-directional many-to-one association to Produto
	@OneToMany(mappedBy="produtoCor")
	private List<Produto> produtos;

	public ProdutoCor() {
	}

	public int getIdCor() {
		return this.idCor;
	}

	public void setIdCor(int idCor) {
		this.idCor = idCor;
	}

	public String getDsCor() {
		return this.dsCor;
	}

	public void setDsCor(String dsCor) {
		this.dsCor = dsCor;
	}

	@JsonIgnore
	public List<Produto> getProdutos() {
		return this.produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Produto addProduto(Produto produto) {
		getProdutos().add(produto);
		produto.setProdutoCor(this);

		return produto;
	}

	public Produto removeProduto(Produto produto) {
		getProdutos().remove(produto);
		produto.setProdutoCor(null);

		return produto;
	}

}