/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validation_Email_Password;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbacApi.connectDB;

/**
 *
 * @author kokmeng / christopher
 */

public class readDataforSearch {
    
    Connection con;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    PreparedStatement pstmt1 = null;
    
    ArrayList<String> CopyValue = new ArrayList<String>();
    
    ArrayList<String> ConpyContextA = new ArrayList<String>();
        ArrayList<String> ConpyContextB = new ArrayList<String>();
            ArrayList<String> ConpyContextC = new ArrayList<String>();
                ArrayList<String> ConpyContextD = new ArrayList<String>();
    
    ArrayList<String> CopySubValue = new ArrayList<String>();
    
    ArrayList<String> CopySubValueA = new ArrayList<String>();
        ArrayList<String> CopySubValueB = new ArrayList<String>();
            ArrayList<String> CopySubValueC = new ArrayList<String>();
                ArrayList<String> CopySubValueD = new ArrayList<String>();
    
    protected boolean ReadContect(){
        con = connectDB.getConnection();
        String getContext = """
                            SELECT CONTEXT
                              FROM CONTEXT;""";
        
        try {
            pstmt = con.prepareStatement(getContext);
            
            ResultSet rs = pstmt.executeQuery();
            int n = 0;
            while (rs.next()) {
                int numColumns = rs.getMetaData().getColumnCount();
                n++;

                for (int i = 1; i <= numColumns; i++) {
                    System.out.print("Context value:" + rs.getObject(i));
                    CopyValue.add((String) rs.getObject(i));
                }
                System.out.println("");
            }
            rs.close();
            
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
        
        return false;
    }
    
    protected boolean ReadSubContect(){
        con = connectDB.getConnection();
        String getSubContext = """
                                SELECT SUB_CONTEXT
                                 FROM SUB_CONTEXT;
                               """;
        
        try {
            pstmt = con.prepareStatement(getSubContext);
            
            ResultSet rs = pstmt.executeQuery();
            int n = 0;
            while (rs.next()) {
                int numColumns = rs.getMetaData().getColumnCount();
                n++;

                for (int i = 1; i <= numColumns; i++) {
                    System.out.print("Sub_Context value:" + rs.getObject(i));
                    CopySubValue.add((String) rs.getObject(i));
                }
                System.out.println("");
            }
            rs.close();
            
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
        
        
        return false;
    }
    
    ArrayList copyValue(){
        return CopyValue;
    }
    
    ArrayList copySubValue(){
        return CopySubValue;
    }
    
    protected boolean ReadLevel(){
        
        return false;
        
    }
    
    public static void main(String[] arg){
        
        readDataforSearch rds= new readDataforSearch();
        rds.ReadContect();
        rds.ReadSubContect();
        
        for(int i = 0; i < rds.copyValue().size() ; i++){
            System.out.println("Steal value : " + rds.copyValue().get(i));
        }
        
    }
    
    
}
