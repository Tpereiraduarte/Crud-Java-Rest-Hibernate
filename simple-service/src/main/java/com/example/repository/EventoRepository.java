package com.example.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.example.models.Evento;

public class EventoRepository implements IRepository<Evento>{

	private EntityManagerFactory emf;
	private EntityManager em;

	public EventoRepository() {
		emf = Persistence.createEntityManagerFactory("my-persistence");
		em = emf.createEntityManager();
	}

	public void delete(long id) {
		try {
			Evento evento = getById(id);
			remove(evento);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public List<Evento> readAll() {
		List<Evento> results = new ArrayList<Evento>();
		try {
			TypedQuery<Evento> query = em.createQuery("SELECT c FROM Evento c", Evento.class);
			results = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		return results;
	}

	@Override
	public Evento getById(long id) {
		return em.find(Evento.class, id);
	}

	@Override
	public void create(Evento evento) {
		try {
			em.getTransaction().begin();
			em.persist(evento);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		System.out.println("Dados cadastrado com sucesso");
	}

	@Override
	public void update(long id,Evento evento) {
		try {
			Evento novoevento = getById(id);
			em.getTransaction().begin();
			novoevento.setNome(evento.getNome());
			novoevento.setData_inicial(evento.getData_inicial());
			novoevento.setData_final(evento.getData_final());
			em.merge(novoevento);
			em.getTransaction().commit();
			em.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
	}

	@Override
	public void remove(Evento evento) {
		try {
			em.getTransaction().begin();
			evento = em.find(Evento.class, evento.getId());
			em.remove(evento);
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
	}
}