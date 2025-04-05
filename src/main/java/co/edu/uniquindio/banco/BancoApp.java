package co.edu.uniquindio.banco;

import co.edu.uniquindio.banco.modelo.entidades.Banco;
import co.edu.uniquindio.banco.modelo.entidades.BilleteraVirtual;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**
 * Clase que representa la aplicación de un banco y que se encarga
 * de cargar la ventana principal de la aplicación.
 * @author caflorezvi
 */
public class BancoApp extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        crearDatosPrueba();
        FXMLLoader loader = new FXMLLoader(BancoApp.class.getResource("/inicio.fxml"));
        Parent parent = loader.load();

        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Banco");
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch(BancoApp.class, args);
    }

    public static void navegarVentana(String fxml, String titulo, ActionEvent event, Class<?> clase) {
        try {
            FXMLLoader loader = new FXMLLoader(clase.getResource(fxml));
            Parent root = loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle(titulo);
            stage.setScene(new Scene(root));
            stage.centerOnScreen();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Método que se encarga de mostrar una alerta en pantalla
     * @param mensaje mensaje a mostrar
     * @param tipo tipo de alerta
     */
    public static void crearAlerta(String mensaje, Alert.AlertType tipo){
        Alert alert = new Alert(tipo);
        alert.setTitle("Alerta");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public void crearDatosPrueba(){
        try{
            Banco banco = Banco.getBanco();
            banco.registrarUsuario("001", "Laura Martínez", "Calle 10 #20-30", "laura@email.com", "pass123");
            BilleteraVirtual billeteraVirtual = banco.buscarBilleteraUsuario("001");
            billeteraVirtual.setSaldo(10000);
            banco.registrarUsuario("002", "Carlos Gómez", "Av. Central #45-67", "carlos@email.com", "secure456");
            BilleteraVirtual billeteraVirtual2 = banco.buscarBilleteraUsuario("002");
            billeteraVirtual2.setSaldo(5000);
            System.out.println(billeteraVirtual.getNumero());
            System.out.println(billeteraVirtual2.getNumero());

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
