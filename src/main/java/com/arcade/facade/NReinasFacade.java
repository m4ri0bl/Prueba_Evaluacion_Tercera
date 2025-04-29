package com.arcade.facade;

import com.arcade.modelo.NReinas;

public class NReinasFacade implements JuegoFacade {

    private NReinas nReinas;

    public NReinasFacade() {
        this.nReinas = new NReinas();
    }

    @Override
    public boolean inicializar(int... parametros) {
        if (parametros.length < 1) {
            return false;
        }

        int n = parametros[0];
        nReinas.inicializar(n);
        return true;
    }

    @Override
    public boolean resolver() {
        return nReinas.resolver();
    }

    @Override
    public boolean estaResuelto() {
        return nReinas.estaResuelto();
    }

    @Override
    public int getMovimientos() {
        return nReinas.getIteraciones();
    }

    @Override
    public String getParametrosAsString() {
        return "N=" + nReinas.getTamanoTablero();
    }

    public int[][] getTablero() {
        return nReinas.getTablero();
    }

    public int getTamanoTablero() {
        return nReinas.getTamanoTablero();
    }
}