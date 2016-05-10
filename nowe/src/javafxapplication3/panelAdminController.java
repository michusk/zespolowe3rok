/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sony vaio
 */
public class panelAdminController implements Initializable {

    @FXML
    private Button wyloguj;
    @FXML
    private Button mojeKonto;
    @FXML
    private Button edytujKonta;
    @FXML
    private Text zalogowanyJako;
    
    
    private Text nazwisko;
    
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
    @FXML
    private void edytujKonta() throws IOException {
        
        Stage stage; 
        Parent root;
        stage = (Stage) edytujKonta.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("dodajEdytujKontaAdmin.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
    

    /**
     * Initializes the controller class.
     */
     public void initialize(URL url, ResourceBundle rb) {
        
        
                         
     }
    

    

      @FXML
      private void zalogowanyJako(MouseEvent event) {
          Connection conn;
                        try {
                            String login = FXMLDocumentController.log;
                            String query = 
                            "select nazwisko from uzytkownicy where  Email='"+login+"' limit 1";
                            conn = new Driver().getConnection();
                            //Uruchamiamy zapytanie do bazy danych
                            Statement stmt = conn.createStatement();
                            ResultSet rs = stmt.executeQuery(query);
       
                       // while (rs.next()) {
                       rs.next();
                             
                                String nazwisko = rs.getString("Nazwisko");
                               
                                
                                
                             
                                this.nazwisko.setText(nazwisko);
                               
                                
        
                            //Ustawiamy sterownik MySQL
                            //Class.forName("com.mysql.jdbc.Driver");
                        } catch (SQLException ex) {
                            Logger.getLogger(kontoWidokController.class.getName()).log(Level.SEVERE, null, ex);
                        }
        
    }
}

    
    

