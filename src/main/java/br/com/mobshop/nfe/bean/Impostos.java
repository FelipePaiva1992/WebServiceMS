package br.com.mobshop.nfe.bean;

public class Impostos {

	private String origem;
	private String codSituacaoOperacaoSimplesNacional;
	private String valCalcICMSRetido;
	private String valICMSRetido;
	private String codSituacaoTributavelPis;
	private String pisNaoTributavel;
	private String codSituacaoTributavelCofins;
	private String cofinsNaoTributavel;
	private String informacaoAdicionalProduto;
	
	private String valorBaseCalculoICMS;
	private String valorICMS;
	private String valorbaseCalculoICMSSobTributo;
	private String valorICMSSobTributo;
	private String valorTotalProdutos;
	private String valorFrete;
	private String valorSeguro;
	private String valorDesconto;
	private String valorImpostoImportacao;
	private String valorIPI;
	private String valorPIS;
	private String valorCofins;
	private String valorOutros;
	private String valorNotaFiscal;
	
	
	
	public Impostos(String origem, String codSituacaoOperacaoSimplesNacional,
			String valCalcICMSRetido, String valICMSRetido,
			String codSituacaoTributavelPis, String pisNaoTributavel,
			String codSituacaoTributavelCofins, String cofinsNaoTributavel,
			String informacaoAdicionalProduto, String valorBaseCalculoICMS,
			String valorICMS, String valorbaseCalculoICMSSobTributo,
			String valorICMSSobTributo, String valorTotalProdutos,
			String valorFrete, String valorSeguro, String valorDesconto,
			String valorImpostoImportacao, String valorIPI, String valorPIS,
			String valorCofins, String valorOutros, String valorNotaFiscal) {

		this.origem = origem;
		this.codSituacaoOperacaoSimplesNacional = codSituacaoOperacaoSimplesNacional;
		this.valCalcICMSRetido = valCalcICMSRetido;
		this.valICMSRetido = valICMSRetido;
		this.codSituacaoTributavelPis = codSituacaoTributavelPis;
		this.pisNaoTributavel = pisNaoTributavel;
		this.codSituacaoTributavelCofins = codSituacaoTributavelCofins;
		this.cofinsNaoTributavel = cofinsNaoTributavel;
		this.informacaoAdicionalProduto = informacaoAdicionalProduto;
		this.valorBaseCalculoICMS = valorBaseCalculoICMS;
		this.valorICMS = valorICMS;
		this.valorbaseCalculoICMSSobTributo = valorbaseCalculoICMSSobTributo;
		this.valorICMSSobTributo = valorICMSSobTributo;
		this.valorTotalProdutos = valorTotalProdutos;
		this.valorFrete = valorFrete;
		this.valorSeguro = valorSeguro;
		this.valorDesconto = valorDesconto;
		this.valorImpostoImportacao = valorImpostoImportacao;
		this.valorIPI = valorIPI;
		this.valorPIS = valorPIS;
		this.valorCofins = valorCofins;
		this.valorOutros = valorOutros;
		this.valorNotaFiscal = valorNotaFiscal;
	}
	public String getOrigem() {
		return origem;
	}
	public void setOrigem(String origem) {
		this.origem = origem;
	}
	public String getCodSituacaoOperacaoSimplesNacional() {
		return codSituacaoOperacaoSimplesNacional;
	}
	public void setCodSituacaoOperacaoSimplesNacional(
			String codSituacaoOperacaoSimplesNacional) {
		this.codSituacaoOperacaoSimplesNacional = codSituacaoOperacaoSimplesNacional;
	}
	public String getValCalcICMSRetido() {
		return valCalcICMSRetido;
	}
	public void setValCalcICMSRetido(String valCalcICMSRetido) {
		this.valCalcICMSRetido = valCalcICMSRetido;
	}
	public String getValICMSRetido() {
		return valICMSRetido;
	}
	public void setValICMSRetido(String valICMSRetido) {
		this.valICMSRetido = valICMSRetido;
	}
	public String getCodSituacaoTributavelPis() {
		return codSituacaoTributavelPis;
	}
	public void setCodSituacaoTributavelPis(String codSituacaoTributavelPis) {
		this.codSituacaoTributavelPis = codSituacaoTributavelPis;
	}
	public String getPisNaoTributavel() {
		return pisNaoTributavel;
	}
	public void setPisNaoTributavel(String pisNaoTributavel) {
		this.pisNaoTributavel = pisNaoTributavel;
	}
	public String getCodSituacaoTributavelCofins() {
		return codSituacaoTributavelCofins;
	}
	public void setCodSituacaoTributavelCofins(String codSituacaoTributavelCofins) {
		this.codSituacaoTributavelCofins = codSituacaoTributavelCofins;
	}
	public String getCofinsNaoTributavel() {
		return cofinsNaoTributavel;
	}
	public void setCofinsNaoTributavel(String cofinsNaoTributavel) {
		this.cofinsNaoTributavel = cofinsNaoTributavel;
	}
	public String getInformacaoAdicionalProduto() {
		return informacaoAdicionalProduto;
	}
	public void setInformacaoAdicionalProduto(String informacaoAdicionalProduto) {
		this.informacaoAdicionalProduto = informacaoAdicionalProduto;
	}
	public String getValorBaseCalculoICMS() {
		return valorBaseCalculoICMS;
	}
	public void setValorBaseCalculoICMS(String valorBaseCalculoICMS) {
		this.valorBaseCalculoICMS = valorBaseCalculoICMS;
	}
	public String getValorICMS() {
		return valorICMS;
	}
	public void setValorICMS(String valorICMS) {
		this.valorICMS = valorICMS;
	}
	public String getValorbaseCalculoICMSSobTributo() {
		return valorbaseCalculoICMSSobTributo;
	}
	public void setValorbaseCalculoICMSSobTributo(
			String valorbaseCalculoICMSSobTributo) {
		this.valorbaseCalculoICMSSobTributo = valorbaseCalculoICMSSobTributo;
	}
	public String getValorICMSSobTributo() {
		return valorICMSSobTributo;
	}
	public void setValorICMSSobTributo(String valorICMSSobTributo) {
		this.valorICMSSobTributo = valorICMSSobTributo;
	}
	public String getValorTotalProdutos() {
		return valorTotalProdutos;
	}
	public void setValorTotalProdutos(String valorTotalProdutos) {
		this.valorTotalProdutos = valorTotalProdutos;
	}
	public String getValorFrete() {
		return valorFrete;
	}
	public void setValorFrete(String valorFrete) {
		this.valorFrete = valorFrete;
	}
	public String getValorSeguro() {
		return valorSeguro;
	}
	public void setValorSeguro(String valorSeguro) {
		this.valorSeguro = valorSeguro;
	}
	public String getValorDesconto() {
		return valorDesconto;
	}
	public void setValorDesconto(String valorDesconto) {
		this.valorDesconto = valorDesconto;
	}
	public String getValorImpostoImportacao() {
		return valorImpostoImportacao;
	}
	public void setValorImpostoImportacao(String valorImpostoImportacao) {
		this.valorImpostoImportacao = valorImpostoImportacao;
	}
	public String getValorIPI() {
		return valorIPI;
	}
	public void setValorIPI(String valorIPI) {
		this.valorIPI = valorIPI;
	}
	public String getValorPIS() {
		return valorPIS;
	}
	public void setValorPIS(String valorPIS) {
		this.valorPIS = valorPIS;
	}
	public String getValorCofins() {
		return valorCofins;
	}
	public void setValorCofins(String valorCofins) {
		this.valorCofins = valorCofins;
	}
	public String getValorOutros() {
		return valorOutros;
	}
	public void setValorOutros(String valorOutros) {
		this.valorOutros = valorOutros;
	}
	public String getValorNotaFiscal() {
		return valorNotaFiscal;
	}
	public void setValorNotaFiscal(String valorNotaFiscal) {
		this.valorNotaFiscal = valorNotaFiscal;
	}
	
	
	
}
