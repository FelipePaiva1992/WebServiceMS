package br.com.mobshop.nfe.bean;

public class Transporte {
	
	private String modalidadeFrete;
	private String cnjp;
	private String nome;
	private String inscricaoEstadual;
	private String nomLogradouro;
	private String nomMunicipio;
	private String nomUf;
	
	private String qtdVolume;
	private String numeracaoVolumes;
	private String pesoLiquido;
	private String pesoBruto;

	public Transporte(String modalidadeFrete, String cnjp, String nome, String inscricaoEstadual,
			String nomLogradouro, String nomMunicipio, String nomUf, String qtdVolume, String numeracaoVolumes, String pesoLiquido, String pesoBruto) {

		this.modalidadeFrete = modalidadeFrete;
		this.cnjp = cnjp;
		this.nome = nome;
		this.inscricaoEstadual = inscricaoEstadual;
		this.nomLogradouro = nomLogradouro;
		this.nomMunicipio = nomMunicipio;
		this.nomUf = nomUf;
		this.qtdVolume = qtdVolume;
		this.numeracaoVolumes = numeracaoVolumes;
		this.pesoLiquido = pesoLiquido;
		this.pesoBruto = pesoBruto;

	}
	
	
	public String getModalidadeFrete() {
		return modalidadeFrete;
	}
	public void setModalidadeFrete(String modalidadeFrete) {
		this.modalidadeFrete = modalidadeFrete;
	}
	public String getCnjp() {
		return cnjp;
	}
	public void setCnjp(String cnjp) {
		this.cnjp = cnjp;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}
	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}
	public String getNomLogradouro() {
		return nomLogradouro;
	}
	public void setNomLogradouro(String nomLogradouro) {
		this.nomLogradouro = nomLogradouro;
	}
	public String getNomMunicipio() {
		return nomMunicipio;
	}
	public void setNomMunicipio(String nomMunicipio) {
		this.nomMunicipio = nomMunicipio;
	}
	public String getNomUf() {
		return nomUf;
	}
	public void setNomUf(String nomUf) {
		this.nomUf = nomUf;
	}

	public String getQtdVolume() {
		return qtdVolume;
	}

	public void setQtdVolume(String qtdVolume) {
		this.qtdVolume = qtdVolume;
	}

	public String getNumeracaoVolumes() {
		return numeracaoVolumes;
	}

	public void setNumeracaoVolumes(String numeracaoVolumes) {
		this.numeracaoVolumes = numeracaoVolumes;
	}

	public String getPesoLiquido() {
		return pesoLiquido;
	}

	public void setPesoLiquido(String pesoLiquido) {
		this.pesoLiquido = pesoLiquido;
	}

	public String getPesoBruto() {
		return pesoBruto;
	}

	public void setPesoBruto(String pesoBruto) {
		this.pesoBruto = pesoBruto;
	}
	
	
	

}
