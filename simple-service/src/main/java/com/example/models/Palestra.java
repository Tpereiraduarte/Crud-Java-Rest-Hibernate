package com.example.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.decorator.SalaDecorator;

@Entity
@Table(name = "paletras")
public class Palestra {
	@Id
	@Column(name = "id", updatable = false, nullable = false)
	private long id;

	@Column(name = "tema")
	private String tema;
	
	@Column(name = "data")
	private Date data;
	
	@Column(name = "palestrante")
	private String palestrante;
	
	@ManyToOne
	@JoinColumn(name = "id_evento", nullable = false)
	public Evento evento;
	
	/*@JoinColumn(name = "id_sala", unique = true)
	@OneToOne(cascade = CascadeType.ALL)
	private SalaDecorator sala;*/

	public Palestra(long id, String tema, Date data, String palestrante, Evento evento) {
		this.id = id;
		this.tema = tema;
		this.data = data;
		this.palestrante = palestrante;
		this.evento = evento;
	}

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

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getPalestrante() {
		return palestrante;
	}

	public void setPalestrante(String palestrante) {
		this.palestrante = palestrante;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}
}
