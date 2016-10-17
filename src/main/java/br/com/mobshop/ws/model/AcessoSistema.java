package br.com.mobshop.ws.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;


/**
 * The persistent class for the acesso_sistema database table.
 * 
 */
@Entity
@Table(name="acesso_sistema")
@NamedQuery(name="AcessoSistema.findAll", query="SELECT a FROM AcessoSistema a")
@XmlRootElement
public class AcessoSistema implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="US_USUARIO")
	private String usUsuario;

	@Column(name="NM_USUARIO")
	private String nmUsuario;

	@Column(name="VL_SENHA")
	private String vlSenha;

	//bi-directional many-to-one association to PerfilAcesso
	@ManyToOne
	@JoinColumn(name="FK_ID_PERFIL_ACESSO")
	private PerfilAcesso perfilAcesso;

	public AcessoSistema() {
	}

	public String getUsUsuario() {
		return this.usUsuario;
	}

	public void setUsUsuario(String usUsuario) {
		this.usUsuario = usUsuario;
	}

	public String getNmUsuario() {
		return this.nmUsuario;
	}

	public void setNmUsuario(String nmUsuario) {
		this.nmUsuario = nmUsuario;
	}

	public String getVlSenha() {
		return this.vlSenha;
	}

	public void setVlSenha(String vlSenha) {
		this.vlSenha = vlSenha;
	}

	public PerfilAcesso getPerfilAcesso() {
		return this.perfilAcesso;
	}

	public void setPerfilAcesso(PerfilAcesso perfilAcesso) {
		this.perfilAcesso = perfilAcesso;
	}

}