/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
public class panelDyrektorController implements Initializable {

    @FXML
    private Button raporty;
    @FXML
    private Button kierownik;
    @FXML
    private Button wyloguj;
    @FXML
    private Button projekty;
    @FXML
    private Button mojeKonto;
    
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
    private void mojeKonto() throws IOException {
        
        Stage stage; 
        Parent root;
        stage = (Stage) mojeKonto.getScene().getWindow();
        
        root = FXMLLoader.load(getClass().getResource("kontoWidok.fxml"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void projekty() throws IOException {
        
        Stage stage; 
        Parent root;
        stage = (Stage) projekty.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("projektyDyrektor.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    

    
    
}
