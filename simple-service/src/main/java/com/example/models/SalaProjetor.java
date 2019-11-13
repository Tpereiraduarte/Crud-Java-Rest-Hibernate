package com.example.models;

import com.example.decorator.SalaDecorator;

public class SalaProjetor extends SalaDecorator {

	public SalaProjetor(Sala sala) {
		super(sala);
	}

	@Override
	public double projetor() {
		return super.projetor() + 1;
	}
}
