package com.arcade.modelo;

import java.util.ArrayList;
import java.util.List;

public class TorresHanoi extends Juego {
    private int numDiscos;
    private List<List<Integer>> torres;
    private int movimientos;
    private List<int[]> secuenciaMovimientos;

    public TorresHanoi() {
        super();
        this.movimientos = 0;
        this.torres = new ArrayList<>();
        this.secuenciaMovimientos = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            torres.add(new ArrayList<>());
        }
    }

    @Override
    public boolean inicializar(int... parametros) {
        if (parametros.length < 1) {
            return false;
        }

        this.numDiscos = parametros[0];
        this.resuelto = false;
        this.movimientos = 0;
        this.secuenciaMovimientos.clear();

        for (int i = 0; i < 3; i++) {
            torres.get(i).clear();
        }

        for (int i = numDiscos; i >= 1; i--) {
            torres.get(0).add(i);
        }

        return true;
    }

    @Override
    public boolean resolver() {
        secuenciaMovimientos.clear();
        moverDiscos(numDiscos, 0, 2, 1);

        torres.get(0).clear();
        torres.get(1).clear();
        torres.get(2).clear();

        for (int i = numDiscos; i >= 1; i--) {
            torres.get(0).add(i);
        }

        for (int[] movimiento : secuenciaMovimientos) {
            moverDisco(movimiento[0], movimiento[1]);
        }

        this.resuelto = verificarResuelto();
        return this.resuelto;
    }

    private void moverDiscos(int n, int origen, int destino, int auxiliar) {
        if (n == 1) {
            secuenciaMovimientos.add(new int[]{origen, destino});
            return;
        }

        moverDiscos(n - 1, origen, auxiliar, destino);
        secuenciaMovimientos.add(new int[]{origen, destino});
        moverDiscos(n - 1, auxiliar, destino, origen);
    }

    public boolean moverDisco(int torreOrigen, int torreDestino) {
        if (torreOrigen < 0 || torreOrigen > 2 || torreDestino < 0 || torreDestino > 2) {
            return false;
        }

        if (torres.get(torreOrigen).isEmpty()) {
            return false;
        }

        int disco = torres.get(torreOrigen).get(torres.get(torreOrigen).size() - 1);

        if (!torres.get(torreDestino).isEmpty() && torres.get(torreDestino).get(torres.get(torreDestino).size() - 1) < disco) {
            return false;
        }

        torres.get(torreOrigen).remove(torres.get(torreOrigen).size() - 1);
        torres.get(torreDestino).add(disco);
        movimientos++;

        this.resuelto = verificarResuelto();

        return true;
    }

    private boolean verificarResuelto() {
        if (torres.get(2).size() != numDiscos) {
            return false;
        }

        for (int i = 0; i < numDiscos - 1; i++) {
            if (torres.get(2).get(i) < torres.get(2).get(i + 1)) {
                return false;
            }
        }

        return true;
    }

    public List<List<Integer>> getTorres() {
        return torres;
    }

    public int getNumDiscos() {
        return numDiscos;
    }

    public int getMovimientos() {
        return movimientos;
    }
}