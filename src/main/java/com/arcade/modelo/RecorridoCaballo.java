package com.arcade.modelo;

public class RecorridoCaballo extends Juego {
    private int n;
    private int[][] tablero;
    private int filaInicial;
    private int columnaInicial;
    private int movimientos;

    private final int[] movimientoFila = {2, 1, -1, -2, -2, -1, 1, 2};
    private final int[] movimientoColumna = {1, 2, 2, 1, -1, -2, -2, -1};

    public RecorridoCaballo() {
        super();
        this.movimientos = 0;
    }

    @Override
    public boolean inicializar(int... parametros) {
        if (parametros.length < 3) {
            return false;
        }

        this.n = parametros[0];
        this.filaInicial = parametros[1];
        this.columnaInicial = parametros[2];

        if (filaInicial < 0 || filaInicial >= n || columnaInicial < 0 || columnaInicial >= n) {
            return false;
        }

        this.tablero = new int[n][n];
        this.resuelto = false;
        this.movimientos = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tablero[i][j] = 0;
            }
        }

        return true;
    }

    @Override
    public boolean resolver() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tablero[i][j] = 0;
            }
        }

        tablero[filaInicial][columnaInicial] = 1;
        this.movimientos = 1;

        this.resuelto = recorrerTablero(filaInicial, columnaInicial, 2);
        return this.resuelto;
    }

    private boolean recorrerTablero(int fila, int columna, int movimiento) {
        if (movimiento > n * n) {
            return true;
        }

        for (int i = 0; i < 8; i++) {
            int nuevaFila = fila + movimientoFila[i];
            int nuevaColumna = columna + movimientoColumna[i];

            if (esMovimientoValido(nuevaFila, nuevaColumna)) {
                tablero[nuevaFila][nuevaColumna] = movimiento;
                this.movimientos = movimiento;

                if (recorrerTablero(nuevaFila, nuevaColumna, movimiento + 1)) {
                    return true;
                }

                tablero[nuevaFila][nuevaColumna] = 0;
            }
        }

        return false;
    }

    private boolean esMovimientoValido(int fila, int columna) {
        return (fila >= 0 && fila < n && columna >= 0 && columna < n && tablero[fila][columna] == 0);
    }

    public int[][] getTablero() {
        return tablero;
    }

    public int getTamanoTablero() {
        return n;
    }

    public int getFilaInicial() {
        return filaInicial;
    }

    public int getColumnaInicial() {
        return columnaInicial;
    }

    public int getMovimientos() {
        return movimientos;
    }
}