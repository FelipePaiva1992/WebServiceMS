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
 * The persistent class for the perfil_acesso database table.
 * 
 */
@Entity
@Table(name="perfil_acesso")
@NamedQuery(name="PerfilAcesso.findAll", query="SELECT p FROM PerfilAcesso p")
@XmlRootElement
public class PerfilAcesso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="ID_PERFIL_ACESSO")
	private Long idPerfilAcesso;

	@Column(name="NM_PERFIL_ACESSO")
	private String nmPerfilAcesso;

	//bi-directional many-to-one association to AcessoSistema
	@OneToMany(mappedBy="perfilAcesso")
	private List<AcessoSistema> acessoSistemas;

	public PerfilAcesso() {
	}

	public Long getIdPerfilAcesso() {
		return this.idPerfilAcesso;
	}

	public void setIdPerfilAcesso(Long idPerfilAcesso) {
		this.idPerfilAcesso = idPerfilAcesso;
	}

	public String getNmPerfilAcesso() {
		return this.nmPerfilAcesso;
	}

	public void setNmPerfilAcesso(String nmPerfilAcesso) {
		this.nmPerfilAcesso = nmPerfilAcesso;
	}

	@JsonIgnore
	public List<AcessoSistema> getAcessoSistemas() {
		return this.acessoSistemas;
	}

	public void setAcessoSistemas(List<AcessoSistema> acessoSistemas) {
		this.acessoSistemas = acessoSistemas;
	}

	public AcessoSistema addAcessoSistema(AcessoSistema acessoSistema) {
		getAcessoSistemas().add(acessoSistema);
		acessoSistema.setPerfilAcesso(this);

		return acessoSistema;
	}

	public AcessoSistema removeAcessoSistema(AcessoSistema acessoSistema) {
		getAcessoSistemas().remove(acessoSistema);
		acessoSistema.setPerfilAcesso(null);

		return acessoSistema;
	}

}