package com.example.models;

import com.example.decorator.SalaDecorator;

public class SalaSimples extends SalaDecorator{

	public SalaSimples(Sala sala) {
		super(sala);
	}

	@Override
	public double cadeira() {
		return 25;
	}

	@Override
	public double computador() {
		return 0;
	}

	@Override
	public double projetor() {
		return 0;
	}
}
