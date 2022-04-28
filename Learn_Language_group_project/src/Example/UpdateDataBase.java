/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import jdbacApi.connectDB;

public class UpdateDataBase {
    
    Connection con;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    PreparedStatement pstmt1 = null;
    
    UpdateDataBase(String difficulty_ID, String context_id,   String context, String SUB_CONTEXT_ID,String subContext  ){
        
//        String get_text = """
//                          INSERT INTO CONTEXT (
//                                                  Context_ID,
//                                                  CONTEXT,
//                                                  difficulty_ID
//                                              )
//                                              VALUES (
//                                                  ?,
//                                                  ?,
//                                                  ?
//                                              );""";
//        String get_Text01 = """
//                            INSERT INTO SUB_CONTEXT (
//                                                        SUB_CONTEXT_ID,
//                                                        SUB_CONTEXT,
//                                                        Context_ID
//                                                    )
//                                                    VALUES (
//                                                        ?,
//                                                        ?,
//                                                        ?
//                                                    );""";
//        
//        
//        con = connectDB.getConnection();
//        
//        try{
//            con.setAutoCommit(false);
//            
//            pstmt = con.prepareStatement(get_text);
//            pstmt.setString(1, context_id);
//            pstmt.setString(2, context);
//            pstmt.setString(3, difficulty_ID);
//            
//            pstmt1 = con.prepareStatement(get_Text01);
//            pstmt1.setString(1, SUB_CONTEXT_ID);
//            pstmt1.setString(2, subContext);
//            pstmt1.setString(3, context_id);
//
//            pstmt.executeUpdate();
//            pstmt1.executeUpdate();
//            
//            pstmt.close();
//            pstmt1.close();
//
//            con.commit();
//        }        
//        catch (SQLException ex) {
//            System.err.println("SQLException: " + ex.getMessage());
//        } finally {
//            if (stmt != null) {
//                try {
//                    stmt.close();
//                } catch (SQLException ex) {
//                    System.err.println("SQLException: " + ex.getMessage());
//                }
//            }
//            if (con != null) {
//                try {
//                    con.close();
//                } catch (SQLException ex) {
//                    System.err.println("SQLException: " + ex.getMessage());
//                }
//            }
//        }       
        
    }
    
    public void updatepersonTextA(String SUB_CONTEXT_ID, String TEXT ){
        String getTex = """
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
            pstmt = con.prepareStatement(getTex);
            pstmt.setString(1, TEXT);
            pstmt.setString(2, SUB_CONTEXT_ID);

            pstmt.executeUpdate();

            pstmt.close();

            con.commit();
        }        
        catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
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
    
    public void updatepersonTextB(String SUB_CONTEXT_ID, String TEXT ){
//        
//        String getTex = """
//                        INSERT INTO PERSON_B (
//                                                 TEXT,
//                                                 SUB_CONTEXT_ID
//                                             )
//                                             VALUES (
//                                                 ?,
//                                                 ?
//                                             );""";
//        con = connectDB.getConnection();
//        
//        try{
//            con.setAutoCommit(false);
//            pstmt = con.prepareStatement(getTex);
//            pstmt.setString(1, TEXT);
//            pstmt.setString(2, SUB_CONTEXT_ID);
//
//            pstmt.executeUpdate();
//
//            pstmt.close();
//
//            con.commit();
//        }        
//        catch (SQLException ex) {
//            System.err.println("SQLException: " + ex.getMessage());
//        } finally {
//            if (stmt != null) {
//                try {
//                    stmt.close();
//                } catch (SQLException ex) {
//                    System.err.println("SQLException: " + ex.getMessage());
//                }
//            }
//            if (con != null) {
//                try {
//                    con.close();
//                } catch (SQLException ex) {
//                    System.err.println("SQLException: " + ex.getMessage());
//                }
//            }
//        }      
        
    }
    
    public static void main(String[] arg)
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter difficulty_ID");
        String difficulty_ID = input.nextLine();
        
        System.out.println("Enter Context_ID");
        String Context_ID = input.nextLine();
        
        System.out.println("Enter CONTEXT");
        String CONTEXT = input.nextLine();
        
        System.out.println("Enter SUB_CONTEXT_ID");
        String SUB_CONTEXT_ID = input.nextLine();

        System.out.println("Enter SUB_CONTEXT");
        String SUB_CONTEXT = input.nextLine();
        
        UpdateDataBase udb = new UpdateDataBase(difficulty_ID, Context_ID,CONTEXT,SUB_CONTEXT_ID,SUB_CONTEXT);
        while(true){
            System.out.println("Enter Y/N if you continue with Text A ");
            String Ask = input.next();
            if(Ask.equalsIgnoreCase("y") ||Ask.equalsIgnoreCase("yes")){
                System.out.println("Enter TEXT_PERSON_A");
                Scanner inputs = new Scanner(System.in);
                String TEXT = inputs.nextLine();
                udb.updatepersonTextA(SUB_CONTEXT_ID, TEXT);
                
            }else if (Ask.equalsIgnoreCase("n")||Ask.equalsIgnoreCase("no")){
                break;
            }
        }
        
        while(true){
            System.out.println("Enter Y/N if you continue with Text B ");
            String Ask = input.next();
            if(Ask.equalsIgnoreCase("y") ||Ask.equalsIgnoreCase("yes")){
                System.out.println("Enter TEXT_PERSON_B");
                Scanner inputs1 = new Scanner(System.in);
                String TEXT = inputs1.nextLine();
                udb.updatepersonTextB(SUB_CONTEXT_ID, TEXT);
                
            }else if (Ask.equalsIgnoreCase("n")||Ask.equalsIgnoreCase("no")){
                break;
            }
            
        }
        
        System.out.println("Thank you for you time;");
        
    }
    
}
