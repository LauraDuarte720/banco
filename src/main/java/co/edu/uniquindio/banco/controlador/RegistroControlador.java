package co.edu.uniquindio.banco.controlador;

import co.edu.uniquindio.banco.BancoApp;
import co.edu.uniquindio.banco.modelo.entidades.Banco;
import co.edu.uniquindio.banco.utilidades.Utilidades;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegistroControlador {

    @FXML
    private TextField txtCorreo;

    @FXML
    private TextField txtDireccion;

    @FXML
    private TextField txtIdentificacion;

    @FXML
    private TextField txtNombre;

    @FXML
    private PasswordField txtPassword;

    private final Banco banco = Banco.getInstancia();

    /**
     * Método que se ejecuta al presionar el botón de registrarse
     * @param actionEvent evento de acción
     */
    public void registrarse(ActionEvent actionEvent) {

        try {
            // Se intenta agregar el usuario al banco
            banco.registrarUsuario(
                    txtIdentificacion.getText(),
                    txtNombre.getText(),
                    txtDireccion.getText(),
                    txtCorreo.getText(),
                    txtPassword.getText() );

            // Se muestra un mensaje de éxito y se cierra la ventana
            Utilidades.crearAlerta("El usuario " + txtNombre.getText() + " ha sido registrado correctamente", Alert.AlertType.INFORMATION);
            Utilidades.navegarVentana("/inicio.fxml", "Inicio", txtCorreo, getClass());

        }catch (Exception e){
            Utilidades.crearAlerta(e.getMessage(), Alert.AlertType.ERROR);
        }

    }




    @FXML
    void regresar(ActionEvent event) {
        Utilidades.navegarVentana("/inicio.fxml", "Inicio", txtCorreo, getClass());

    }

}
