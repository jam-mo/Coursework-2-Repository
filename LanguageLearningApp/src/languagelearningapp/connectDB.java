/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package languagelearningapp;

/**
 *
 * @author w1806925
 */
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class connectDB {
    
      public static Connection getConnection() {

        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:languageApp.db";
            Connection con = DriverManager.getConnection(url);
            //JOptionPane.showMessageDialog(null, "Connection Established");
            return con;
        } catch (Exception e) {
            //JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
     
    
}
