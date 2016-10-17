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
 * The persistent class for the produto_tamanho database table.
 * 
 */
@Entity
@Table(name="produto_capacidade")
@NamedQuery(name="produtoCapacidade.findAll", query="SELECT p FROM ProdutoCapacidade p")
@XmlRootElement
public class ProdutoCapacidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_TAMANHO")
	private int idTamanho;

	@Column(name="DS_TAMANHO")
	private String dsTamanho;

	//bi-directional many-to-one association to Produto
	@OneToMany(mappedBy="produtoCapacidade")
	private List<Produto> produtos;

	public ProdutoCapacidade() {
	}

	public int getIdTamanho() {
		return this.idTamanho;
	}

	public void setIdTamanho(int idTamanho) {
		this.idTamanho = idTamanho;
	}

	public String getDsTamanho() {
		return this.dsTamanho;
	}

	public void setDsTamanho(String dsTamanho) {
		this.dsTamanho = dsTamanho;
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
		produto.setProdutoCapacidade(this);

		return produto;
	}

	public Produto removeProduto(Produto produto) {
		getProdutos().remove(produto);
		produto.setProdutoCapacidade(null);

		return produto;
	}

}