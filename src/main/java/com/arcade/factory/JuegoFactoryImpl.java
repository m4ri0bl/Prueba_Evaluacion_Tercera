package com.arcade.factory;

import com.arcade.modelo.Juego;
import com.arcade.modelo.NReinas;
import com.arcade.modelo.RecorridoCaballo;
import com.arcade.modelo.TorresHanoi;

public class JuegoFactoryImpl implements JuegoFactory {

    @Override
    public Juego crearJuego(String tipoJuego) {
        switch (tipoJuego) {
            case "nreinas":
                return new NReinas();
            case "caballo":
                return new RecorridoCaballo();
            case "hanoi":
                return new TorresHanoi();
            default:
                throw new IllegalArgumentException("Tipo de juego no válido: " + tipoJuego);
        }
    }
}