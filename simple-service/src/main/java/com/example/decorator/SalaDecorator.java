package com.example.decorator;

import com.example.models.Sala;

public abstract class SalaDecorator extends Sala {
    protected Sala sala;

    protected SalaDecorator( Sala sala ){
        this.sala = sala;
    }
}