package com.example.decorator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.models.Sala;

@Entity
@Table(name = "salas")
public class SalaDecorator implements Sala{
	@Id
	@Column(name = "id_sala", updatable = false, nullable = false)
	private long id;
	
	@Column(name = "cadeira")
	private double quantidadecadeira;
	
	@Column(name = "computador")
	private double quantidadecomputador;

	@Column(name = "projetor")
	private double quantidadeprojetor;
	
	protected Sala sala;
	
	public SalaDecorator(Sala sala) {
		this.sala = sala;
	}
	
	public SalaDecorator() {
	}
	
	@Override
	public double cadeira() {
		return this.sala.cadeira();
	}

	@Override
	public double computador() {
		return this.sala.computador();
	}

	@Override
	public double projetor() {
		return this.sala.projetor();
	}

	public long getQuantidadecadeira() {
		return (long) (quantidadecadeira = this.cadeira());
	}

	public long getQuantidadecomputador() {
		return (long) (quantidadecomputador = this.computador());
	}

	public long getQuantidadeprojetor() {
		return (long) (quantidadeprojetor =  this.projetor());
	}

	public long getId() {
		return id;
	}

	public Sala getSala() {
		return sala;
	}

}
