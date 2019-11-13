package com.example.models;

import com.example.decorator.SalaDecorator;

public class SalaComputador extends SalaDecorator {

	public SalaComputador(Sala sala) {
		super(sala);
	}

	@Override
	public double computador() {
		return super.computador() + 25;
	}
}
