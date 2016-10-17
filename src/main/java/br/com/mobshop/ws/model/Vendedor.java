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
 * The persistent class for the vendedor database table.
 * 
 */
@Entity
@Table(name="vendedor")
@NamedQuery(name="vendedor.findAll", query="SELECT v FROM Vendedor v")
@XmlRootElement
public class Vendedor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_VENDEDOR")
	private int idVendedor;

	@Column(name="NM_VENDEDOR")
	private String nmVendedor;
	
	@Column(name="VL_SENHA")
	private String vlSenha;

	//bi-directional many-to-one association to Venda
	@OneToMany(mappedBy="vendedor")
	private List<Venda> vendas;

	public Vendedor() {
	}

	public int getIdVendedor() {
		return this.idVendedor;
	}

	public void setIdVendedor(int idVendedor) {
		this.idVendedor = idVendedor;
	}

	public String getNmVendedor() {
		return this.nmVendedor;
	}

	public void setNmVendedor(String nmVendedor) {
		this.nmVendedor = nmVendedor;
	}

	@JsonIgnore
	public List<Venda> getVendas() {
		return this.vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}

	public Venda addVenda(Venda venda) {
		getVendas().add(venda);
		venda.setVendedor(this);

		return venda;
	}

	public Venda removeVenda(Venda venda) {
		getVendas().remove(venda);
		venda.setVendedor(null);

		return venda;
	}

	public String getVlSenha() {
		return vlSenha;
	}

	public void setVlSenha(String vlSenha) {
		this.vlSenha = vlSenha;
	}

}