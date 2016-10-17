package br.com.mobshop.nfe.bean;

import java.util.List;

public class DocumentoFiscal {
	
	private Emitente emitente;
	private Destinatario destinatario;
	private Nota nota;
	private List<Produto> produtos;
	Transporte transporte;
	InformacoesAdicionais informacoesAdicionais;
	Impostos impostos;
	
	public Emitente getEmitente() {
		return emitente;
	}
	public void setEmitente(Emitente emitente) {
		this.emitente = emitente;
	}
	public Destinatario getDestinatario() {
		return destinatario;
	}
	public void setDestinatario(Destinatario destinatario) {
		this.destinatario = destinatario;
	}
	public Nota getNota() {
		return nota;
	}
	public void setNota(Nota nota) {
		this.nota = nota;
	}
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	public Transporte getTransporte() {
		return transporte;
	}
	public void setTransporte(Transporte transporte) {
		this.transporte = transporte;
	}
	public InformacoesAdicionais getInformacoesAdicionais() {
		return informacoesAdicionais;
	}
	public void setInformacoesAdicionais(InformacoesAdicionais informacoesAdicionais) {
		this.informacoesAdicionais = informacoesAdicionais;
	}
	public Impostos getImpostos() {
		return impostos;
	}
	public void setImpostos(Impostos impostos) {
		this.impostos = impostos;
	}
}
