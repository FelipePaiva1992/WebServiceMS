package br.com.mobshop.ws.endpoint;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.mobshop.ws.dao.AcessoSistemaDao;
import br.com.mobshop.ws.model.AcessoSistema;

@Path("/endpointAcesso")
public class EndpointAcesso {
		
	AcessoSistemaDao acessoSistemaDao;
	
	@Path("/consultaUsuarioSenha")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response consultaUsuarioSenha(@FormParam("nmUsuario")String nmUsuario, @FormParam("vlSenha")String vlSenha){
		acessoSistemaDao = new AcessoSistemaDao();
		AcessoSistema acessoSistema = acessoSistemaDao.logarUsuarioSenha(nmUsuario, vlSenha);
		if(acessoSistema == null){
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}else{
			return Response.status(Status.ACCEPTED).entity(acessoSistema).build();
		}
	}
	
	@Path("/criarUsuarioSistema")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response criarUsuarioSistema(@FormParam("usUsuario")String usUsuario, @FormParam("nmUsuario")String nmUsuario, @FormParam("vlSenha")String vlSenha, @FormParam("idPerfil")String idPerfil){
		acessoSistemaDao = new AcessoSistemaDao();
		AcessoSistema acessoSistema = acessoSistemaDao.criarUsuarioSistema(usUsuario, nmUsuario, vlSenha, idPerfil);
		if(acessoSistema == null){
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}else{
			return Response.status(Status.ACCEPTED).entity(acessoSistema).build();
		}
	}

	
}
