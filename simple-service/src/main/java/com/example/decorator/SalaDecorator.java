package com.example.decorator;

import com.example.models.Sala;

public class SalaDecorator implements Sala{

	protected Sala sala;
	
	public SalaDecorator(Sala sala) {
		this.sala = sala;
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

}
