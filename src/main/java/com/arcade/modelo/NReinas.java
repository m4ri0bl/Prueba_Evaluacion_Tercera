package com.arcade.modelo;

public class NReinas extends Juego {
    private int n;
    private int[][] tablero;
    private int iteraciones;

    public NReinas() {
        super();
        this.iteraciones = 0;
    }

    @Override
    public boolean inicializar(int... parametros) {
        if (parametros.length < 1) {
            return false;
        }

        this.n = parametros[0];
        this.tablero = new int[n][n];
        this.resuelto = false;
        this.iteraciones = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tablero[i][j] = 0;
            }
        }

        return true;
    }

    @Override
    public boolean resolver() {
        this.resuelto = colocarReina(0);
        return this.resuelto;
    }

    private boolean colocarReina(int columna) {
        if (columna >= n) {
            return true;
        }

        for (int fila = 0; fila < n; fila++) {
            this.iteraciones++;

            if (esSeguro(fila, columna)) {
                tablero[fila][columna] = 1;

                if (colocarReina(columna + 1)) {
                    return true;
                }

                tablero[fila][columna] = 0;
            }
        }

        return false;
    }

    private boolean esSeguro(int fila, int columna) {
        for (int i = 0; i < columna; i++) {
            if (tablero[fila][i] == 1) {
                return false;
            }
        }

        for (int i = fila, j = columna; i >= 0 && j >= 0; i--, j--) {
            if (tablero[i][j] == 1) {
                return false;
            }
        }

        for (int i = fila, j = columna; i < n && j >= 0; i++, j--) {
            if (tablero[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    public int[][] getTablero() {
        return tablero;
    }

    public int getTamanoTablero() {
        return n;
    }

    public int getIteraciones() {
        return iteraciones;
    }
}