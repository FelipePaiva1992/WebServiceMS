package br.com.mobshop.ws.endpoint;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import br.com.mobshop.ws.dao.ClienteDao;
import br.com.mobshop.ws.model.Cliente;

@Path("/endpointCliente")
public class EndpointCliente {
	
	ClienteDao clienteDao;
	
	@Path("/encontrarCliente")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response encontrarCliente(@QueryParam("cpfCliente")String cpfCliente){
		clienteDao = new ClienteDao();
		Cliente cliente = clienteDao.encontrarCliente(cpfCliente);
		if(cliente == null){
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}else{
			return Response.status(Status.ACCEPTED).entity(cliente).build();
		}
	}
	
	@Path("/inserirCliente")
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response inserirCliente(@QueryParam("nmCliente")String nmCliente, @QueryParam("cpfCliente")String cpfCliente, @QueryParam("logradouro")String logradouro, @QueryParam("endereco")String endereco, @QueryParam("numero")String numero, @QueryParam("bairro")String bairro, @QueryParam("cidade")String cidade, @QueryParam("estado")String estado, @QueryParam("vlTelefone")String vlTelefone, @QueryParam("email")String email, @QueryParam("dtNascimento")String dtNascimento){
		clienteDao = new ClienteDao();
		Cliente cliente = clienteDao.inserirCliente(nmCliente, cpfCliente, logradouro, endereco, numero, bairro, cidade, estado, vlTelefone, email, dtNascimento);
		if(cliente == null){
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}else{
			return Response.status(Status.ACCEPTED).entity(cliente).build();
		}
	}
	
}
