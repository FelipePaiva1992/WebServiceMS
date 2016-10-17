package br.com.mobshop.nfe.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Nota {

	private String codigoUf;
	private String natOperacao;
	private String indPagamento;
	private String modeloDocumento;
	private String serieDocumeno;
	private String numeroDocumento;
	private String dtEmissao;
	private String dtSaida;
	private String horaSaida;
	private String tipoNota;
	private String codMunicipio;
	private String tipoImplementacao;
	private String formaEmissao;
	private String codDV;
	private String tipoAmbiente;	
	private String finalidadeNota;
	private String processoEmissao;
	private String versaoProcesso;
	
	SimpleDateFormat formatoAnoMesDia = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat formatoHoraMinSeg = new SimpleDateFormat("hh:mm:ss");
	
	public Nota(String codigoUf, String natOperacao,
			String indPagamento, String modeloDocumento, String serieDocumeno,
			String numeroDocumento, String dtEmissao, String dtSaida,
			String horaSaida, String tipoNota, String codMunicipio,
			String tipoImplementacao, String formaEmissao, String codDV,
			String tipoAmbiente, String finalidadeNota, String processoEmissao,
			String versaoProcesso) {

		this.codigoUf = codigoUf;
		this.natOperacao = natOperacao;
		this.indPagamento = indPagamento;
		this.modeloDocumento = modeloDocumento;
		this.serieDocumeno = serieDocumeno;
		this.numeroDocumento = numeroDocumento;
		this.dtEmissao = dtEmissao;
		this.dtSaida = dtSaida;
		this.horaSaida = horaSaida;
		this.tipoNota = tipoNota;
		this.codMunicipio = codMunicipio;
		this.tipoImplementacao = tipoImplementacao;
		this.formaEmissao = formaEmissao;
		this.codDV = codDV;
		this.tipoAmbiente = tipoAmbiente;
		this.finalidadeNota = finalidadeNota;
		this.processoEmissao = processoEmissao;
		this.versaoProcesso = versaoProcesso;

	}
	
	public String getCodigoUf() {
		return codigoUf;
	}
	public void setCodigoUf(String codigoUf) {
		this.codigoUf = codigoUf;
	}
	public String getNatOperacao() {
		return natOperacao;
	}
	public void setNatOperacao(String natOperacao) {
		this.natOperacao = natOperacao;
	}
	public String getIndPagamento() {
		return indPagamento;
	}
	public void setIndPagamento(String indPagamento) {
		this.indPagamento = indPagamento;
	}
	public String getModeloDocumento() {
		return modeloDocumento;
	}
	public void setModeloDocumento(String modeloDocumento) {
		this.modeloDocumento = modeloDocumento;
	}
	public String getSerieDocumeno() {
		return serieDocumeno;
	}
	public void setSerieDocumeno(String serieDocumeno) {
		this.serieDocumeno = serieDocumeno;
	}
	public String getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	public String getDtEmissao() {
		return dtEmissao;
	}
	public void setDtEmissao(Date dt) {
		this.dtEmissao = formatoAnoMesDia.format(dt);
	}
	public String getDtSaida() {
		return dtSaida;
	}
	public void setDtSaida(Date dt) {
		this.dtSaida = formatoAnoMesDia.format(dt);
	}
	public String getHoraSaida() {
		return horaSaida;
	}
	public void setHoraSaida(Date hora) {
		this.horaSaida = formatoHoraMinSeg.format(hora);
	}
	public String getTipoNota() {
		return tipoNota;
	}
	public void setTipoNota(String tipoNota) {
		this.tipoNota = tipoNota;
	}
	public String getCodMunicipio() {
		return codMunicipio;
	}
	public void setCodMunicipio(String codMunicipio) {
		this.codMunicipio = codMunicipio;
	}
	public String getTipoImplementacao() {
		return tipoImplementacao;
	}
	public void setTipoImplementacao(String tipoImplementacao) {
		this.tipoImplementacao = tipoImplementacao;
	}
	public String getFormaEmissao() {
		return formaEmissao;
	}
	public void setFormaEmissao(String formaEmissao) {
		this.formaEmissao = formaEmissao;
	}
	public String getCodDV() {
		return codDV;
	}
	public void setCodDV(String codDV) {
		this.codDV = codDV;
	}
	public String getTipoAmbiente() {
		return tipoAmbiente;
	}
	public void setTipoAmbiente(String tipoAmbiente) {
		this.tipoAmbiente = tipoAmbiente;
	}
	public String getFinalidadeNota() {
		return finalidadeNota;
	}
	public void setFinalidadeNota(String finalidadeNota) {
		this.finalidadeNota = finalidadeNota;
	}
	public String getProcessoEmissao() {
		return processoEmissao;
	}
	public void setProcessoEmissao(String processoEmissao) {
		this.processoEmissao = processoEmissao;
	}
	public String getVersaoProcesso() {
		return versaoProcesso;
	}
	public void setVersaoProcesso(String versaoProcesso) {
		this.versaoProcesso = versaoProcesso;
	}
	
}
