package br.com.mobshop.nfe.bean;

public class Produto {

	private String codProduto;
	private String codBarras;
	private String nomProduto;
	private String nomenclaturaComMercosul;
	private String cfop;
	private String unidadeComercializacao;
	private String qtdComercializacao;
	private String valorUnidadeComercializacao;
	private String valorTotalProduto;
	private String unidadeTributacao;
	private String qtdTributacao;
	private String codBarrasTributavel;
	private String valorUnidadeTributavel;
	private String indComposicaoVlTotal;
	private Impostos impostos;
	
	public Produto(String codProduto, String codBarras, String nomProduto,
			String nomenclaturaComMercosul, String cfop,
			String unidadeComercializacao, String qtdComercializacao, String valorUnidadeComercializacao,
			String valorTotalProduto, String unidadeTributacao,
			String qtdTributacao, String codBarrasTributavel, String valorUnidadeTributavel,
			String indComposicaoVlTotal, Impostos impostos) {

		this.codProduto = codProduto;
		this.codBarras = codBarras;
		this.nomProduto = nomProduto;
		this.nomenclaturaComMercosul = nomenclaturaComMercosul;
		this.cfop = cfop;
		this.unidadeComercializacao = unidadeComercializacao;
		this.qtdComercializacao = qtdComercializacao;
		this.valorUnidadeComercializacao = valorUnidadeComercializacao;
		this.valorTotalProduto = valorTotalProduto;
		this.unidadeTributacao = unidadeTributacao;
		this.qtdTributacao = qtdTributacao;
		this.valorUnidadeTributavel = valorUnidadeTributavel;
		this.codBarrasTributavel = codBarrasTributavel;
		this.indComposicaoVlTotal = indComposicaoVlTotal;
		this.impostos = impostos;
	}
	
	public String getCodProduto() {
		return codProduto;
	}
	public void setCodProduto(String codProduto) {
		this.codProduto = codProduto;
	}
	public String getCodBarras() {
		return codBarras;
	}
	public void setCodBarras(String codBarras) {
		this.codBarras = codBarras;
	}
	public String getNomProduto() {
		return nomProduto;
	}
	public void setNomProduto(String nomProduto) {
		this.nomProduto = nomProduto;
	}
	public String getNomenclaturaComMercosul() {
		return nomenclaturaComMercosul;
	}
	public void setNomenclaturaComMercosul(String nomenclaturaComMercosul) {
		this.nomenclaturaComMercosul = nomenclaturaComMercosul;
	}
	public String getCfop() {
		return cfop;
	}
	public void setCfop(String cfop) {
		this.cfop = cfop;
	}
	public String getUnidadeComercializacao() {
		return unidadeComercializacao;
	}
	public void setUnidadeComercializacao(String unidadeComercializacao) {
		this.unidadeComercializacao = unidadeComercializacao;
	}
	public String getQtdComercializacao() {
		return qtdComercializacao;
	}
	public void setQtdComercializacao(String qtdComercializacao) {
		this.qtdComercializacao = qtdComercializacao;
	}
	public String getValorTotalProduto() {
		return valorTotalProduto;
	}
	public void setValorTotalProduto(String valorTotalProduto) {
		this.valorTotalProduto = valorTotalProduto;
	}
	public String getUnidadeTributacao() {
		return unidadeTributacao;
	}
	public void setUnidadeTributacao(String unidadeTributacao) {
		this.unidadeTributacao = unidadeTributacao;
	}
	public String getQtdTributacao() {
		return qtdTributacao;
	}
	public void setQtdTributacao(String qtdTributacao) {
		this.qtdTributacao = qtdTributacao;
	}
	public String getCodBarrasTributavel() {
		return codBarrasTributavel;
	}
	public void setCodBarrasTributavel(String codBarrasTributavel) {
		this.codBarrasTributavel = codBarrasTributavel;
	}
	public String getIndComposicaoVlTotal() {
		return indComposicaoVlTotal;
	}
	public void setIndComposicaoVlTotal(String indComposicaoVlTotal) {
		this.indComposicaoVlTotal = indComposicaoVlTotal;
	}
	public Impostos getImpostos() {
		return impostos;
	}
	public void setImpostos(Impostos impostos) {
		this.impostos = impostos;
	}

	public String getValorUnidadeComercializacao() {
		return valorUnidadeComercializacao;
	}

	public void setValorUnidadeComercializacao(String valorUnidadeComercializacao) {
		this.valorUnidadeComercializacao = valorUnidadeComercializacao;
	}

	public String getValorUnidadeTributavel() {
		return valorUnidadeTributavel;
	}

	public void setValorUnidadeTributavel(String valorUnidadeTributavel) {
		this.valorUnidadeTributavel = valorUnidadeTributavel;
	}
	
	
}
