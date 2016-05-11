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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sony vaio
 */
public class EdytujProjektKierownikController implements Initializable {

    @FXML
    private Button wstecz;
    @FXML
    private Button wyloguj;
    @FXML
    private TextArea Opisp;
    @FXML
    private TextField Postepp;
    
    
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        Connection conn;
                        try{
                           String id_pro = "01";
                           String query = 
                           "select Postepp, Opisp  from Projekty where  Idprojektu='"+id_pro+"' limit 1";
                           conn = new Driver().getConnection();
                           Statement stmt = conn.createStatement();
                           ResultSet rs = stmt.executeQuery(query);
                           
                        rs.next();
                        
                                int Postepp=rs.getInt("Postepp");
                                String Opisp=rs.getString("Opisp");
                                
                                
                                
                                this.Postepp.setText(""+Postepp);
                                this.Opisp.setText(Opisp);
                           
                       }
                        
                        catch (SQLException ex) {
                            Logger.getLogger(kontoWidokController.class.getName()).log(Level.SEVERE, null, ex);
                        }
        
    }    
    
    
    
    @FXML
    private void wstecz() throws IOException {
        
        Stage stage; 
        Parent root;
        stage = (Stage) wstecz.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("projektyKierownik.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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
    private void Opisp(MouseEvent event) {
    }

    @FXML
    private void Postepp(ActionEvent event) {
    }
    
}
