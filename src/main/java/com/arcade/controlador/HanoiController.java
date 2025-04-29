package com.arcade.controlador;

import com.arcade.adapter.TorresHanoiAdapter;
import com.arcade.dao.ResultadoDAO;
import com.arcade.dao.ResultadoDAOImpl;
import com.arcade.facade.HanoiFacade;
import com.arcade.modelo.entidad.Resultado;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class HanoiController {

    @FXML
    private BorderPane panelPrincipal;

    @FXML
    private Slider sliderDiscos;

    @FXML
    private HBox panelBotones;

    @FXML
    private Button btnResolver;

    @FXML
    private Button btnMoverAB;

    @FXML
    private Button btnMoverAC;

    @FXML
    private Button btnMoverBA;

    @FXML
    private Button btnMoverBC;

    @FXML
    private Button btnMoverCA;

    @FXML
    private Button btnMoverCB;

    @FXML
    private Label labelDiscos;

    @FXML
    private Label labelMovimientos;

    @FXML
    private Label labelResultado;

    private HanoiFacade facade;
    private TorresHanoiAdapter torresAdapter;
    private ResultadoDAO resultadoDAO;

    @FXML
    public void initialize() {
        facade = new HanoiFacade();
        resultadoDAO = new ResultadoDAOImpl();

        sliderDiscos.setMin(3);
        sliderDiscos.setMax(8);
        sliderDiscos.setValue(3);
        sliderDiscos.setShowTickLabels(true);
        sliderDiscos.setShowTickMarks(true);
        sliderDiscos.setMajorTickUnit(1);
        sliderDiscos.setMinorTickCount(0);
        sliderDiscos.setSnapToTicks(true);

        sliderDiscos.valueProperty().addListener((observable, oldValue, newValue) -> {
            labelDiscos.setText("Discos = " + newValue.intValue());
            inicializarTorres();
        });

        inicializarTorres();
    }

    private void inicializarTorres() {
        int numDiscos = (int) sliderDiscos.getValue();
        facade.inicializar(numDiscos);
        torresAdapter = new TorresHanoiAdapter(facade);
        panelPrincipal.setCenter(torresAdapter.crearRepresentacionVisual());
        labelMovimientos.setText("Movimientos: 0");
        labelResultado.setText("");
    }

    @FXML
    public void resolver() {
        boolean resuelto = facade.resolver();
        torresAdapter.actualizar();

        String mensaje = "Torres resueltas en " + facade.getMovimientos() + " movimientos.";
        labelMovimientos.setText("Movimientos: " + facade.getMovimientos());
        labelResultado.setText(mensaje);

        Resultado resultado = new Resultado(
                "TorresHanoi",
                facade.getParametrosAsString(),
                facade.getMovimientos(),
                resuelto
        );

        resultadoDAO.guardar(resultado);

        mostrarAlerta(Alert.AlertType.INFORMATION, "Resultado", mensaje, null);
    }

    @FXML
    public void moverDeAaB() {
        realizarMovimiento(0, 1);
    }

    @FXML
    public void moverDeAaC() {
        realizarMovimiento(0, 2);
    }

    @FXML
    public void moverDeBaA() {
        realizarMovimiento(1, 0);
    }

    @FXML
    public void moverDeBaC() {
        realizarMovimiento(1, 2);
    }

    @FXML
    public void moverDeCaA() {
        realizarMovimiento(2, 0);
    }

    @FXML
    public void moverDeCaB() {
        realizarMovimiento(2, 1);
    }

    private void realizarMovimiento(int origen, int destino) {
        if (facade.moverDisco(origen, destino)) {
            torresAdapter.actualizar();
            labelMovimientos.setText("Movimientos: " + facade.getMovimientos());

            if (facade.estaResuelto()) {
                String mensaje = "¡Felicidades! Has resuelto las Torres de Hanoi en " +
                        facade.getMovimientos() + " movimientos.";
                labelResultado.setText(mensaje);

                Resultado resultado = new Resultado(
                        "TorresHanoi",
                        facade.getParametrosAsString(),
                        facade.getMovimientos(),
                        true
                );

                resultadoDAO.guardar(resultado);

                mostrarAlerta(Alert.AlertType.INFORMATION, "Éxito", mensaje, null);
            }
        } else {
            mostrarAlerta(Alert.AlertType.ERROR, "Error", "Movimiento inválido", null);
        }
    }

    private void mostrarAlerta(Alert.AlertType tipo, String titulo, String contenido, String cabecera) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(cabecera);
        alerta.setContentText(contenido);
        alerta.showAndWait();
    }
}