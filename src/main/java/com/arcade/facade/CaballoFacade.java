package com.arcade.facade;

import com.arcade.modelo.RecorridoCaballo;

public class CaballoFacade implements JuegoFacade {

    private RecorridoCaballo recorridoCaballo;

    public CaballoFacade() {
        this.recorridoCaballo = new RecorridoCaballo();
    }

    @Override
    public boolean inicializar(int... parametros) {
        if (parametros.length < 3) {
            return false;
        }

        int tamano = parametros[0];
        int filaInicial = parametros[1];
        int columnaInicial = parametros[2];

        recorridoCaballo.inicializar(tamano, filaInicial, columnaInicial);
        return true;
    }

    @Override
    public boolean resolver() {
        return recorridoCaballo.resolver();
    }

    @Override
    public boolean estaResuelto() {
        return recorridoCaballo.estaResuelto();
    }

    @Override
    public int getMovimientos() {
        return recorridoCaballo.getMovimientos();
    }

    @Override
    public String getParametrosAsString() {
        return "Tamaño=" + recorridoCaballo.getTamanoTablero() +
                ", Inicio=(" + recorridoCaballo.getFilaInicial() +
                "," + recorridoCaballo.getColumnaInicial() + ")";
    }

    public int[][] getTablero() {
        return recorridoCaballo.getTablero();
    }

    public int getTamanoTablero() {
        return recorridoCaballo.getTamanoTablero();
    }
}