/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StartedPage;

import java.sql.*;
import javax.swing.*;
import jdbacApi.*;

/**
 *
 * @author kokmeng
 */
public class userActivity {
    
    Connection con;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    
    protected boolean userLogintime(String getEmail){
        
        String inputloginTime = """
                                INSERT INTO USERACTIVITY (
                                                             userEmail,
                                                             loginTime
                                                         )
                                                         VALUES (
                                                             ?,
                                                             ?
                                                         );""";
        
        con = connectDB.getConnection();
        
        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        
        System.out.println("query : " + inputloginTime);
        System.out.println("Date : " + date);
        
        try{
            
            pstmt = con.prepareStatement(inputloginTime);
            
            pstmt.setString(1, getEmail);
            pstmt.setTimestamp(2, date);
            
            pstmt.executeUpdate();
            
            pstmt.close();
            
            con.commit();
            
        }
        catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }finally{
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException ex) {
                    System.err.println("SQLException: " + ex.getMessage());
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    System.err.println("SQLException: " + ex.getMessage());
                }
            }
        }
        
        
        return false;
    }
    
    protected boolean userLogouttime(String getEmail){
        
        String inputlogOutTime = """
                                 INSERT INTO USERACTIVITY (
                                                              userEmail,
                                                              logoutTime
                                                          )
                                                          VALUES (
                                                              ?,
                                                              ?
                                                          );""";
        
        con = connectDB.getConnection();
        
        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        
        System.out.println("query : " + inputlogOutTime);
        System.out.println("Date : " + date);
        
        try{
            
            pstmt = con.prepareStatement(inputlogOutTime);
            
            pstmt.setString(1, getEmail);
            pstmt.setTimestamp(2, date);
            
            pstmt.executeUpdate();
            
            pstmt.close();
            
            con.commit();
            
        }
        catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }finally{
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException ex) {
                    System.err.println("SQLException: " + ex.getMessage());
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException ex) {
                    System.err.println("SQLException: " + ex.getMessage());
                }
            }
        }
        
        return false;
    }
    
    
}
