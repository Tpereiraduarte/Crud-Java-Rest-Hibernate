package com.example.models;

import java.util.Date;
import java.util.Set;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "eventos")
public class Evento {
	@Id
	@Column(name = "id_evento", updatable = false, nullable = false)
	private long id;
		
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "data_inicial")
	private Date data_inicial;
	
	@Column(name = "data_final")
	private Date data_final;

	public Evento() {
		
	}
	
	@OneToMany(mappedBy = "eventoPalestras")
	public Set<Evento> eventoPalestras;
	
	
	public Evento(long id, String nome, Date data_inicial, Date data_final) {
		this.id = id;
		this.nome = nome;
		this.data_inicial = data_inicial;
		this.data_final = data_final;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getData_inicial() {
		return data_inicial;
	}

	public void setData_inicial(Date data_inicial) {
		this.data_inicial = data_inicial;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData_final() {
		return data_final;
	}

	public void setData_final(Date data_final) {
		this.data_final = data_final;
	}
	
	@JsonbTransient
	public Set<Evento> getEventoPalestras() {
		return eventoPalestras;
	}

	public void setEventoPalestras(Set<Evento> eventoPalestras) {
		this.eventoPalestras = eventoPalestras;
	}
}
