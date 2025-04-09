package co.edu.uniquindio.banco.controlador;

import co.edu.uniquindio.banco.BancoApp;
import co.edu.uniquindio.banco.modelo.Sesion;
import co.edu.uniquindio.banco.modelo.entidades.Banco;
import co.edu.uniquindio.banco.modelo.entidades.BilleteraVirtual;
import co.edu.uniquindio.banco.modelo.entidades.Usuario;
import co.edu.uniquindio.banco.modelo.enums.Categoria;
import co.edu.uniquindio.banco.utilidades.Utilidades;
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

    private final Banco banco = Banco.getInstancia();
    Usuario usuario;
    Sesion sesion;

    @FXML
    void regresar(ActionEvent event) {
        Utilidades.navegarVentana("/panelCliente.fxml", "Panel", btnRegresar, getClass());
    }

    @FXML
    void initialize() {
        sesion = Sesion.getInstancia();
        usuario = sesion.getUsuario();
        cmbCategoria.setItems(FXCollections.observableArrayList(Categoria.values()));

    }
    @FXML
    void transferir(ActionEvent event) {
        try {
            BilleteraVirtual billeteraVirtual= banco.buscarBilleteraUsuario(usuario.getId());
            banco.realizarTransferencia(billeteraVirtual.getNumero(),txtNumeroCuenta.getText(),Float.parseFloat(txtMontoTransferir.getText()),cmbCategoria.getValue() );
            Utilidades.crearAlerta("Se ha realizado la transacción con éxito", Alert.AlertType.INFORMATION);
            Utilidades.navegarVentana("/panelCliente.fxml", "Panel", btnTransferir, getClass());

        }catch (NumberFormatException e){
            Utilidades.crearAlerta("Debe ingresar un número válido al monto", Alert.AlertType.ERROR);
        }
        catch (Exception e){
            Utilidades.crearAlerta(e.getMessage(), Alert.AlertType.ERROR);
        }
    }

}
