package co.edu.uniquindio.banco.controlador;

import co.edu.uniquindio.banco.BancoApp;
import co.edu.uniquindio.banco.modelo.Sesion;
import co.edu.uniquindio.banco.modelo.entidades.Banco;
import co.edu.uniquindio.banco.modelo.entidades.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class ActualizacionControlador {

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
    Usuario usuario;
    Sesion sesion;


    @FXML
    public void initialize() {
        banco = Banco.getBanco();
        sesion = Sesion.getInstancia();
        usuario = sesion.getUsuario();
        txtNombre.setText(usuario.getNombre());
        txtCorreo.setText(usuario.getEmail());
        txtDireccion.setText(usuario.getDireccion());
        txtIdentificacion.setText(usuario.getId());
        txtPassword.setText(usuario.getPassword());
    }

    @FXML
    public void actualizar(ActionEvent actionEvent) {

        try {
            // Se intenta agregar el usuario al banco
            banco.actualizarContacto(
                    usuario.getId(),
                    txtIdentificacion.getText(),
                    txtNombre.getText(),
                    txtDireccion.getText(),
                    txtCorreo.getText(),
                    txtPassword.getText() );

            // Se muestra un mensaje de éxito y se cierra la ventana
            BancoApp.crearAlerta("El usuario " + txtNombre.getText() + " ha sido actualizado correctamente", Alert.AlertType.INFORMATION);
            BancoApp.navegarVentana("/panelCliente.fxml", "Inicio", actionEvent, getClass());

        }catch (Exception e){
            BancoApp.crearAlerta(e.getMessage(), Alert.AlertType.ERROR);
        }

    }

    @FXML
    void regresar(ActionEvent event) {
        BancoApp.navegarVentana("/panelCliente.fxml", "Panel", event, getClass());
    }

}
