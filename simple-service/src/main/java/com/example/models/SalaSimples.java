package com.example.models;

public class SalaSimples implements Sala{

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
