package br.com.mobshop.ws.endpoint;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.mobshop.ws.dao.VendedorDao;
import br.com.mobshop.ws.model.Vendedor;

@Path("/endpointVendedor")
public class EndpointVendedor {
	
	VendedorDao vendedorDao;
	
	@Path("/logarVendedor")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response logarVendedor(@QueryParam("idVendedor")int idVendedor, @QueryParam("vlSenha")String vlSenha){
		vendedorDao = new VendedorDao();
		Vendedor vendedor = vendedorDao.logarVendedor(idVendedor, vlSenha);
		if(vendedor == null){
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}else{
			return Response.status(Status.ACCEPTED).entity(vendedor).build();
		}
	}
	
	@Path("/cadastrarVendedor")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response cadastrarVendedor(@FormParam("idVendedor")int idVendedor, @FormParam("nmVendedor")String nmVendedor, @FormParam("vlSenha")String vlSenha){
		vendedorDao = new VendedorDao();
		Vendedor vendedor = vendedorDao.cadastrarVendedor(idVendedor, nmVendedor, vlSenha);
		if(vendedor == null){
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}else{
			return Response.status(Status.ACCEPTED).entity(vendedor).build();
		}
	}
	
}
