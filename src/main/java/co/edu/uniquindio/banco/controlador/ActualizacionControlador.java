package co.edu.uniquindio.banco.controlador;

import co.edu.uniquindio.banco.BancoApp;
import co.edu.uniquindio.banco.modelo.Sesion;
import co.edu.uniquindio.banco.modelo.entidades.Banco;
import co.edu.uniquindio.banco.modelo.entidades.Usuario;
import co.edu.uniquindio.banco.utilidades.Utilidades;
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

    private final Banco banco = Banco.getInstancia();
    Usuario usuario;
    Sesion sesion;


    @FXML
    public void initialize() {
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
            Utilidades.crearAlerta("El usuario " + txtNombre.getText() + " ha sido actualizado correctamente", Alert.AlertType.INFORMATION);
            Utilidades.navegarVentana("/panelCliente.fxml", "Inicio", txtCorreo, getClass());

        }catch (Exception e){
            Utilidades.crearAlerta(e.getMessage(), Alert.AlertType.ERROR);
        }

    }

    @FXML
    void regresar(ActionEvent event) {
        Utilidades.navegarVentana("/panelCliente.fxml", "Panel",txtCorreo, getClass());
    }

}
