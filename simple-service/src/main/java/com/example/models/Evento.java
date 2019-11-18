package com.example.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "eventos")
public class Evento {
	@Id
	@Column(name = "id", updatable = false, nullable = false)
	private long id;

	@JoinColumn(name = "id_usuario")
	@ManyToOne(cascade = CascadeType.ALL)
	private Usuario usuario;
	
	@JoinColumn(name = "id_palestra")
	@ManyToOne(cascade = CascadeType.ALL)
	private Palestra palestra;
	
	@Column(name = "data_inicial")
	private Date data_inicial;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "data_final")
	private Date data_final;

	
	public Evento(long id, Usuario usuario, Palestra palestra, Date data_inicial, String nome, Date data_final) {
		this.id = id;
		this.usuario = usuario;
		this.palestra = palestra;
		this.data_inicial = data_inicial;
		this.nome = nome;
		this.data_final = data_final;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Palestra getPalestra() {
		return palestra;
	}

	public void setPalestra(Palestra palestra) {
		this.palestra = palestra;
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
	
}
