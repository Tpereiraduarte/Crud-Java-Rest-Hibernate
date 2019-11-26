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

import com.example.models.UsuarioPalestra;
import com.example.repository.UsuarioPalestraRepository;

@Path("usuariopalestras")
public class UsuarioPalestraController {

	private UsuarioPalestraRepository usuarioPalestraService = new UsuarioPalestraRepository();

	@GET
	@Produces(MediaType.APPLICATION_JSON)	
	@Path("/")
	public List<UsuarioPalestra> listUsuarios() throws SQLException {
		return usuarioPalestraService.readAll();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)	
	@Path("/{id}")
	public UsuarioPalestra getUsuarioPalestra(@PathParam("id") long id) throws SQLException {
		return usuarioPalestraService.getById(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/")
	public Response create(UsuarioPalestra usuariopalestra) throws SQLException  {
		usuarioPalestraService.create(usuariopalestra);
		return Response.status(Response.Status.OK).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)	
	@Path("/{id}")
	public Response update(@PathParam("id") long id, UsuarioPalestra usuariopalestra) throws SQLException {
		usuarioPalestraService.update(id, usuariopalestra);
		return Response.status(Response.Status.OK).build();
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)	
	@Path("/{id}")
	public Response delete(@PathParam("id") long id) throws SQLException {
		usuarioPalestraService.delete(id);
		return Response.status(Response.Status.OK).build();
	}
}
