package com.example.models;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "usuarios")
public class Usuario {
	@Id
    @Column(name = "id_usuario", updatable = false, nullable = false)
	private long id_usuario;

	@Column(name = "nome")
	private String nome;
	
	@Column(name = "sobrenome")
	private String sobrenome;
	
	@Column(name = "email")
	private String email;

	@Column(name = "senha")
	private String senha;

	@OneToMany(mappedBy = "evento")
	public Set<Evento> eventoUsuarios;
	
	public Usuario(long id_usuario, String nome, String sobrenome, String email, String senha) {
		this.id_usuario = id_usuario;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.email = email;
		this.senha = senha;
	}

	public long getId() {
		return id_usuario;
	}

	public void setId(long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSobrenome() {
		return sobrenome;
	}
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
