package co.edu.uniquindio.banco.controlador;

import co.edu.uniquindio.banco.BancoApp;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Clase que representa el controlador de la vista Inicio
 * @author caflorezvi
 */
public class InicioControlador {

    /**
     * Método que permite ir a la vista de Iniciar Sesión
     * @param actionEvent Evento que representa el clic del botón
     */
    public void irIniciarSesion(ActionEvent actionEvent) {
        BancoApp.navegarVentana("/login.fxml", "Banco - Iniciar Sesión", actionEvent, getClass());
    }

    /**
     * Método que permite ir a la vista de Registro de Cliente
     * @param actionEvent Evento que representa el clic del botón
     */
    public void irRegistroCliente(ActionEvent actionEvent) {
        BancoApp.navegarVentana("/registro.fxml", "Banco - Registro de Cliente", actionEvent, getClass());
    }

    /**
     * Método que permite ir a la venana indicada por el nombre del archivo FXML
     * @param nombreArchivoFxml Nombre del archivo FXML
     * @param tituloVentana Título de la ventana
     */

}

