package com.example.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.example.models.Palestra;
import com.example.models.Usuario;;

@Entity
@Table(name = "eventos")
public class Evento {
	@Id
	@Column(name = "id_evento", updatable = false, nullable = false)
	private long id;


	@OneToMany
	@JoinColumn(name="usuario_id")
	public List<Usuario> eventoUsuarios;
	
	@OneToMany
	@JoinColumn(name="palestra_id")
	private List<Palestra> eventoPalestras;
	
	@Column(name = "data_inicial")
	private Date data_inicial;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "data_final")
	private Date data_final;

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
}
