package com.arcade.factory;

import com.arcade.modelo.Juego;

public interface JuegoFactory {
    Juego crearJuego(String tipoJuego);
}