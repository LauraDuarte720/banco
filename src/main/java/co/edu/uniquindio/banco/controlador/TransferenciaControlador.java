package co.edu.uniquindio.banco.controlador;

import co.edu.uniquindio.banco.BancoApp;
import co.edu.uniquindio.banco.modelo.Sesion;
import co.edu.uniquindio.banco.modelo.entidades.Banco;
import co.edu.uniquindio.banco.modelo.entidades.BilleteraVirtual;
import co.edu.uniquindio.banco.modelo.entidades.Usuario;
import co.edu.uniquindio.banco.modelo.enums.Categoria;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class TransferenciaControlador {

    @FXML
    private Button btnRegresar;

    @FXML
    private Button btnTransferir;

    @FXML
    private ComboBox<Categoria> cmbCategoria;

    @FXML
    private TextField txtMontoTransferir;

    @FXML
    private TextField txtNumeroCuenta;

    Banco banco;
    Usuario usuario;
    Sesion sesion;

    @FXML
    void regresar(ActionEvent event) {
        BancoApp.navegarVentana("/panelCliente.fxml", "Panel", event, getClass());
    }

    @FXML
    void initialize() {
        banco = Banco.getBanco();
        sesion = Sesion.getInstancia();
        usuario = sesion.getUsuario();
        cmbCategoria.setItems(FXCollections.observableArrayList(Categoria.values()));

    }
    @FXML
    void transferir(ActionEvent event) {
        try {
            BilleteraVirtual billeteraVirtual= banco.buscarBilleteraUsuario(usuario.getId());
            banco.realizarTransferencia(billeteraVirtual.getNumero(),txtNumeroCuenta.getText(),Float.parseFloat(txtMontoTransferir.getText()),cmbCategoria.getValue() );
            BancoApp.crearAlerta("Se ha realizado la transacción con éxito", Alert.AlertType.INFORMATION);
            BancoApp.navegarVentana("/panelCliente.fxml", "Panel", event, getClass());

        }catch (NumberFormatException e){
            BancoApp.crearAlerta("Debe ingresar un número válido al monto", Alert.AlertType.ERROR);
        }
        catch (Exception e){
            BancoApp.crearAlerta(e.getMessage(), Alert.AlertType.ERROR);
        }
    }

}
