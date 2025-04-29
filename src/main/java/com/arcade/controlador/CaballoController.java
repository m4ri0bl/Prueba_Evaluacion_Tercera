package com.arcade.controlador;

import com.arcade.adapter.TableroCaballoAdapter;
import com.arcade.dao.ResultadoDAO;
import com.arcade.dao.ResultadoDAOImpl;
import com.arcade.facade.CaballoFacade;
import com.arcade.modelo.entidad.Resultado;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

public class CaballoController {

    @FXML
    private BorderPane panelPrincipal;

    @FXML
    private Slider sliderTamano;

    @FXML
    private Spinner<Integer> spinnerFila;

    @FXML
    private Spinner<Integer> spinnerColumna;

    @FXML
    private Button btnResolver;

    @FXML
    private Label labelTamano;

    @FXML
    private Label labelResultado;

    private CaballoFacade facade;
    private TableroCaballoAdapter tableroAdapter;
    private ResultadoDAO resultadoDAO;

    @FXML
    public void initialize() {
        facade = new CaballoFacade();
        resultadoDAO = new ResultadoDAOImpl();

        sliderTamano.setMin(5);
        sliderTamano.setMax(8);
        sliderTamano.setValue(8);
        sliderTamano.setShowTickLabels(true);
        sliderTamano.setShowTickMarks(true);
        sliderTamano.setMajorTickUnit(1);
        sliderTamano.setMinorTickCount(0);
        sliderTamano.setSnapToTicks(true);

        sliderTamano.valueProperty().addListener((observable, oldValue, newValue) -> {
            int tamano = newValue.intValue();
            labelTamano.setText("Tamaño = " + tamano);
            configurarSpinners(tamano);
            inicializarTablero();
        });

        configurarSpinners(8);
        inicializarTablero();
    }

    private void configurarSpinners(int tamano) {
        SpinnerValueFactory<Integer> factoryFila =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, tamano - 1, 0);
        spinnerFila.setValueFactory(factoryFila);

        SpinnerValueFactory<Integer> factoryColumna =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, tamano - 1, 0);
        spinnerColumna.setValueFactory(factoryColumna);

        spinnerFila.valueProperty().addListener((obs, oldValue, newValue) -> inicializarTablero());
        spinnerColumna.valueProperty().addListener((obs, oldValue, newValue) -> inicializarTablero());
    }

    private void inicializarTablero() {
        int tamano = (int) sliderTamano.getValue();
        int fila = spinnerFila.getValue();
        int columna = spinnerColumna.getValue();

        facade.inicializar(tamano, fila, columna);
        tableroAdapter = new TableroCaballoAdapter(facade);
        panelPrincipal.setCenter(tableroAdapter.crearRepresentacionVisual());
        labelResultado.setText("");
    }

    @FXML
    public void resolver() {
        boolean resuelto = facade.resolver();
        tableroAdapter.actualizar();

        String mensaje;
        if (resuelto) {
            mensaje = "Recorrido encontrado en " + facade.getMovimientos() + " movimientos.";
        } else {
            mensaje = "No se pudo encontrar un recorrido completo.";
        }

        labelResultado.setText(mensaje);

        Resultado resultado = new Resultado(
                "RecorridoCaballo",
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