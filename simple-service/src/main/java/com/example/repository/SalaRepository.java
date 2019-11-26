
package com.example.repository;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.example.decorator.SalaDecorator;
import com.example.models.SalaComputador;
import com.example.models.SalaProjetor;
import com.example.models.SalaSimples;

public class SalaRepository implements ISalaRepository<SalaDecorator> {

	private EntityManagerFactory emf;
	private EntityManager em;

	public SalaRepository() {
		emf = Persistence.createEntityManagerFactory("my-persistence");
		em = emf.createEntityManager();
	}

	public void delete(long id) {
		try {
			SalaDecorator sala = getById(id);
			remove(sala);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public List<SalaDecorator> readAll() {
		List<SalaDecorator> results = new ArrayList<SalaDecorator>();
		try {
			TypedQuery<SalaDecorator> query = em.createQuery("SELECT c FROM SalaDecorator c", SalaDecorator.class);
			results = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		return results;
	}

	@Override
	public SalaDecorator getById(long id) {
		return em.find(SalaDecorator.class, id);
	}

	@Override
	public void create(long valor) {
		try {
			em.getTransaction().begin();
			SalaDecorator sala = null;
			if (valor == 0) {
				sala = new SalaDecorator(new SalaSimples(sala));
			} else if (valor == 1) {
				sala = new SalaDecorator(new SalaSimples(new SalaProjetor(sala)));
			} else {
				sala = new SalaDecorator(new SalaSimples(new SalaProjetor(new SalaComputador(sala))));
			}
			em.persist(sala);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		System.out.println("Dados cadastrado com sucesso");
	}

	@Override
	public void update(long id, SalaDecorator sala) {
		try {
			SalaDecorator novapalestra = getById(id);
			em.getTransaction().begin();
			em.merge(novapalestra);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
	}

	@Override
	public void remove(SalaDecorator sala) {
		try {
			em.getTransaction().begin();
			sala = em.find(SalaDecorator.class, sala.getId());
			em.remove(sala);
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
	}
}