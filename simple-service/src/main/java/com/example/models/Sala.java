package com.example.models;

import java.util.Set;

import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "salas")
public class Sala {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id_sala", updatable = false, nullable = false)
	private long id;

	@Column(name = "cadeira")
    protected long quantidadeCadeira;
	
	@Column(name = "computador")
    protected long quantidadeComputador;
	
	@Column(name = "projetor")
    protected long quantidadeProjetor;
	
	@OneToMany(mappedBy = "salaPalestras")
	public Set<Sala> salaPalestras;

    public Sala(){
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getQuantidadeCadeira() {
		return quantidadeCadeira;
	}

	public void setQuantidadeCadeira(long quantidadeCadeira) {
		this.quantidadeCadeira = quantidadeCadeira;
	}

	public long getQuantidadeComputador() {
		return quantidadeComputador;
	}

	public void setQuantidadeComputador(long quantidadeComputador) {
		this.quantidadeComputador = quantidadeComputador;
	}

	public long getQuantidadeProjetor() {
		return quantidadeProjetor;
	}

	public void setQuantidadeProjetor(long quantidadeProjetor) {
		this.quantidadeProjetor = quantidadeProjetor;
	}
	
	@JsonbTransient
	public Set<Sala> getSalaPalestras() {
		return salaPalestras;
	}

	public void setSalaPalestras(Set<Sala> salaPalestras) {
		this.salaPalestras = salaPalestras;
	}
}
