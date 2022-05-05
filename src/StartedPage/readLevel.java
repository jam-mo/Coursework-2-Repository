/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StartedPage;

import Validation_Email_Password.getdata_learning;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javadb.ConnectingDB;

/**
 *
 * @author christopher / Jamie
 */

public class readLevel extends getdata_learning { //extends abstract class getdata_learning
    
    Connection con;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    PreparedStatement pstmt1 = null;
    
    String level_id ;
    String context_id;
    String Subcontext_id;
    
    //Created arrayList and String
    
    ArrayList context = new ArrayList();
    ArrayList Imglevel = new ArrayList();
    ArrayList Imgcontext = new ArrayList();
    ArrayList ImgSubcontext = new ArrayList();
    ArrayList Subcontext = new ArrayList();
    ArrayList personA = new ArrayList();
    ArrayList ReadWord = new ArrayList();
    String readContext;
    
    

    @Override
    protected boolean context(String level) { // read Context by level 
       boolean getvalue = false; 
        String readContext = """
                        SELECT CONTEXT_TITLE
                              FROM CONTEXT
                              WHERE CONTEXT_LEVEL = ?
                            ;
                             """;  //if levels selected equals to the context levels it will be shown
        
        
        con = ConnectingDB.connect();
        
            try {
                pstmt = con.prepareStatement(readContext);

                pstmt.setString(1,level); // insert value to database  where (Context_Level)
                
                ResultSet rs = pstmt.executeQuery();

                int n = 0;

                while(rs.next()){
                    int numColumns = rs.getMetaData().getColumnCount();
                    n++;

                    for (int i = 1; i <= numColumns; i++) {
                        System.out.print(" something : "+rs.getObject(i));
                        this.context.add(rs.getObject(i)); //Adding to arraylist
                    }
                    System.out.println("");
                }
                System.out.println("");
                rs.close();
            } catch (SQLException ex) { // try exception 
                Logger.getLogger(readLevel.class.getName()).log(Level.SEVERE, null, ex);
            }finally {
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
        
        return getvalue;

    }
    
    ArrayList getContext(){  //returns the title name value for each context
        return context;
    }
    
    @Override
    protected boolean subcontext( String level,String context) { // read Sub Context by context and level
        
        String readSubContext = """
                        SELECT SUB_CONTEXT
                                FROM CONTEXT
                                WHERE CONTEXT_LEVEL = ? And CONTEXT_TITLE = ?
                                """; //if context selected equals to the context and level, the sub context will appear
        
        con = ConnectingDB.connect();
            try {
                
                pstmt = con.prepareStatement(readSubContext);

                pstmt.setString(1, level);
                pstmt.setString(2, context);

                ResultSet rs = pstmt.executeQuery();

                int n = 0;

                while(rs.next()){
                    int numColumns = rs.getMetaData().getColumnCount();
                    n++;

                    for (int i = 1; i <= numColumns; i++) {
                        System.out.print(" something : "+rs.getObject(i));
                        this.Subcontext.add(rs.getObject(i));
                    }
                    System.out.println("");
                }
                System.out.println("");
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(readLevel.class.getName()).log(Level.SEVERE, null, ex);
            }finally {
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
    
    ArrayList getSubcontext(){
        return Subcontext;
    }

    @Override
    protected boolean ReadtextA( String level, String subContext) {
        
        String readPersonA = """
                        SELECT CONVERSATION_PROMPT
                            FROM CONTEXT
                            WHERE CONTEXT_LEVEL = ? And SUB_CONTEXT=?
                             """; //if Sub context selected equals to the Sub_context and level, the conversation will appear
        con = ConnectingDB.connect();
            try {
                
                pstmt = con.prepareStatement(readPersonA);

                pstmt.setString(1, level);
                pstmt.setString(2, subContext);

                ResultSet rs = pstmt.executeQuery();

                int n = 0;

                while(rs.next()){
                    int numColumns = rs.getMetaData().getColumnCount();
                    n++;

                    for (int i = 1; i <= numColumns; i++) {
                        System.out.print(" something : "+rs.getObject(i));
                        this.personA.add(rs.getObject(i));
                    }
                    System.out.println("");
                }
                System.out.println("");
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(readLevel.class.getName()).log(Level.SEVERE, null, ex);
            }finally {
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
    ArrayList getPersonA(){
        return personA;
    }  
    
    protected boolean readImgContext(String level){ // 
        String readContext = """
                        SELECT CONTEXT_TITLE_img
                            FROM CONTEXT
                            WHERE CONTEXT_LEVEL = ?
                             """; //if levels selected equals to the context_img, image will be shown
        
        
        con = ConnectingDB.connect();
        
            try {
                pstmt = con.prepareStatement(readContext);

                pstmt.setString(1, level);

                ResultSet rs = pstmt.executeQuery();

                int n = 0;

                while(rs.next()){
                    int numColumns = rs.getMetaData().getColumnCount();
                    n++;

                    for (int i = 1; i <= numColumns; i++) {
                        System.out.print(" something : "+rs.getObject(i));
                        this.Imgcontext.add(rs.getObject(i));
                    }
                    System.out.println("");
                }
                System.out.println("");
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(readLevel.class.getName()).log(Level.SEVERE, null, ex);
            }finally {
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
    
    ArrayList getImg(){
        return Imgcontext;
    }
    
    protected boolean readImgSubContext(String level, String context){
        String readContext = """
                        SELECT SUB_CONTEXT_img
                            FROM CONTEXT
                            WHERE CONTEXT_LEVEL = ? And CONTEXT_TITLE = ?
                             """; //if context selected equals to the context and level, the sub context_img will appear
        
        
        con = ConnectingDB.connect();
        
            try {
                pstmt = con.prepareStatement(readContext);
                
                pstmt.setString(1, level);
                pstmt.setString(2, context);

                ResultSet rs = pstmt.executeQuery();

                int n = 0;

                while(rs.next()){
                    int numColumns = rs.getMetaData().getColumnCount();
                    n++;

                    for (int i = 1; i <= numColumns; i++) {
                        System.out.print(" something : "+rs.getObject(i));
                        this.ImgSubcontext.add(rs.getObject(i));
                    }
                    System.out.println("");
                }
                System.out.println("");
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(readLevel.class.getName()).log(Level.SEVERE, null, ex);
            }finally {
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
    
    ArrayList getSubImg(){
        return ImgSubcontext;
    }
    
    @Override
    protected boolean ReadContext( String level, String Context) {
        
        String readPersonB = """
                            SELECT CONTEXT_TITLE
                               FROM CONTEXT
                               WHERE CONTEXT_LEVEL=? AND SUB_CONTEXT =? ;
                             """; 
        
        con = ConnectingDB.connect();
            try {
                
                pstmt = con.prepareStatement(readPersonB);

                pstmt.setString(1, level);
                pstmt.setString(2, Context);

                ResultSet rs = pstmt.executeQuery();

                int n = 0;

                while(rs.next()){
                    int numColumns = rs.getMetaData().getColumnCount();
                    n++;

                    for (int i = 1; i <= numColumns; i++) {
                        System.out.print(" something : "+rs.getObject(i));
                        readContext = (String)rs.getObject(i);
                    }
                    System.out.println("");
                }
                System.out.println("");
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(readLevel.class.getName()).log(Level.SEVERE, null, ex);
            }finally {
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
    String readContext(){
        return readContext;
    }
    
    protected boolean ReadWord( String level, String subContext) {
        
        String readword = """
                        SELECT SPANISH_WORDS
                            FROM CONTEXT
                            WHERE CONTEXT_LEVEL = ? And SUB_CONTEXT=?
                             """; 
        con = ConnectingDB.connect();
            try {
                
                pstmt = con.prepareStatement(readword);

                pstmt.setString(1, level);
                pstmt.setString(2, subContext);

                ResultSet rs = pstmt.executeQuery();

                int n = 0;

                while(rs.next()){
                    int numColumns = rs.getMetaData().getColumnCount();
                    n++;

                    for (int i = 1; i <= numColumns; i++) {
                        System.out.print(" something : "+rs.getObject(i));
                        this.ReadWord.add(rs.getObject(i));
                    }
                    System.out.println("");
                }
                System.out.println("");
                rs.close();
            } catch (SQLException ex) {
                Logger.getLogger(readLevel.class.getName()).log(Level.SEVERE, null, ex);
            }finally {
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
    ArrayList readWord(){
        return ReadWord;
    }  
    
    
    
//    public static void main(String[] arg){
//        readLevel  lea = new readLevel();
//        lea.ReadtextA("SPANISH","LEVEL_A1" ,"Ordering food and drink" ,"Takeaway" );
//        lea.ReadtextB("SPANISH","LEVEL_A1" ,"Ordering food and drink" ,"Takeaway" );
//        
//        System.out.println("_________________A_B_____________________");
//        
//        for (Object personA : lea.getPersonA()) {
//            
//            System.out.println("• Person A : "+personA);
//            System.out.println("• Person B : ••••••••••••••••••••••••••••••••••");
//            
//        }
//        
//        System.out.println("_________END__________");
//        
//        for (Object personB : lea.getPersonB()) {
//            
//            System.out.println("• Person B : "+personB);
//            System.out.println("• Person A : ••••••••••••••••••••••••••••••••••");
//            
//        }
//        
//    }
    
}
