package com.arcade.modelo;

public abstract class Juego {
    protected boolean resuelto;

    public Juego() {
        this.resuelto = false;
    }

    public abstract boolean inicializar(int... parametros);

    public abstract boolean resolver();

    public boolean estaResuelto() {
        return resuelto;
    }
}