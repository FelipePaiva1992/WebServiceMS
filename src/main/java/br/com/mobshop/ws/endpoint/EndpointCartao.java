package br.com.mobshop.ws.endpoint;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.mobshop.adyen.Payment;
import br.com.mobshop.ws.model.StatusAdyen;

@Path("/endpointCartao")
public class EndpointCartao {
	

	@Path("/autorizacaoVenda")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response autorizacaoVenda(){
		Payment payment = new Payment();
		StatusAdyen statusAdyen = payment.pagamentoCartaoDebito();
		if(statusAdyen == null){
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}else{
			return Response.status(Status.ACCEPTED).entity(statusAdyen).build();
		}
	}

	
}
