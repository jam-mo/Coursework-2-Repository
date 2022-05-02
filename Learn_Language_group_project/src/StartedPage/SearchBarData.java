/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StartedPage;

import java.sql.*;
import java.util.*;
import jdbacApi.*;

/**
 *
 * @author kokmeng/christopher
 */
public class SearchBarData {
    Connection con;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    PreparedStatement pstmt1 = null;
    
    ArrayList<String> CopyContextA1 = new ArrayList<>();
        ArrayList<String> CopyContextA2 = new ArrayList<>();
            ArrayList<String> CopyContextB1 = new ArrayList<>();
                ArrayList<String> CopyContextB2 = new ArrayList<>();
    
    ArrayList<String> CopySubValueA1 = new ArrayList<>();
        ArrayList<String> CopySubValueA2 = new ArrayList<>();
            ArrayList<String> CopySubValueB1 = new ArrayList<>();
                ArrayList<String> CopySubValueB2 = new ArrayList<>();
                
    protected boolean ReadContextA1(){
        con = connectDB.getConnection();
        String contextA1 = """
                        SELECT CONTEXT_TITLE
                                              FROM CONTEXT
                                              WHERE CONTEXT_LEVEL = 'A1';
                           
                           """;
        
        try {
            pstmt = con.prepareStatement(contextA1);
            
            ResultSet rs = pstmt.executeQuery();
            int n = 0;
            while (rs.next()) {
                int numColumns = rs.getMetaData().getColumnCount();
                n++;

                for (int i = 1; i <= numColumns; i++) {
                    System.out.print("Context value:" + rs.getObject(i));
                    CopyContextA1.add((String) rs.getObject(i));
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
    
    protected boolean ReadContextA2(){
        con = connectDB.getConnection();
        String contextA2 = """
                        SELECT CONTEXT_TITLE
                                              FROM CONTEXT
                                              WHERE CONTEXT_LEVEL = 'A2';
                           """;
        
        try {
            pstmt = con.prepareStatement(contextA2);
            
            ResultSet rs = pstmt.executeQuery();
            int n = 0;
            while (rs.next()) {
                int numColumns = rs.getMetaData().getColumnCount();
                n++;

                for (int i = 1; i <= numColumns; i++) {
                    System.out.print("Context value:" + rs.getObject(i));
                    CopyContextA2.add((String) rs.getObject(i));
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
    
    protected boolean ReadContextB1(){
        con = connectDB.getConnection();
        String contextB1 = """
                        SELECT CONTEXT_TITLE
                                              FROM CONTEXT
                                              WHERE CONTEXT_LEVEL = 'B1';
                           """;
        try {
            pstmt = con.prepareStatement(contextB1);
            
            ResultSet rs = pstmt.executeQuery();
            int n = 0;
            while (rs.next()) {
                int numColumns = rs.getMetaData().getColumnCount();
                n++;

                for (int i = 1; i <= numColumns; i++) {
                    System.out.print("Context value:" + rs.getObject(i));
                    CopyContextB1.add((String) rs.getObject(i));
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
    
    protected boolean ReadContextB2(){
        con = connectDB.getConnection();
        String contextB2 = """
                        SELECT CONTEXT_TITLE
                                              FROM CONTEXT
                                              WHERE CONTEXT_LEVEL = 'B2';
                           """;
        
        try {
            pstmt = con.prepareStatement(contextB2);
            
            ResultSet rs = pstmt.executeQuery();
            int n = 0;
            while (rs.next()) {
                int numColumns = rs.getMetaData().getColumnCount();
                n++;

                for (int i = 1; i <= numColumns; i++) {
                    System.out.print("Context value:" + rs.getObject(i));
                    CopyContextB2.add((String) rs.getObject(i));
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
    
    
    protected boolean ReadSubContextA1(){
        con = connectDB.getConnection();
        String SubcontextA1 = """
                        SELECT SUB_CONTEXT
                                              FROM CONTEXT
                                              WHERE CONTEXT_LEVEL = 'A1';
                           """;
        
        try {
            pstmt = con.prepareStatement(SubcontextA1);
            
            ResultSet rs = pstmt.executeQuery();
            int n = 0;
            while (rs.next()) {
                int numColumns = rs.getMetaData().getColumnCount();
                n++;

                for (int i = 1; i <= numColumns; i++) {
                    System.out.print("Context value:" + rs.getObject(i));
                    CopySubValueA1.add((String) rs.getObject(i));
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
    
    protected boolean ReadSubContextA2(){
        con = connectDB.getConnection();
        String SubcontextA2 = """
                        SELECT SUB_CONTEXT
                                              FROM CONTEXT
                                              WHERE CONTEXT_LEVEL = 'A2';
                           """;
        
        try {
            pstmt = con.prepareStatement(SubcontextA2);
            
            ResultSet rs = pstmt.executeQuery();
            int n = 0;
            while (rs.next()) {
                int numColumns = rs.getMetaData().getColumnCount();
                n++;

                for (int i = 1; i <= numColumns; i++) {
                    System.out.print("Context value:" + rs.getObject(i));
                    CopySubValueA2.add((String) rs.getObject(i));
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
    
    protected boolean ReadSubContextB1(){
        con = connectDB.getConnection();
        String SubcontextB1 = """
                        SELECT SUB_CONTEXT
                                              FROM CONTEXT
                                              WHERE CONTEXT_LEVEL = 'B1';
                           """;
        
        try {
            pstmt = con.prepareStatement(SubcontextB1);
            
            ResultSet rs = pstmt.executeQuery();
            int n = 0;
            while (rs.next()) {
                int numColumns = rs.getMetaData().getColumnCount();
                n++;

                for (int i = 1; i <= numColumns; i++) {
                    System.out.print("Context value:" + rs.getObject(i));
                    CopySubValueB1.add((String) rs.getObject(i));
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
    
    protected boolean ReadSubContextB2(){
        con = connectDB.getConnection();
        String SubcontextB2 = """
                        SELECT SUB_CONTEXT
                                              FROM CONTEXT
                                              WHERE CONTEXT_LEVEL = 'B2';
                           """;
        
        try {
            pstmt = con.prepareStatement(SubcontextB2);
            
            ResultSet rs = pstmt.executeQuery();
            int n = 0;
            while (rs.next()) {
                int numColumns = rs.getMetaData().getColumnCount();
                n++;

                for (int i = 1; i <= numColumns; i++) {
                    System.out.print("Context value:" + rs.getObject(i));
                    CopySubValueB2.add((String) rs.getObject(i));
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
    
    ArrayList CopyContextA1(){
        return CopyContextA1;
    }
    
    ArrayList CopyContextA2(){
        return CopyContextA2;
    }
    
    ArrayList CopyContextB1(){
        return CopyContextB1;
    }
    
    ArrayList CopyContextB2(){
        return CopyContextB2;
    }
    
    ArrayList CopySubValueA1(){
        return CopySubValueA1;
    }
    
    ArrayList CopySubValueA2(){
        return CopySubValueA2;
    }
    
    ArrayList CopySubValueB1(){
        return CopySubValueB1;
    }
    
    ArrayList CopySubValueB2(){
        return CopySubValueB2;
    }
    
    
                
}
