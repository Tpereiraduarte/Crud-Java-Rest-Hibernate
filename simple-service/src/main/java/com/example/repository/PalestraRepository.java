package com.example.repository;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.example.models.Palestra;

public class PalestraRepository implements IRepository<Palestra> {

	private EntityManagerFactory emf;
	private EntityManager em;

	public PalestraRepository() {
		emf = Persistence.createEntityManagerFactory("my-persistence");
		em = emf.createEntityManager();
	}

	public void delete(long id) {
		try {
			Palestra palestra = getById(id);
			remove(palestra);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public List<Palestra> readAll() {
		List<Palestra> results = new ArrayList<Palestra>();
		try {
			TypedQuery<Palestra> query = em.createQuery("SELECT c FROM Palestra c", Palestra.class);
			results = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		return results;
	}

	@Override
	public Palestra getById(long id) {
		return em.find(Palestra.class, id);
	}

	@Override
	public void create(Palestra palestra) {
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
	public void update(long id,Palestra palestra) {
		try {
			Palestra novapalestra = getById(id);
			em.getTransaction().begin();
			novapalestra.setTema(palestra.getTema());
			novapalestra.setDescricao(palestra.getDescricao());
			novapalestra.setData(palestra.getData());
			novapalestra.setPalestrante(palestra.getPalestrante());
			novapalestra.setEventoPalestras(palestra.getEventoPalestras());
			em.merge(novapalestra);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
	}

	@Override
	public void remove(Palestra palestra) {
		try {
			em.getTransaction().begin();
			palestra = em.find(Palestra.class, palestra.getId());
			em.remove(palestra);
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
	}
}