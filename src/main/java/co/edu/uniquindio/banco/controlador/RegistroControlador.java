package co.edu.uniquindio.banco.controlador;

import co.edu.uniquindio.banco.BancoApp;
import co.edu.uniquindio.banco.modelo.entidades.Banco;
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

    Banco banco;

    public RegistroControlador() {
        banco = Banco.getBanco();
    }

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
            BancoApp.crearAlerta("El usuario " + txtNombre + " ha sido registrado correctamente", Alert.AlertType.INFORMATION);
            BancoApp.navegarVentana("/inicio.fxml", "Inicio", actionEvent, getClass());

        }catch (Exception e){
            BancoApp.crearAlerta(e.getMessage(), Alert.AlertType.ERROR);
        }

    }




    @FXML
    void regresar(ActionEvent event) {
        BancoApp.navegarVentana("/inicio.fxml", "Inicio", event, getClass());

    }

}
