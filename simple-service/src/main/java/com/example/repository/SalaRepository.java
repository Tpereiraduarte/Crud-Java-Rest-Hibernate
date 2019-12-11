
package com.example.repository;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import com.example.models.Sala;
import com.example.models.SalaComputador;
import com.example.models.SalaProjetor;
import com.example.models.SalaSimples;

public class SalaRepository implements ISalaRepository<Sala> {

	private EntityManagerFactory emf;
	private EntityManager em;
	private SalaSimples SalaSimples;

	public SalaRepository() {
		emf = Persistence.createEntityManagerFactory("my-persistence");
		em = emf.createEntityManager();
	}

	public void delete(long id) {
		try {
			Sala sala = getById(id);
			remove(sala);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public List<Sala> readAll() {
		List<Sala> results = new ArrayList<Sala>();
		try {
			TypedQuery<Sala> query = em.createQuery("SELECT c FROM Sala c", Sala.class);
			results = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		return results;
	}

	@Override
	public Sala getById(long id) {
		return em.find(Sala.class, id);
	}

	public Sala getSala(Sala sala) {
		SalaSimples salasimples = new SalaSimples(sala);
		sala.setQuantidadeCadeira(salasimples.getQuantidadeCadeira());
		sala.setQuantidadeProjetor(salasimples.getQuantidadeProjetor());
		sala.setQuantidadeComputador(salasimples.getQuantidadeComputador());
		return sala;
	}
	
	public Sala getProjetor(Sala sala) {
		SalaProjetor salaprojetor = new SalaProjetor(sala);
		sala.setQuantidadeCadeira(salaprojetor.getQuantidadeCadeira());
		sala.setQuantidadeProjetor(salaprojetor.getQuantidadeProjetor());
		sala.setQuantidadeComputador(salaprojetor.getQuantidadeComputador());
		return sala;
	}
	
	public Sala getSalaPc(Sala sala) {
		SalaComputador salapc = new SalaComputador(sala);
		sala.setQuantidadeCadeira(salapc.getQuantidadeCadeira());
		sala.setQuantidadeProjetor(salapc.getQuantidadeProjetor());
		sala.setQuantidadeComputador(salapc.getQuantidadeComputador());
		return sala;
	}
	@Override
	public long create(int valor) {
		long resposta = 0;
		try {
			em.getTransaction().begin();
			Sala sala = new Sala();
			Sala salasimples = null;
			salasimples = getSala(sala);
			
			switch (valor) {
			case 1:
				salasimples = getSalaPc(sala);								
				break;
			case 2:	
				salasimples = getProjetor(sala);							
				break;
			case 3:
				salasimples = getProjetor(sala);
				salasimples = getSalaPc(sala);	
				break;
			default:
				salasimples = getSala(sala);
				break;
			}
			
			em.persist(salasimples);
			em.getTransaction().commit();
			resposta =  salasimples.getId();
System.out.println(resposta);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		em.close();
		System.out.println("Dados cadastrado com sucesso");
		return resposta;
	}

	@Override
	public void update(long id, Sala sala) {
		try {
			Sala novapalestra = getById(id);
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
	public void remove(Sala sala) {
		try {
			em.getTransaction().begin();
			em.remove(sala);
			em.getTransaction().commit();
		} catch (Exception ex) {
			ex.printStackTrace();
			em.getTransaction().rollback();
		}
	}
}