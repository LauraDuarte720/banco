package co.edu.uniquindio.banco.controlador;

import co.edu.uniquindio.banco.modelo.entidades.Transaccion;
import co.edu.uniquindio.banco.modelo.entidades.Usuario;
import co.edu.uniquindio.banco.modelo.enums.TipoTransaccion;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.time.LocalDateTime;


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
    private TableColumn<Transaccion, TipoTransaccion> colCategoria;

    @FXML
    private TableColumn<Transaccion, LocalDateTime> colFecha;

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
    private TableView<Transaccion> tblTransacciones;

    Usuario usuario;

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
