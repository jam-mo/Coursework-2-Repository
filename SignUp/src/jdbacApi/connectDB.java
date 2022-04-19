/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbacApi;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;


public class connectDB {
    public static Connection getConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:SignUp.db";
            Connection conn = DriverManager.getConnection(url);
            //JOptionPane.showMessageDialog(null, "Connection Established");
            return conn;
         } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
         return null;
         }
    }
}
