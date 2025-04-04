package co.edu.uniquindio.banco.controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class PanelClienteControlador {

    @FXML
    private Button btnActualizarUsuario;

    @FXML
    private Button btnCerrarSesion;

    @FXML
    private Button btnConsultar;

    @FXML
    private Button btnTransferir;

    @FXML
    private TableColumn<?, ?> colCategoria;

    @FXML
    private TableColumn<?, ?> colFecha;

    @FXML
    private TableColumn<?, ?> colTipo;

    @FXML
    private TableColumn<?, ?> colUsuario;

    @FXML
    private TableColumn<?, ?> colValor;

    @FXML
    private Label lblBienvenidaBanco;

    @FXML
    private Label lblNroCuenta;

    @FXML
    private TableView<?> tblTransacciones;

    @FXML
    void actualizarUsuario(ActionEvent event) {

    }

    @FXML
    void cerrarSesion(ActionEvent event) {

    }

    @FXML
    void consultarSaldo(ActionEvent event) {

    }

    @FXML
    void realizarTransferencia(ActionEvent event) {

    }

}
