package com.arcade.facade;

import com.arcade.modelo.TorresHanoi;
import java.util.List;

public class HanoiFacade implements JuegoFacade {

    private TorresHanoi torresHanoi;

    public HanoiFacade() {
        this.torresHanoi = new TorresHanoi();
    }

    @Override
    public boolean inicializar(int... parametros) {
        if (parametros.length < 1) {
            return false;
        }

        int numDiscos = parametros[0];
        torresHanoi.inicializar(numDiscos);
        return true;
    }

    @Override
    public boolean resolver() {
        return torresHanoi.resolver();
    }

    @Override
    public boolean estaResuelto() {
        return torresHanoi.estaResuelto();
    }

    @Override
    public int getMovimientos() {
        return torresHanoi.getMovimientos();
    }

    @Override
    public String getParametrosAsString() {
        return "Discos=" + torresHanoi.getNumDiscos();
    }

    public List<List<Integer>> getTorres() {
        return torresHanoi.getTorres();
    }

    public int getNumDiscos() {
        return torresHanoi.getNumDiscos();
    }

    public boolean moverDisco(int torreOrigen, int torreDestino) {
        return torresHanoi.moverDisco(torreOrigen, torreDestino);
    }
}