package br.com.mobshop.ws.endpoint;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.mobshop.ws.dao.ProdutoDao;
import br.com.mobshop.ws.model.Produto;

@Path("/endpointProduto")
public class EndpointProduto {
	
	ProdutoDao produtoDao;
	
	@Path("/encontrarProduto")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response encontrarProduto(@QueryParam("codBarra")String codBarra){
		produtoDao = new ProdutoDao();
		Produto produto = produtoDao.encontrarProduto(codBarra);
		if(produto == null){
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}else{
			return Response.status(Status.ACCEPTED).entity(produto).build();
		}
	}
	
}
