package com.example.repository;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.example.models.UsuarioPalestra;

public class UsuarioPalestraRepository implements IRepository<UsuarioPalestra> {

	private EntityManagerFactory emf;
	private EntityManager em;

	public UsuarioPalestraRepository() {
		emf = Persistence.createEntityManagerFactory("my-persistence");
		em = emf.createEntityManager();
	}

	public void delete(long id) {
		try {
			UsuarioPalestra usuariopalestra = getById(id);
			remove(usuariopalestra);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public List<UsuarioPalestra> readAll() {
		List<UsuarioPalestra> results = new ArrayList<UsuarioPalestra>();
		try {
			TypedQuery<UsuarioPalestra> query = em.createQuery("SELECT c FROM UsuarioPalestra c", UsuarioPalestra.class);
			results = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		return results;
	}

	@Override
	public UsuarioPalestra getById(long id) {
		return em.find(UsuarioPalestra.class, id);
	}

	@Override
	public void create(UsuarioPalestra palestra) {
		try {
			em.getTransaction().begin();
			em.persist(palestra);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		System.out.println("Dados cadastrado com sucesso");
	}

	@Override
	public void update(long id,UsuarioPalestra usuariopalestra) {
		try {
			UsuarioPalestra novousuariopalestra = getById(id);
			em.getTransaction().begin();
			novousuariopalestra.setPalestra(usuariopalestra.getPalestra());
			novousuariopalestra.setUsuario(usuariopalestra.getUsuario());
			em.merge(novousuariopalestra);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
	}

	@Override
	public void remove(UsuarioPalestra usuariopalestra) {
		try {
			em.getTransaction().begin();
			usuariopalestra = em.find(UsuarioPalestra.class, usuariopalestra.getId());
			em.remove(usuariopalestra);
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
	}
}