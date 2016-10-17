package br.com.mobshop.ws.endpoint;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/endpointUtil")
public class EndpointUtil {
	
	@Path("/acordarServidor")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public void acordarServidor(){
		System.out.println("Acordando Servidor...");
	}
	
}
