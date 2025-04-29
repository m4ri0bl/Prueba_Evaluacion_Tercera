package com.arcade.adapter;

import com.arcade.facade.NReinasFacade;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class TableroNReinasAdapter implements TableroAdapter {

    private NReinasFacade facade;
    private GridPane gridPane;

    public TableroNReinasAdapter(NReinasFacade facade) {
        this.facade = facade;
        this.gridPane = new GridPane();
    }

    @Override
    public Pane crearRepresentacionVisual() {
        actualizar();
        return gridPane;
    }

    @Override
    public void actualizar() {
        gridPane.getChildren().clear();

        int tamano = facade.getTamanoTablero();
        int[][] tablero = facade.getTablero();

        double tamanoCell = 50;

        for (int fila = 0; fila < tamano; fila++) {
            for (int col = 0; col < tamano; col++) {
                Rectangle celda = new Rectangle(tamanoCell, tamanoCell);

                if ((fila + col) % 2 == 0) {
                    celda.setFill(Color.WHITE);
                } else {
                    celda.setFill(Color.LIGHTGRAY);
                }

                celda.setStroke(Color.BLACK);

                gridPane.add(celda, col, fila);

                if (tablero[fila][col] == 1) {
                    Text reina = new Text("♕");
                    reina.setStyle("-fx-font-size: 32px;");
                    gridPane.add(reina, col, fila);
                }
            }
        }
    }
}