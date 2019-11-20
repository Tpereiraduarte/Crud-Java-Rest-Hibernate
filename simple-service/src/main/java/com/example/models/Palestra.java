package com.example.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.example.models.Evento;
import com.example.decorator.SalaDecorator;

@Entity
@Table(name = "palestras")
public class Palestra {
	@Id
	@Column(name = "id_palestra", updatable = false, nullable = false)
	private long id;

	@Column(name = "tema")
	private String tema;

	@Column(name = "data")
	private Date data;

	@Column(name = "palestrante")
	private String palestrante;

	/*
	 * @JoinColumn(name = "id_sala", unique = true)
	 * 
	 * @OneToOne(cascade = CascadeType.ALL) private SalaDecorator sala;
	 */
	
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
}
