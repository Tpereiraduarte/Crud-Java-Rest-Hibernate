package com.example.controllers;

import java.sql.SQLException;
import java.util.List;

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

import com.example.models.Palestra;
import com.example.repository.PalestraRepository;

@Path("palestras")
public class PalestraController {

	private PalestraRepository palestraService = new PalestraRepository();

	@GET
	@Produces(MediaType.APPLICATION_JSON)	
	@Path("/")
	public List<Palestra> listPalestras() throws SQLException {
		return palestraService.readAll();
	}

	/*@GET
	@Produces(MediaType.APPLICATION_JSON)	
	@Path("{id}/")
	public List<Pessoa> getPessoa(@PathParam("id") long id) throws SQLException {
		return pessoaService.getPessoa(id);
	}*/

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response create(Palestra palestra) throws SQLException  {
		palestraService.create(palestra);
		return Response.status(Response.Status.OK).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)	
	@Path("/{id}")
	public Response update(@PathParam("id") long id, Palestra palestra) throws SQLException {
		palestraService.update(id, palestra);
		return Response.status(Response.Status.OK).build();
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)	
	@Path("/{id}")
	public Response delete(@PathParam("id") long id) throws SQLException {
		palestraService.delete(id);
		return Response.status(Response.Status.OK).build();
	}
}
