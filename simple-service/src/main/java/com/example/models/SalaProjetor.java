package com.example.models;

import com.example.decorator.SalaDecorator;

public class SalaProjetor extends SalaDecorator {
    public SalaProjetor( Sala sala ){
        super( sala );
    }

    @Override
    public long getQuantidadeCadeira() {
        return sala.getQuantidadeCadeira() + 0;
    }

    @Override
    public long getQuantidadeProjetor() {
        return sala.getQuantidadeProjetor() + 1;
    }

    @Override
    public long getQuantidadeComputador() {
        return sala.getQuantidadeComputador() + 0;
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
