/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javadb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Jamie
 */
public class ConnectingDB {
    public static Connection connect() {
        Connection con = null;
        try {
            Class.forName("org.sqlite.JDBC");
            
            con = DriverManager.getConnection("jdbc:sqlite:appDB.db"); // connection to our database
            System.out.println("Database Connected.");
            } 
        catch (ClassNotFoundException | SQLException e ) {
            System.out.println(e + "");
        }
        
        return con;
    }

    
    
}
