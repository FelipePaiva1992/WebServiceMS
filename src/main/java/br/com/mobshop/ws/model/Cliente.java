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
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@Table(name="cliente")
@NamedQuery(name="cliente.findAll", query="SELECT c FROM Cliente c")
@XmlRootElement
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_CLIENTE")
	private Long idCliente;

	@Column(name="CPF_CLIENTE")
	private String cpfCliente;

	@Column(name="NM_CLIENTE")
	private String nmCliente;
	
	@Column(name="LOGRADOURO")
	private String logradouro;
	
	@Column(name="ENDERECO")
	private String endereco;
	
	@Column(name="NUMERO")
	private String numero;
	
	@Column(name="BAIRRO")
	private String bairro;
	
	@Column(name="CIDADE")
	private String cidade;
	
	@Column(name="ESTADO")
	private String estado;
	
	@Column(name="VL_TELEFONE")
	private String vlTelefone;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="DT_NASCIMENTO")
	private String dtNascimento;

	//bi-directional many-to-one association to Venda
	@OneToMany(mappedBy="cliente")
	private List<Venda> vendas;

	public Cliente() {
	}

	public Long getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String getCpfCliente() {
		return this.cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public String getNmCliente() {
		return this.nmCliente;
	}

	public void setNmCliente(String nmCliente) {
		this.nmCliente = nmCliente;
	}	


	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getVlTelefone() {
		return vlTelefone;
	}

	public void setVlTelefone(String vlTelefone) {
		this.vlTelefone = vlTelefone;
	}

	@JsonIgnore
	public List<Venda> getVendas() {
		return this.vendas;
	}

	public void setVendas(List<Venda> vendas) {
		this.vendas = vendas;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	@JsonIgnore
	public String getEnderecoCompleto(){
		return this.logradouro + " " + this.endereco;
	}
	
	public Venda addVenda(Venda venda) {
		getVendas().add(venda);
		venda.setCliente(this);

		return venda;
	}

	public Venda removeVenda(Venda venda) {
		getVendas().remove(venda);
		venda.setCliente(null);

		return venda;
	}

}