/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Oregano
 */
public class Driver {
     Connection myConn = null;

public Driver() throws SQLException{
    


// 1.polaczenie z baza
myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mydb", "root" , "zespoloweg3");
// 2. statement

// 3. zapytanie



    
}
public Connection getConnection(){
    return this.myConn;
    
}
}