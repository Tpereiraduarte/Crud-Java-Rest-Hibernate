package com.example.models;

import java.util.Set;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "usuariopalestras")
public class UsuarioPalestra {
	@Id
	@Column(name = "id_usuario_palestra", updatable = false, nullable = false)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@ManyToOne
	@JoinColumn(name = "palestra_id")
	private Palestra palestra;

	@OneToMany(mappedBy = "palestra")
	public Set<UsuarioPalestra> palestras;
	
	@OneToMany(mappedBy = "usuario")
	public Set<UsuarioPalestra> usuarios;
	
	public UsuarioPalestra() {
		
	}	
	
	public UsuarioPalestra(long id, Usuario usuario, Palestra palestra) {
		this.id = id;
		this.usuario = usuario;
		this.palestra = palestra;
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
	
	@JsonbTransient
	public Set<UsuarioPalestra> getPalestras() {
		return palestras;
	}

	public void setPalestras(Set<UsuarioPalestra> palestras) {
		this.palestras = palestras;
	}
	
	@JsonbTransient
	public Set<UsuarioPalestra> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<UsuarioPalestra> usuarios) {
		this.usuarios = usuarios;
	}
}
