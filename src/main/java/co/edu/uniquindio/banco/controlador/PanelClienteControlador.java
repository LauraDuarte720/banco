package co.edu.uniquindio.banco.controlador;

import co.edu.uniquindio.banco.BancoApp;
import co.edu.uniquindio.banco.modelo.Sesion;
import co.edu.uniquindio.banco.modelo.entidades.Banco;
import co.edu.uniquindio.banco.modelo.entidades.BilleteraVirtual;
import co.edu.uniquindio.banco.modelo.entidades.Transaccion;
import co.edu.uniquindio.banco.modelo.entidades.Usuario;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import static javafx.collections.FXCollections.observableList;


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
    private TableColumn<Transaccion, String> colCategoria;

    @FXML
    private TableColumn<Transaccion, String> colFecha;

    @FXML
    private TableColumn<Transaccion, String> colTipo;

    @FXML
    private TableColumn<Transaccion, String> colUsuario;

    @FXML
    private TableColumn<Transaccion, String> colValor;

    @FXML
    private Label lblBienvenidaBanco;

    @FXML
    private Label lblNroCuenta;

    @FXML
    private TableView<Transaccion> tblTransacciones;

    BilleteraVirtual billetera;
    Sesion sesion;
    Usuario usuario;
    Banco banco;

    @FXML
    public void initialize() {
        banco = Banco.getBanco();
        sesion = Sesion.getInstancia();
        usuario = sesion.getUsuario();
        billetera = banco.buscarBilleteraUsuario(usuario.getId());
        lblBienvenidaBanco.setText(usuario.getNombre() + " bienvenido a su banco, aquí podrá ver sus transacciones");
        lblNroCuenta.setText("Nro. Cuenta." + billetera.getNumero());
        colCategoria.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getCategoria().name()));
        colTipo.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().obtenerTipo(billetera).name()));
        colFecha.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().getFecha().toString()));
        colValor.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().obtenerMontoCadena()));
        colUsuario.setCellValueFactory(cellData ->
                new SimpleStringProperty(cellData.getValue().obtenerUsuario().getNombre()));
        tblTransacciones.setItems(observableList(banco.obtenerTransacciones(billetera.getNumero())));
    }

    @FXML
    void actualizarUsuario(ActionEvent event) {
        BancoApp.navegarVentana("/actualizacion.fxml", "Actualizar", event, getClass());
    }

    @FXML
    void cerrarSesion(ActionEvent event) {
        sesion.cerrarSesion();
        BancoApp.navegarVentana("/login.fxml", "Login", event, getClass());
    }

    @FXML
    void consultarSaldo(ActionEvent event) {
        String mensaje = "El saldo de la billetera es: " + billetera.consultarSaldo();
        BancoApp.crearAlerta(mensaje, Alert.AlertType.INFORMATION);
    }

    @FXML
    void irTransferencia(ActionEvent event) {
        BancoApp.navegarVentana("/transferencia.fxml", "Transferencia", event, getClass());
    }

}
