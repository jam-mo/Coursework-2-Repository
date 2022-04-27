/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbacApi;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.logging.Logger;


public class createDB {
    public static void main(String[] args) {
        Connect connect = new Connect();
    }
}

class Connect{
    private String urlSQLite;
    private Driver driverSQLite;
    private Connection conSQLite;
    
    public Connect() {
        urlSQLite = "jdbc:sqlite:LEARNING_LANGUAGES.db";
        try {
            driverSQLite = new org.sqlite.JDBC();
            DriverManager.registerDriver(driverSQLite);
            System.out.println("Driver for SQLite downloaded.");
        } catch (Exception e) {
            System.out.println("Problem with download driver for SQLite: " + e.getMessage());
        }
        try {
            conSQLite = DriverManager.getConnection(urlSQLite);
            System.out.println("Connection to SQLite is done.");
        } catch (Exception e) {
            System.out.println("Problem with connection to SQLite: " + e.getMessage());
        }
        try {
            if (!conSQLite.isClosed()) {
            conSQLite.close();
            System.out.println("Connection to SQLite closed.");
            }
        } catch (Exception e) {
            System.out.println("Problem with close connection of SQLite");
        }
   }
}

