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
import jdbacApi.connectDB;

/**
 *
 * @author kokmeng
 */
public class readLevel extends getdata_learning {
    
    Connection con;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    PreparedStatement pstmt1 = null;
    
    String level_id ;
    String context_id;
    String Subcontext_id;
    
    ArrayList level = new ArrayList();
    ArrayList context = new ArrayList();
    ArrayList Subcontext = new ArrayList();
    ArrayList personA = new ArrayList();
    ArrayList personB = new ArrayList();
    
    
    @Override
    protected boolean levels(String languageSelect) {
        
        String readlevel = "SELECT  l.Language_level FROM LANGUAGES sp JOIN LEVELS l ON sp.languages_ID = l.languages_ID  WHERE languages =?;";
        
        con = connectDB.getConnection();
        
        try {
            pstmt = con.prepareStatement(readlevel);
            
            pstmt.setString(1, languageSelect);
            
            ResultSet rs = pstmt.executeQuery();
            
            int n = 0;
            
            while(rs.next()){
                int numColumns = rs.getMetaData().getColumnCount();
                n++;

                for (int i = 1; i <= numColumns; i++) {
                    System.out.print(" something :"+rs.getObject(i));
                    this.level.add(rs.getObject(i));
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
    
    ArrayList getLevelText(){
        return level;
    }

    @Override
    protected boolean context(String languageSelect, String level) {
       boolean getvalue = false; 
        String readContext = "SELECT  c.CONTEXT FROM LANGUAGES sp JOIN LEVELS l ON sp.languages_ID = l.languages_ID  JOIN CONTEXT c   ON l.difficulty_ID = c.difficulty_ID  WHERE languages =? AND Language_level =?;";
        
        
        con = connectDB.getConnection();
        
            try {
                pstmt = con.prepareStatement(readContext);

                pstmt.setString(1, languageSelect);
                pstmt.setString(2, level);

                ResultSet rs = pstmt.executeQuery();

                int n = 0;

                while(rs.next()){
                    int numColumns = rs.getMetaData().getColumnCount();
                    n++;

                    for (int i = 1; i <= numColumns; i++) {
                        System.out.print(" something : "+rs.getObject(i));
                        this.context.add(rs.getObject(i));
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
        
        return getvalue;

    }
    
    ArrayList getContext(){
        return context;
    }
    
    @Override
    protected boolean subcontext(String languageSelect, String level,String context) {
        
        String readSubContext = """
                                SELECT  sc.SUB_CONTEXT
                                FROM LANGUAGES sp JOIN LEVELS l
                                ON sp.languages_ID = l.languages_ID 
                                JOIN CONTEXT c  
                                ON l.difficulty_ID = c.difficulty_ID 
                                JOIN SUB_CONTEXT sc 
                                on c.Context_ID = sc.Context_ID
                                WHERE languages =? AND Language_level =? AND CONTEXT=?;""";
        
        con = connectDB.getConnection();
            try {
                
                pstmt = con.prepareStatement(readSubContext);

                pstmt.setString(1, languageSelect);
                pstmt.setString(2, level);
                pstmt.setString(3, context);

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
    protected boolean ReadtextA(String languageSelect, String level,  String context, String subContext) {
        
        String readPersonA = """
                             SELECT  pA.TEXT
                             FROM LANGUAGES sp JOIN LEVELS l
                             ON sp.languages_ID = l.languages_ID 
                             JOIN CONTEXT c  
                             ON l.difficulty_ID = c.difficulty_ID 
                             JOIN SUB_CONTEXT sc 
                             on c.Context_ID = sc.Context_ID
                             JOIN PERSON_A pA
                             ON sc.SUB_CONTEXT_ID = pA.SUB_CONTEXT_ID
                             WHERE languages =? AND Language_level =? AND CONTEXT=? AND SUB_CONTEXT=?;""";
        con = connectDB.getConnection();
            try {
                
                pstmt = con.prepareStatement(readPersonA);

                pstmt.setString(1, languageSelect);
                pstmt.setString(2, level);
                pstmt.setString(3, context);
                pstmt.setString(4, subContext);

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
    
    @Override
    protected boolean ReadtextB(String languageSelect, String level,  String context, String subContext) {
        
        String readPersonB = """
                             SELECT  pB.TEXT
                             FROM LANGUAGES sp JOIN LEVELS l
                             ON sp.languages_ID = l.languages_ID 
                             JOIN CONTEXT c  
                             ON l.difficulty_ID = c.difficulty_ID 
                             JOIN SUB_CONTEXT sc 
                             on c.Context_ID = sc.Context_ID
                             JOIN PERSON_B pB
                             ON sc.SUB_CONTEXT_ID = pB.SUB_CONTEXT_ID
                             WHERE languages = ? AND Language_level =? AND CONTEXT=? AND SUB_CONTEXT=?;""";
        
        con = connectDB.getConnection();
            try {
                
                pstmt = con.prepareStatement(readPersonB);

                pstmt.setString(1, languageSelect);
                pstmt.setString(2, level);
                pstmt.setString(3, context);
                pstmt.setString(4, subContext);

                ResultSet rs = pstmt.executeQuery();

                int n = 0;

                while(rs.next()){
                    int numColumns = rs.getMetaData().getColumnCount();
                    n++;

                    for (int i = 1; i <= numColumns; i++) {
                        System.out.print(" something : "+rs.getObject(i));
                        this.personB.add(rs.getObject(i));
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
    ArrayList getPersonB(){
        return personB;
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
