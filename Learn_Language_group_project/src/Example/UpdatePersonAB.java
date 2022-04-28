/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Example;

import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import jdbacApi.connectDB;

/**
 *
 * @author kokmeng
 */
public class UpdatePersonAB {
    
    ArrayList context_id  = new ArrayList();
    ArrayList Subcontext_id  = new ArrayList();
    
    Connection con;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    PreparedStatement pstmt1 = null;
    
    
    public static void main(String[] arg){
        
        
        Scanner  input = new Scanner(System.in);
        
        UpdatePersonAB DpAB = new UpdatePersonAB();
        
        System.out.println("Enter your Difficulty_ID: ");
        String getdid = input.nextLine();
        
        System.out.println("Enter your Context: ");
        String getContext = input.nextLine();
        
        DpAB.getContext_ID(getdid, getContext);
        
        System.out.println("Enter your Sub Context :");
        String getSubContextID = input.nextLine();
        System.out.println("get value con : " +String.valueOf(DpAB.getValueContext().get(0)));
        
        String stealvalue = String.valueOf(DpAB.getValueContext().get(0));
        System.out.println("Steal 1 "+stealvalue);
        
        DpAB.getSubContext_ID(String.valueOf(DpAB.getValueContext().get(0)), getSubContextID);
        
        System.out.println("get value sub : " +String.valueOf(DpAB.getValueSubContext().get(0)));
        
        String stealvalue2 = String.valueOf(DpAB.getValueSubContext().get(0));
        System.out.println("Steal 2 "+  stealvalue2);
        
        while(true){
            System.out.println("");
            System.out.println("-----------------------A_B-------------------------");
            System.out.println(" Colour A : <b style=\"color:#00539CFF;\" >");
            System.out.println("Enter person A : ");
            String textA = input.nextLine();
            System.out.println("");
            DpAB.inputTextA(String.valueOf(DpAB.Subcontext_id.get(0)), textA);
            System.out.println(" Colour B : <b style=\"color:#AE0E36FF;\">");
            System.out.println("Enter person B : ");
            String textB = input.nextLine();
            
            DpAB.inputTextB(String.valueOf(DpAB.Subcontext_id.get(0)), textB);
            
            
        }
        
        
    }
    
    public boolean getContext_ID(String difficulty_ID, String context){
        String get_ID = """
                           SELECT Context_ID
                             FROM CONTEXT
                             WHERE CONTEXT =? AND difficulty_ID = ?;""";
        con = connectDB.getConnection();
        
        
        
        try
        {
            pstmt = con.prepareStatement(get_ID);
            
            pstmt.setString(1, context);
            pstmt.setString(2, difficulty_ID);
            
            ResultSet rs = pstmt.executeQuery();
            
            int n = 0;
            
            while(rs.next()){
                int numColumns = rs.getMetaData().getColumnCount();
                n++;

                for (int i = 1; i <= numColumns; i++) {
                    System.out.print(" Context_ID : "+rs.getObject(i));
                    this.context_id.add(rs.getObject(i));
                }
            }
            System.out.println("");
            
            rs.close();
            
        }
        catch (SQLException ex) {
            System.out.println("erorr");
            
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
    
    ArrayList getValueContext(){
        return context_id;
    }
    
    public boolean getSubContext_ID(String context_id, String SubContext){
        String get_ID = """
                            SELECT SUB_CONTEXT_ID
                             FROM SUB_CONTEXT 
                           where context_ID = ? and sub_context = ?;""";
        con = connectDB.getConnection();
        
        try
        {
            pstmt = con.prepareStatement(get_ID);
            
            pstmt.setString(1, context_id);
            pstmt.setString(2, SubContext);
            
            ResultSet rs = pstmt.executeQuery();
            
            int n = 0;
            
            while(rs.next()){
                int numColumns = rs.getMetaData().getColumnCount();
                n++;

                for (int i = 1; i <= numColumns; i++) {
                    System.out.print("Sub Context_ID : "+rs.getObject(i));
                    this.Subcontext_id.add(rs.getObject(i));
                }
            }
            System.out.println("");
            
            rs.close();
            
        }
        catch (SQLException ex) {
            System.out.println("erorr");
            
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
    
    ArrayList getValueSubContext(){
        return Subcontext_id;
    }
    
    public void inputTextA(String SubContext_id, String textA){
        String input = """
                      INSERT INTO PERSON_A (
                                            TEXT,
                                            SUB_CONTEXT_ID
                                            )
                                            VALUES (
                                            ?,
                                            ?
                                            );""";
        
        con = connectDB.getConnection();
        
        try{
            con.setAutoCommit(false);
            pstmt = con.prepareStatement(input);
            pstmt.setString(1, textA);
            pstmt.setString(2, SubContext_id);

            pstmt.executeUpdate();

            pstmt.close();

            con.commit();
        }   
        catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (SQLException ex) {
                    System.err.println("SQLException: " + ex.getMessage());
                    System.out.println("error");
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
        
    }
    
    public void inputTextB(String SubContext_id, String textB){
        String input= """
                      INSERT INTO PERSON_B (
                                               TEXT,
                                               SUB_CONTEXT_ID
                                           )
                                           VALUES (
                                               ?,
                                               ?
                                           );""";
        
        con = connectDB.getConnection();
        
        try{
            con.setAutoCommit(false);
            pstmt = con.prepareStatement(input);
            pstmt.setString(1, textB);
            pstmt.setString(2, SubContext_id);

            pstmt.executeUpdate();

            pstmt.close();

            con.commit();
        }   
        catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            System.out.println("error");
        } finally {
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
        
    }
    
}
