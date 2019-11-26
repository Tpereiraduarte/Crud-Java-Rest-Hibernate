package com.example.models;

import java.util.Date;
import java.util.Set;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.example.models.Evento;

@Entity
@Table(name = "palestras")
public class Palestra {
	@Id
	@Column(name = "id_palestra", updatable = false, nullable = false)
	private long id;

	@Column(name = "tema")
	private String tema;
	
	@Column(name = "descricao")
	private String descricao;

	@Column(name = "data")
	private Date data;

	@Column(name = "palestrante")
	private String palestrante;

	@ManyToOne
	@JoinColumn(name="evento_id")
	private Evento eventoPalestras;
	
	public Palestra() {
		
	}
	
	public Palestra(long id, String tema, String descricao, Date data, String palestrante,
			Evento eventoPalestras) {
		this.id = id;
		this.tema = tema;
		this.descricao = descricao;
		this.data = data;
		this.palestrante = palestrante;
		this.eventoPalestras = eventoPalestras;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public Evento getEventoPalestras() {
		return eventoPalestras;
	}

	public void setEventoPalestras(Evento eventoPalestras) {
		this.eventoPalestras = eventoPalestras;
	}
}
