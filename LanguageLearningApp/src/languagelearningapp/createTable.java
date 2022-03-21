/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package languagelearningapp;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;



public class createTable {

    public static void main(String[] args) {
        Connection con = connectDB.getConnection();
        Statement stmt = null;
        String createString;
        createString = "CREATE TABLE if not exists employee (\n"
                + "            empID     INTEGER      PRIMARY KEY,\n"
                + "            empName  VARCHAR (15),\n"
                + "            empJob  VARCHAR (15),\n"
                + "            empSal   INT (11)\n" + ") ;";
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(createString);
            con.commit();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
        }
    }    
}

