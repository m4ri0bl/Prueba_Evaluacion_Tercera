package com.arcade.controlador;

import com.arcade.adapter.TableroNReinasAdapter;
import com.arcade.dao.ResultadoDAO;
import com.arcade.dao.ResultadoDAOImpl;
import com.arcade.facade.NReinasFacade;
import com.arcade.modelo.entidad.Resultado;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;

public class NReinasController {

    @FXML
    private BorderPane panelPrincipal;

    @FXML
    private Slider sliderN;

    @FXML
    private Button btnResolver;

    @FXML
    private Label labelN;

    @FXML
    private Label labelResultado;

    private NReinasFacade facade;
    private TableroNReinasAdapter tableroAdapter;
    private ResultadoDAO resultadoDAO;

    @FXML
    public void initialize() {
        facade = new NReinasFacade();
        resultadoDAO = new ResultadoDAOImpl();

        sliderN.setMin(4);
        sliderN.setMax(15);
        sliderN.setValue(8);
        sliderN.setShowTickLabels(true);
        sliderN.setShowTickMarks(true);
        sliderN.setMajorTickUnit(1);
        sliderN.setMinorTickCount(0);
        sliderN.setSnapToTicks(true);

        sliderN.valueProperty().addListener((observable, oldValue, newValue) -> {
            labelN.setText("N = " + newValue.intValue());
            inicializarTablero();
        });

        inicializarTablero();
    }

    private void inicializarTablero() {
        int n = (int) sliderN.getValue();
        facade.inicializar(n);
        tableroAdapter = new TableroNReinasAdapter(facade);
        panelPrincipal.setCenter(tableroAdapter.crearRepresentacionVisual());
        labelResultado.setText("");
    }

    @FXML
    public void resolver() {
        boolean resuelto = facade.resolver();
        tableroAdapter.actualizar();

        String mensaje;
        if (resuelto) {
            mensaje = "Problema resuelto en " + facade.getMovimientos() + " iteraciones.";
        } else {
            mensaje = "No se pudo encontrar una solución.";
        }

        labelResultado.setText(mensaje);

        Resultado resultado = new Resultado(
                "NReinas",
                facade.getParametrosAsString(),
                facade.getMovimientos(),
                resuelto
        );

        resultadoDAO.guardar(resultado);

        mostrarAlerta(resuelto ? Alert.AlertType.INFORMATION : Alert.AlertType.WARNING,
                "Resultado", mensaje, null);
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String contenido, String cabecera) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(cabecera);
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }
}