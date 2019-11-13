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

import com.example.models.Usuario;
import com.example.repository.UsuarioRepository;

@Path("usuarios")
public class UsuarioController {

	private UsuarioRepository usuarioService = new UsuarioRepository();

	@GET
	@Produces(MediaType.APPLICATION_JSON)	
	@Path("/")
	public List<Usuario> listUsuarios() throws SQLException {
		return usuarioService.readAll();
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
	public Response create(Usuario usuario) throws SQLException  {
		usuarioService.create(usuario);
		return Response.status(Response.Status.OK).build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)	
	@Path("/{id}")
	public Response update(@PathParam("id") long id, Usuario usuario) throws SQLException {
		usuarioService.update(id, usuario);
		return Response.status(Response.Status.OK).build();
	}

	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)	
	@Path("/{id}")
	public Response delete(@PathParam("id") long id) throws SQLException {
		usuarioService.delete(id);
		return Response.status(Response.Status.OK).build();
	}
}