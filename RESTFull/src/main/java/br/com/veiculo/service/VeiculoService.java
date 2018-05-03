package br.com.veiculo.service;

import javax.ws.rs.core.MediaType;

import com.sun.research.ws.wadl.Response;

import br.com.veiculo.validador.GenericException;
import br.com.veiculo.validador.Validator;

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
		return criarObjFake();
	  }

	private Veiculo criarObjFake() {
		return new Veiculo(23l, "CVF8765", "modelaooo", 1998, "azul", true);
	}
	  
	  @Path("/getVeiculos")
	  @GET
	  @Produces(MediaType.APPLICATION_JSON)
	  public List<Veiculo> getVeiculos() {
		  return montarListaFake();
	  }

	private List<Veiculo> montarListaFake() {
		List<Veiculo> vs = new ArrayList<Veiculo>();
		  vs.add(new Veiculo(23l, "ABC1234", "modelaooo1", 1998, "azul", true));
		  vs.add(new Veiculo(23l, "ASD1253", "modelaooo2", 1998, "branco", false));
		  vs.add(new Veiculo(23l, "WSA3455", "modelaooo2", 1998, "amarelo", true));
		  vs.add(new Veiculo(23l, "CVF8765", "modelaooo3", 1998, "preto", false));
		  vs.add(new Veiculo(23l, "CFG1235", "modelaooo4", 1998, "rosa", true));
		  vs.add(new Veiculo(23l, "OLA7895", "modelaooo5", 1998, "marom", false));
		  vs.add(new Veiculo(23l, "FOD1565", "modelaooo6", 1998, "roxo", true));
		  vs.add(new Veiculo(23l, "NET2135", "modelaooo6", 1998, "azul", false));
		  
		  return vs;
	}
	  
	  @Path("/deleteVeiculo/{id}")
	  @DELETE
	  @Produces(MediaType.APPLICATION_JSON)
	  public Response deleteVeiculo(@PathParam("id") long id) {
		  //DELETE DAO
		  return null;
	  }
	  
	  @Path("/updateVeiculo")
	  @Consumes(MediaType.APPLICATION_JSON)
	  @Produces(MediaType.APPLICATION_JSON)
	  @PUT
	  public Response updateVeiculo(Veiculo veiculo) {
		  try {
			  	// se os campos foram validos 
		        if (Validator.validar(veiculo)) {
		            //update DAO
		        }
		    } catch (GenericException | IllegalAccessException | IllegalArgumentException | ClassNotFoundException | NoSuchFieldException e) {
		     
		        e.printStackTrace();
		    }
		  return null;
	  }
	  
	  @Path("/addVeiculo")
	  @Consumes(MediaType.APPLICATION_JSON)
	  @Produces(MediaType.APPLICATION_JSON)
	  @POST
	  public Response addVeiculo(Veiculo veiculo) {
		  try {
			// se os campos foram validos 
		        if (Validator.validar(veiculo)) {
		    		//PERSIST DAO
		        }
		    } catch (GenericException | IllegalAccessException | IllegalArgumentException | ClassNotFoundException | NoSuchFieldException e) {
		     
		        e.printStackTrace();
		    }
		  return null;
	  }

}
