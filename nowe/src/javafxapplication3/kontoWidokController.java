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
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author sony vaio
 */
public class kontoWidokController implements Initializable {

    @FXML
    private Button wyloguj;
    @FXML
    private Text id;
    @FXML
    private Text imie;
    @FXML
    private Text nazwisko;
    @FXML
    private Text email;
    @FXML
    private Text adres;
    @FXML
    private Text telefon;
    @FXML
    private Text ranga;
    @FXML
    private Button edytujProfil;
    @FXML
    private Button wstecz;
    
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
        
        Connection conn;
        try {
        String login = FXMLDocumentController.log;
        String query = "select Idrangi from uzytkownicy where Email='"+login+"' limit 1";
        conn = new Driver().getConnection();
        //Uruchamiamy zapytanie do bazy danych
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
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
        stage.show();
        }}
        catch (SQLException ex) {
            Logger.getLogger(kontoWidokController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    @FXML
    private void edytujProfil() throws IOException {
        
        Stage stage; 
        Parent root;
        stage = (Stage) edytujProfil.getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("kontoEdycja.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    
    //public void edytujProfil() {
    
    //}
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
                         Connection conn;
                        try {
                            String login = FXMLDocumentController.log;
                            String query = 
                            "select u.*,r.Nazwarangi from uzytkownicy u,rangi r where u.Idrangi=r.Idrangi and Email='"+login+"' limit 1";
                            conn = new Driver().getConnection();
                            //Uruchamiamy zapytanie do bazy danych
                            Statement stmt = conn.createStatement();
                            ResultSet rs = stmt.executeQuery(query);
       
                       // while (rs.next()) {
                       rs.next();
                                int id  = rs.getInt("Iduzytkownika");
                                String imie = rs.getString("Imie");
                                String nazwisko = rs.getString("Nazwisko");
                                String email = rs.getString("Email");
                                //String haslo = rs.getString("haslo");
                                String adres = rs.getString("Adres");
                                String telefon = rs.getString("Telefon");
                                String ranga = rs.getString("Nazwarangi");
                                
                                
                                this.id.setText(""+id);
                                this.imie.setText(imie);
                                this.nazwisko.setText(nazwisko);
                                this.email.setText(email);
                                this.adres.setText(adres);
                                this.telefon.setText(telefon);
                                this.ranga.setText(ranga);
                                
                                
        
                            //Ustawiamy sterownik MySQL
                            //Class.forName("com.mysql.jdbc.Driver");
                        } catch (SQLException ex) {
                            Logger.getLogger(kontoWidokController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                       
                        
        // TODO
    }    
    
    
    
}
