package co.edu.uniquindio.banco.controlador;

import co.edu.uniquindio.banco.BancoApp;
import co.edu.uniquindio.banco.modelo.Sesion;
import co.edu.uniquindio.banco.modelo.entidades.Banco;
import co.edu.uniquindio.banco.modelo.entidades.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginControlador {



    @FXML
    private Button btnIniciarSesion;

    @FXML
    private Button btnRegresar;

    @FXML
    private PasswordField txtContrasena;

    @FXML
    private TextField txtNumeroIdentificacion;

    Banco banco;

    public LoginControlador(){
        banco = Banco.getBanco();
    }

    @FXML
    void iniciarSesion(ActionEvent event) {
        try{
            Usuario usuario = banco.iniciarSesion(txtNumeroIdentificacion.getText(), txtContrasena.getText());
            Sesion sesion = Sesion.getInstancia();
            sesion.setUsuario(usuario);
            BancoApp.crearAlerta("Ha ingresado correctamente", Alert.AlertType.INFORMATION);
            BancoApp.navegarVentana("/panelCliente.fxml", "PanelCliente", event, getClass());
        }
        catch (Exception e){
            BancoApp.crearAlerta(e.getMessage(), Alert.AlertType.ERROR);
        }


    }

    @FXML
    void regresar(ActionEvent event) {
        BancoApp.navegarVentana("/inicio.fxml", "Inicio", event, getClass());

    }

}
