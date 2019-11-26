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

import com.example.models.Evento;
import com.example.repository.EventoRepository;

@Path("eventos")
public class EventoController {

	private EventoRepository eventoService = new EventoRepository();

	@GET
	@Produces(MediaType.APPLICATION_JSON)	
	@Path("/")
	public List<Evento> listEventos() throws SQLException {
		return eventoService.readAll();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)	
	@Path("/{id}")
	public Evento getEvento(@PathParam("id") long id) throws SQLException {
		return eventoService.getById(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response create(Evento evento) throws SQLException  {
		eventoService.create(evento);
		return Response.status(Response.Status.OK).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)	
	@Path("/{id}")
	public Response update(@PathParam("id") long id, Evento evento) throws SQLException {
		eventoService.update(id, evento);
		return Response.status(Response.Status.OK).build();
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)	
	@Path("/{id}")
	public Response delete(@PathParam("id") long id) throws SQLException {
		eventoService.delete(id);
		return Response.status(Response.Status.OK).build();
	}
}