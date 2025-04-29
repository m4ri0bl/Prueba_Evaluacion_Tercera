package com.arcade.modelo.entidad;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "resultados")
public class Resultado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipo_juego", nullable = false)
    private String tipoJuego;

    @Column(name = "parametros", nullable = false)
    private String parametros;

    @Column(name = "movimientos")
    private Integer movimientos;

    @Column(name = "resuelto")
    private Boolean resuelto;

    @Column(name = "fecha")
    private LocalDateTime fecha;

    public Resultado() {
        this.fecha = LocalDateTime.now();
    }

    public Resultado(String tipoJuego, String parametros, Integer movimientos, Boolean resuelto) {
        this.tipoJuego = tipoJuego;
        this.parametros = parametros;
        this.movimientos = movimientos;
        this.resuelto = resuelto;
        this.fecha = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoJuego() {
        return tipoJuego;
    }

    public void setTipoJuego(String tipoJuego) {
        this.tipoJuego = tipoJuego;
    }

    public String getParametros() {
        return parametros;
    }

    public void setParametros(String parametros) {
        this.parametros = parametros;
    }

    public Integer getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(Integer movimientos) {
        this.movimientos = movimientos;
    }

    public Boolean getResuelto() {
        return resuelto;
    }

    public void setResuelto(Boolean resuelto) {
        this.resuelto = resuelto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}