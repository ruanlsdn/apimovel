package br.com;

import java.util.List;

import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/imovel")
public class ImovelResource {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("getAll")
	public Response getAll() {
		List<Imovel> imoveis = Imovel.listAll();
		return Response.ok(imoveis).build();
	}
	
	@GET
	@Path("getByCidade/{cidade}")
	@Produces(MediaType.APPLICATION_JSON)
	public Imovel getByCidade(@PathParam("cidade") String cidade) {
		Imovel imovel = Imovel.find("cidade = ?1", cidade).singleResult();
		return imovel;
	}
	
	@POST 
	@Transactional 
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("create")
	public void create (Imovel imovel) {
		Imovel.persist(imovel);
	}
}
