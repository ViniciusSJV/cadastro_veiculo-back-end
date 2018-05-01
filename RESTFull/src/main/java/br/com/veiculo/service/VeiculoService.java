package br.com.veiculo.service;

import javax.ws.rs.core.MediaType;

import com.sun.research.ws.wadl.Response;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/veiculoService")
public class VeiculoService {
	
	  @Path("/getVeiculoById/{id}")
	  @GET
	  @Produces(MediaType.APPLICATION_JSON)
	  public Veiculo getVeiculoById(@PathParam("id") long id) {

		Veiculo v = new Veiculo(23l, "ABC123", "modelaooo", 1998, "azul", true);

		return v;
	  }
	  
	  @Path("/getVeiculos")
	  @GET
	  @Produces(MediaType.APPLICATION_JSON)
	  public List<Veiculo> getVeiculos() {
		  
		  List<Veiculo> vs = new ArrayList<Veiculo>();
		  vs.add(new Veiculo(23l, "ABC123", "modelaooo", 1998, "azul", true));
		  vs.add(new Veiculo(23l, "ABC123", "modelaooo", 1998, "azul", true));
		  vs.add(new Veiculo(23l, "ABC123", "modelaooo", 1998, "azul", true));
		  vs.add(new Veiculo(23l, "ABC123", "modelaooo", 1998, "azul", true));
		  
		  return vs;
	  }
	  
	  @Path("/deleteVeiculo/{id}")
	  @DELETE
	  @Produces(MediaType.APPLICATION_JSON)
	  public Response deleteVeiculo(@PathParam("id") long id) {
		  System.out.println("OK");
		return null;
	  }
	  
	  @Path("/updateVeiculo")
	  @Consumes(MediaType.APPLICATION_JSON)
	  @Produces(MediaType.APPLICATION_JSON)
	  @PUT
	  public Response updateVeiculo(Veiculo veiculo) {
		  System.out.println("OK");
		return null;
	  }
	  
	  @Path("/addVeiculo")
	  @Consumes(MediaType.APPLICATION_JSON)
	  @Produces(MediaType.APPLICATION_JSON)
	  @POST
	  public Response addVeiculo(Veiculo veiculo) {
		  System.out.println("OK");
		return null;
	  }

}
