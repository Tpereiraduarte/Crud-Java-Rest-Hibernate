package com.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "paletras")
public class Palestra {
	@Id
	@Column(name = "id", updatable = false, nullable = false)
	private long id;

	@Column(name = "tema")
	private String tema;
	
	@Column(name = "palestrante")
	private String palestrante;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getPalestrante() {
		return palestrante;
	}

	public void setPalestrante(String palestrante) {
		this.palestrante = palestrante;
	}
}
