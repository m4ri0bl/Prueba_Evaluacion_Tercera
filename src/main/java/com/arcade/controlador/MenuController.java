package com.arcade.controlador;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

    @FXML
    private VBox menuPrincipal;

    @FXML
    private Label tituloLabel;

    @FXML
    private Button btnNReinas;

    @FXML
    private Button btnRecorridoCaballo;

    @FXML
    private Button btnTorresHanoi;

    @FXML
    public void initialize() {
        tituloLabel.setText("Arcade de Puzzles Lógicos");
    }

    @FXML
    public void abrirNReinas() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/NReinas.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Problema de las N Reinas");
            stage.setScene(new Scene(root, 800, 600));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void abrirRecorridoCaballo() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Caballo.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Recorrido del Caballo");
            stage.setScene(new Scene(root, 800, 600));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void abrirTorresHanoi() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Hanoi.fxml"));
            Parent root = loader.load();

            Stage stage = new Stage();
            stage.setTitle("Torres de Hanoi");
            stage.setScene(new Scene(root, 800, 600));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}