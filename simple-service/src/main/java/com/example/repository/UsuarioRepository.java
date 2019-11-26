package com.example.repository;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.example.models.Usuario;

public class UsuarioRepository implements IRepository<Usuario> {

	private EntityManagerFactory emf;
	private EntityManager em;

	public UsuarioRepository() {
		emf = Persistence.createEntityManagerFactory("my-persistence");
		em = emf.createEntityManager();
	}

	public void delete(long id) {
		try {
			Usuario usuario = getById(id);
			remove(usuario);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public Usuario listarUm(long id) {
		try {
			em.getTransaction().begin();
			Usuario usuario = em.find(Usuario.class, id);
			em.close();
			System.out.println(usuario.toString());
			return usuario;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<Usuario> readAll() {
		List<Usuario> results = new ArrayList<Usuario>();
		try {
			TypedQuery<Usuario> query = em.createQuery("SELECT c FROM Usuario c", Usuario.class);
			results = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		return results;
	}

	@Override
	public Usuario getById(long id) {
		return em.find(Usuario.class, id);
	}

	@Override
	public void create(Usuario usuario) {
		try {
			em.getTransaction().begin();
			em.persist(usuario);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		System.out.println("Dados cadastrado com sucesso");
	}

	@Override
	public void update(long id,Usuario usuario) {
		try {
			Usuario novousuario = getById(id);
			em.getTransaction().begin();
			novousuario.setNome(usuario.getNome());
			novousuario.setSobrenome(usuario.getSobrenome());
			novousuario.setEmail(usuario.getEmail());
			novousuario.setSenha(usuario.getSenha());
			em.merge(novousuario);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
	}

	@Override
	public void remove(Usuario usuario) {
		try {
			em.getTransaction().begin();
			usuario = em.find(Usuario.class, usuario.getId());
			em.remove(usuario);
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
	}
}