package br.com.mobshop.ws.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the venda database table.
 * 
 */
@Entity
@Table(name="venda")
@NamedQuery(name="venda.findAll", query="SELECT v FROM Venda v")
@XmlRootElement
public class Venda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_VENDA")
	private Long idVenda;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="DT_VENDA")
	private Date dtVenda;

	@Column(name="VF_ENTREGE")
	private Boolean vfEntrege;

	@Column(name="VF_PAGO")
	private Boolean vfPago;
	
	@Column(name="VF_CANCELADO")
	private Boolean vfCancelado;
	
	@Column(name="VL_CODIGO_CONFIRMACAO")
	private String vlCodigoConfirmacao;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="FK_ID_CLIENTE")
	private Cliente cliente;

	//bi-directional many-to-one association to Vendedor
	@ManyToOne
	@JoinColumn(name="FK_ID_VENDEDOR")
	private Vendedor vendedor;

	//bi-directional many-to-one association to VendaItem
	@OneToMany(fetch = FetchType.EAGER,mappedBy="venda")
	private List<VendaItem> vendaItems;
	
	//bi-directional many-to-one association to tipoPagamento
	@ManyToOne
	@JoinColumn(name="FK_ID_TIPO_PAGAMENTO")
	private TipoPagamento tipoPagamento;

	public Venda() {
	}

	public Long getIdVenda() {
		return this.idVenda;
	}

	public void setIdVenda(Long idVenda) {
		this.idVenda = idVenda;
	}

	public Date getDtVenda() {
		return this.dtVenda;
	}

	public void setDtVenda(Date dtVenda) {
		this.dtVenda = dtVenda;
	}

	public Boolean getVfEntrege() {
		return this.vfEntrege;
	}

	public void setVfEntrege(Boolean vfEntrege) {
		this.vfEntrege = vfEntrege;
	}

	public Boolean getVfPago() {
		return this.vfPago;
	}

	public void setVfPago(Boolean vfPago) {
		this.vfPago = vfPago;
	}	

	public Boolean getVfCancelado() {
		return vfCancelado;
	}

	public void setVfCancelado(Boolean vfCancelado) {
		this.vfCancelado = vfCancelado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vendedor getVendedor() {
		return this.vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	//@JsonIgnore
	public List<VendaItem> getVendaItems() {
		return this.vendaItems;
	}

	public void setVendaItems(List<VendaItem> vendaItems) {
		this.vendaItems = vendaItems;
	}	

	public String getVlCodigoConfirmacao() {
		return vlCodigoConfirmacao;
	}

	public void setVlCodigoConfirmacao(String vlCodigoConfirmacao) {
		this.vlCodigoConfirmacao = vlCodigoConfirmacao;
	}

	public TipoPagamento getTipoPagamento() {
		return tipoPagamento;
	}

	public void setTipoPagamento(TipoPagamento tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
	}

	public VendaItem addVendaItem(VendaItem vendaItem) {
		getVendaItems().add(vendaItem);
		vendaItem.setVenda(this);

		return vendaItem;
	}

	public VendaItem removeVendaItem(VendaItem vendaItem) {
		getVendaItems().remove(vendaItem);
		vendaItem.setVenda(null);

		return vendaItem;
	}

}