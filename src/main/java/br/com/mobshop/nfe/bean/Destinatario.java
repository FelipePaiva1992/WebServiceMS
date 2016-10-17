package br.com.mobshop.nfe.bean;

public class Destinatario {

	private String cnpj;
	private String nome;
	private String nomeFantasia;
	private String nomLogradouro;
	private String numero;
	private String nomBairro;
	private String codMunicipio;
	private String nomMunicipio;
	private String nmUf;
	private String cep;
	private String codPais;
	private String nomPais;
	private String telefone;
	private String inscricaoEstadual;
	private String codRegimeTributario;
	private String email;
	
	public Destinatario(String cnpj, String nome, String nomeFantasia,
			String nomLogradouro, String numero, String nomBairro,
			String codMunicipio, String nomMunicipio, String nmUf, String cep,
			String codPais, String nomPais, String telefone, String inscricaoEstadual,
			String codRegimeTributario, String email) {

		this.cnpj = cnpj;
		this.nome = nome;
		this.nomeFantasia = nomeFantasia;
		this.nomLogradouro = nomLogradouro;
		this.numero = numero;
		this.nomBairro = nomBairro;
		this.codMunicipio = codMunicipio;
		this.nomMunicipio = nomMunicipio;
		this.nmUf = nmUf;
		this.cep = cep;
		this.codPais = codPais;
		this.nomPais = nomPais;
		this.telefone = telefone;
		this.inscricaoEstadual = inscricaoEstadual;
		this.codRegimeTributario = codRegimeTributario;
		this.email = email;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNomeFantasia() {
		return nomeFantasia;
	}
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}
	public String getNomLogradouro() {
		return nomLogradouro;
	}
	public void setNomLogradouro(String nomLogradouro) {
		this.nomLogradouro = nomLogradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getNomBairro() {
		return nomBairro;
	}
	public void setNomBairro(String nomBairro) {
		this.nomBairro = nomBairro;
	}
	public String getCodMunicipio() {
		return codMunicipio;
	}
	public void setCodMunicipio(String codMunicipio) {
		this.codMunicipio = codMunicipio;
	}
	public String getNomMunicipio() {
		return nomMunicipio;
	}
	public void setNomMunicipio(String nomMunicipio) {
		this.nomMunicipio = nomMunicipio;
	}
	public String getNmUf() {
		return nmUf;
	}
	public void setNmUf(String nmUf) {
		this.nmUf = nmUf;
	}
	public String getCep() {
		return cep.replace("-", "").replace(".", "").trim();
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getCodPais() {
		return codPais;
	}
	public void setCodPais(String codPais) {
		this.codPais = codPais;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}
	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}
	public String getCodRegimeTributario() {
		return codRegimeTributario;
	}
	public void setCodRegimeTributario(String codRegimeTributario) {
		this.codRegimeTributario = codRegimeTributario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNomPais() {
		return nomPais;
	}
	public void setNomPais(String nomPais) {
		this.nomPais = nomPais;
	}
	
	
	
}
