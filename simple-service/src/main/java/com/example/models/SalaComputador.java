package com.example.models;

import com.example.decorator.SalaDecorator;

public class SalaComputador extends SalaDecorator {
    public SalaComputador( Sala sala ){
        super( sala );
    }

    @Override
    public long getQuantidadeCadeira() {
        return sala.getQuantidadeCadeira() + 0;
    }

    @Override
    public long getQuantidadeProjetor() {
        return sala.getQuantidadeProjetor() + 0;
    }

    @Override
    public long getQuantidadeComputador() {
        return sala.getQuantidadeComputador() + 50;
    }

	@Override
	public void setQuantidadeComputador(long quantidadeComputador) {
		this.quantidadeComputador = sala.getQuantidadeComputador();
	}

	@Override
	public void setQuantidadeCadeira(long quantidadeCadeira) {
		this.quantidadeCadeira = sala.getQuantidadeCadeira();
	}

	@Override
	public void setQuantidadeProjetor(long quantidadeProjetor) {
		this.quantidadeCadeira = sala.getQuantidadeProjetor();
	}
}