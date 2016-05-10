/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sony vaio
 */
public class ProjektyKierownikController implements Initializable {

    @FXML
    private Button wyloguj;
    @FXML
    private Button wstecz;
    @FXML
    private Button utworzProjekt;
    @FXML
    private Button edytujProjekt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void wyloguj() throws IOException {
        
        Stage stage; 
        Parent root;
        stage = (Stage) wyloguj.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("logowanie.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void wstecz() throws IOException {
        
        Stage stage; 
        Parent root;
        stage = (Stage) wstecz.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("panelKierownik.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void utworzProjekt() throws IOException {
        
        Stage stage; 
        Parent root;
        stage = (Stage) utworzProjekt.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("utworzProjektKierownik.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void edytujProjekt() throws IOException {
        
        Stage stage; 
        Parent root;
        stage = (Stage) edytujProjekt.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("edytujProjektKierownik.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
}
