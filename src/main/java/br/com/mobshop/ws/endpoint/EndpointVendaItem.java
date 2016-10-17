package br.com.mobshop.ws.endpoint;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.mobshop.ws.dao.VendaItemDao;
import br.com.mobshop.ws.model.VendaItem;

@Path("/endpointVendaItem")
public class EndpointVendaItem {
	
	VendaItemDao vendaItemDao;
	
	@Path("/inserirProdutoNaVenda")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response inserirProdutoNaVenda(@QueryParam("idProduto")String idProduto, @QueryParam("idVenda")String idVenda, @QueryParam("vlQuantidade")int vlQuantidade){
		vendaItemDao = new VendaItemDao();
		VendaItem vendaItem = vendaItemDao.inserirProdutoNaVenda(idProduto, idVenda, vlQuantidade);
		if(vendaItem == null){
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}else{
			return Response.status(Status.ACCEPTED).entity(vendaItem).build();
		}
	}
	
	@Path("/encontrarProdutosNaVenda")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response encontrarProdutosNaVenda(@QueryParam("idVenda")String idVenda){
		vendaItemDao = new VendaItemDao();
		List<VendaItem> vendaItems = vendaItemDao.encontrarProdutosNaVenda(idVenda);
		if(vendaItems == null){
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}else{
			return Response.status(Status.ACCEPTED).entity(vendaItems).build();
		}
	}
	
	@Path("/removerProdutoDaVenda")
	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response removerProdutoDaVenda(@QueryParam("idProduto")String idProduto, @QueryParam("idVenda")String idVenda){
		vendaItemDao = new VendaItemDao();
		VendaItem vendaItem = vendaItemDao.removerProdutoDaVenda(idProduto, idVenda);
		if(vendaItem == null){
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}else{
			return Response.status(Status.ACCEPTED).entity(vendaItem).build();
		}
	}
	
}
