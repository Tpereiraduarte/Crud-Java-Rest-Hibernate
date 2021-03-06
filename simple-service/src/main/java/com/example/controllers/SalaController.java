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

import com.example.decorator.SalaDecorator;
import com.example.models.Sala;
import com.example.repository.SalaRepository;

@Path("salas")
public class SalaController {

	private SalaRepository salaService = new SalaRepository();

	@GET
	@Produces(MediaType.APPLICATION_JSON)	
	@Path("/")
	public List<Sala> listSalas() throws SQLException {
		return salaService.readAll();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)	
	@Path("/")
	public Sala getSala(long id) throws SQLException {
		return salaService.getById(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public long create(int valor) throws SQLException  {
		return salaService.create(valor);
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)	
	@Path("/{id}")
	public Response update(@PathParam("id") long id, Sala sala) throws SQLException {
		salaService.update(id, sala);
		return Response.status(Response.Status.OK).build();
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)	
	@Path("/{id}")
	public Response delete(@PathParam("id") long id) throws SQLException {
		salaService.delete(id);
		return Response.status(Response.Status.OK).build();
	}
}
