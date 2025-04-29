package com.arcade.adapter;

import com.arcade.facade.HanoiFacade;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.List;

public class TorresHanoiAdapter implements TableroAdapter {

    private HanoiFacade facade;
    private HBox hbox;

    public TorresHanoiAdapter(HanoiFacade facade) {
        this.facade = facade;
        this.hbox = new HBox(20);
    }

    @Override
    public Pane crearRepresentacionVisual() {
        actualizar();
        return hbox;
    }

    @Override
    public void actualizar() {
        hbox.getChildren().clear();

        List<List<Integer>> torres = facade.getTorres();
        int numDiscos = facade.getNumDiscos();

        for (int i = 0; i < 3; i++) {
            VBox torre = new VBox(5);
            torre.setStyle("-fx-alignment: bottom-center;");

            Rectangle base = new Rectangle(200, 20);
            base.setFill(Color.BROWN);

            for (int j = torres.get(i).size() - 1; j >= 0; j--) {
                int tamano = torres.get(i).get(j);
                double ancho = 20 + (tamano * 180 / numDiscos);

                Rectangle disco = new Rectangle(ancho, 20);
                disco.setFill(Color.color(Math.random(), Math.random(), Math.random()));
                disco.setStroke(Color.BLACK);

                StackPane discoPane = new StackPane(disco);
                torre.getChildren().add(discoPane);
            }

            torre.getChildren().add(base);
            hbox.getChildren().add(torre);
        }
    }
}