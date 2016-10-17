package br.com.mobshop.ws.endpoint;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.mobshop.nfe.EmitirNotaFiscal;
import br.com.mobshop.ws.dao.VendaDao;
import br.com.mobshop.ws.model.Venda;
import br.com.mobshop.ws.model.VendaAux;

@Path("/endpointVenda")
public class EndpointVenda {
	
	VendaDao vendaDao;
	
	EmitirNotaFiscal emitirNFE;
	
	@Path("/iniciarVenda")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response iniciarVenda(@QueryParam("idVendedor")int idVendedor, @QueryParam("cpfCliente")String cpfCliente){
		vendaDao = new VendaDao();
		VendaAux venda = vendaDao.iniciarVenda(idVendedor, cpfCliente);
		if(venda == null){
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}else{
			return Response.status(Status.ACCEPTED).entity(venda).build();
		}
	}
	
	@Path("/encerrarVenda")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response encerrarVenda(@QueryParam("idVenda")Long idVenda){
		vendaDao = new VendaDao();
		VendaAux venda = vendaDao.encerrarVenda(idVenda);
		if(venda == null){
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}else{
			return Response.status(Status.ACCEPTED).entity(venda).build();
		}
	}
	
	@Path("/pagarVenda")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response pagarVenda(@QueryParam("idVenda")Long idVenda, @QueryParam("codConfirmacao")String codConfirmacao, @QueryParam("tipoPagamento")String tpPagamento){
		vendaDao = new VendaDao();
		VendaAux venda = vendaDao.pagarVenda(idVenda, codConfirmacao, tpPagamento);
		emitirNFE = new EmitirNotaFiscal();
		emitirNFE.schedullarEmissaoNota(venda);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			//e.printStackTrace();
		}
		if(venda == null){
			//vendaDao.encerrarVenda(idVenda);
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}else{
			return Response.status(Status.ACCEPTED).entity(venda).build();
		}
	}
	
	@Path("/obterUltimasVendas")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response obterUltimasVendas(){
		vendaDao = new VendaDao();
		List<Venda> vendas = vendaDao.obterUltimasVendas();
		
		if(vendas == null){
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}else{
			return Response.status(Status.ACCEPTED).entity(vendas).build();
		}
	}
	
	@Path("/entregarVenda")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response entregarVenda(@QueryParam("idVenda")Long idVenda){
		vendaDao = new VendaDao();
		Venda venda = vendaDao.entregarVenda(idVenda);
		if(venda == null){
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}else{
			return Response.status(Status.ACCEPTED).entity(venda).build();
		}
	}
	
}
