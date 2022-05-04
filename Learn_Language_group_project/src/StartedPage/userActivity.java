/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StartedPage;

import java.sql.*;
import javadb.ConnectingDB;

/**
 *
 * @author kokmeng
 */
public class userActivity { 
    
    Connection con;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    
    Timestamp time ; // initiated timestamp
    
    protected boolean userLogintime(int getEmail){ // set timestamp on database for login
        
        String inputloginTime = """
                                INSERT INTO USERACTIVITY (
                                                             user_ID,
                                                             loginTime
                                                         )
                                                         VALUES (
                                                             ?,
                                                             ?
                                                         );""";
        
        con = ConnectingDB.connect();
        
        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        
        System.out.println("query : " + inputloginTime);
        System.out.println("Date : " + date);
        
        try{
            
            pstmt = con.prepareStatement(inputloginTime);
            
            pstmt.setInt(1, getEmail);
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
    
    protected boolean userLogouttime(int getEmail){ // set timestamp on database for logout
        
        String inputlogOutTime = """
                                 INSERT INTO USERACTIVITY (
                                                              user_ID,
                                                              logoutTime
                                                          )
                                                          VALUES (
                                                              ?,
                                                              ?
                                                          );""";
        
        con = ConnectingDB.connect();
        
        java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
        
        
        System.out.println("query : " + inputlogOutTime);
        System.out.println("Date : " + date);
        
        try{
            
            pstmt = con.prepareStatement(inputlogOutTime);
            
            pstmt.setInt(1, getEmail);
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
    
    protected boolean getLoginTime(){
        
        String getLoginTime = "";
        
        return false;
    }
    
    protected boolean getLogOutTime(){
        
        
        
        return false;
    }
    
    
}
