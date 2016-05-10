/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.apache.commons.dbutils.DbUtils;

/**
 *
 * @author PC1
 */
public class FXMLDocumentController implements Initializable {
    
    
    //logowanie
    
    @FXML
    private PasswordField password;
    @FXML
    private TextField login;
    @FXML
    private Button zaloguj;
    @FXML
    private Hyperlink zapomnialemHasla;
    
    public static String log, login2;
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }



@FXML
    private void logowanie(ActionEvent event) {
        Stage stage; 
        Parent root;
        stage = (Stage) zaloguj.getScene().getWindow();
        
        //TODO Validacja sprawdż czy wpisales (wyrażenia regularne)
        
        Connection connection = null;
        try {
            login2 = login.getText();
            log=login2;
            connection = new Driver().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select uzytkownicy.* from uzytkownicy where Email=? and Haslo=?;");
            preparedStatement.setString(1, login.getText());
            preparedStatement.setString(2, password.getText());
            ResultSet rs = preparedStatement.executeQuery();
            
            rs.next();
             
           
            
            
            long count = rs.getRow();
            
            if(count>0) {
                
  
              Integer r = rs.getInt("Idrangi");
     
                String konto;
               
                switch(r) {
                case  4: konto = "panelPracownik.fxml";break;
                case  3: konto = "panelKierownik.fxml";break;
                case  2: konto = "panelDyrektor.fxml";break;
                
                default: konto = "panelAdmin.fxml";break;
                }
                
                
                root = FXMLLoader.load(getClass().getResource(konto));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                DbUtils.closeQuietly(connection);
                stage.show(); 
            
            
            
            } else {
                new Alert(Alert.AlertType.ERROR, "Nie udało się zalogować").show();
            }
           
            
            
        } catch (SQLException ex) {
           new Alert(Alert.AlertType.WARNING,"Problem z bazą").show();
           ex.printStackTrace();
        } catch (IOException ex) {
            new Alert(Alert.AlertType.WARNING,"IO error").show();
        } finally {
            DbUtils.closeQuietly(connection);
        }
        
    }
    
    
    /*
    @FXML
    private void logowanie(ActionEvent event) throws IOException {
        Stage stage; 
        Parent root;
        stage = (Stage) zaloguj.getScene().getWindow();
        
        //logikalogowania
        
        String konto =  "panelKierownik.fxml";
            if(true) {
                konto = "panelPracownik.fxml";
            } else {
                konto = "panelAdmin.fxml";
        }
        root = FXMLLoader.load(getClass().getResource(konto));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    @FXML
    public void handleButtonAction(ActionEvent event) throws IOException {
        Stage stage; 
        Parent root;
        stage = (Stage) zaloguj.getScene().getWindow();
        if(event.getSource()==zaloguj) {
            //Obsługa logowanie
            //Sprawdzisz cy możesz sie zalogowac jak sie możesz zalogowac
            String konto =  "panelKierownik.fxml";
            if(true) {
                konto = "panelPracownik.fxml";
            } else {
                konto = "panelAdmin.fxml";
            }
            
            
            root = FXMLLoader.load(getClass().getResource(konto));
        } else {
            //
            root = FXMLLoader.load(getClass().getResource("logowanie.fxml"));
        }
        
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        
    }
    
    */

    @FXML
    private void zapomnialemHasla() throws IOException {
        
        Stage stage; 
        Parent root;
        stage = (Stage) zapomnialemHasla.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("odzyskiwanieHasla.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    

    
    
    
    
    
    
}
