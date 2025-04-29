package com.arcade.facade;

public interface JuegoFacade {
    boolean inicializar(int... parametros);
    boolean resolver();
    boolean estaResuelto();
    int getMovimientos();
    String getParametrosAsString();
}