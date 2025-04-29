package com.arcade.dao;

import com.arcade.modelo.entidad.Resultado;
import java.util.List;

public interface ResultadoDAO {
    void guardar(Resultado resultado);
    Resultado obtenerPorId(Long id);
    List<Resultado> obtenerTodos();
    List<Resultado> obtenerPorTipoJuego(String tipoJuego);
}