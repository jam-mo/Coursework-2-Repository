/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package csvtesting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jamie
 */
public class cnctDB {
    public static Connection cnct() {
        Connection con4 = null;
        try { // test trying to read db
            Class.forName("org.sqlite.JDBC");
            
            con4 = DriverManager.getConnection("jdbc:sqlite:dbtest.db"); // connection to our database
            System.out.println("Database Connected.");
            } 
        catch (ClassNotFoundException | SQLException e ) {
            System.out.println(e + "");
        }
        
        return con4;
    }
    
}
