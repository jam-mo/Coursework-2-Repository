/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Example;

import Validation_Email_Password.PasswordUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.Random;
import jdbacApi.*;

public class SingUP extends PasswordUtils{
    Connection con;
    PreparedStatement pstmt;
    PreparedStatement pstmt1;
    
    protected void InputSignUp(String firstName, String lastName, String user_email, String password , String Question1,String Question2, String Question3 )
    {
        String get_Email = "SELECT emailAddress FROM STUDENT_USER WHERE emailAddress = ? ;";
        con = connectDB.getConnection();
        
        Random random = new Random();
        
        String returnValue = null;
        
        int num = random.nextInt(1000)+1;
        
        String num1 = Integer.toString(num);
        
        String salt1 = PasswordUtils.getSalt(99);
        String mySecurePassword = PasswordUtils.generateSecurePassword(password, salt1);


        try
        {
            pstmt = con.prepareStatement(get_Email);
            
            pstmt.setString(1, user_email);
            
            ResultSet results_email = pstmt.executeQuery();
            int n =0;
            
            while(results_email.next()){
                int numColumns = results_email.getMetaData().getColumnCount();
                n++;
                
                for(int i = 1; i <= numColumns ; i++){
                    System.out.println("User_Email : " +  results_email.getObject(i));
                    returnValue = (String)results_email.getObject(i);
                }
                System.out.println("");
                
            }
            if(returnValue == null || returnValue == ""){
                
                        String get_Student_ID = "INSERT INTO `STUDENT_USER`(`user_ID`,`username`,`firstName`, `lastName`, `emailAddress`,`encryted`,`encryptedpassword`) VALUES (?,?,?,?,?,?,?);" ;
                        String get_Question = "INSERT INTO `Security_Question`(`Question_1`,`Question_2`,`Question_3`,`user_ID`) VALUES (?,?,?,?);";
                        System.out.println("eerp");
                        try
                        {
                            con.setAutoCommit(false);
                            pstmt = con.prepareStatement(get_Student_ID);
                            pstmt.setString(1, num1);
                            pstmt.setString(2, firstName+"."+lastName);
                            pstmt.setString(3, firstName);
                            pstmt.setString(4, lastName);
                            pstmt.setString(5, user_email);
                            pstmt.setString(6, salt1);
                            pstmt.setString(7, mySecurePassword);
                            
                            pstmt1 = con.prepareStatement(get_Question);
                            pstmt1.setString(1, Question1);
                            pstmt1.setString(2, Question2);
                            pstmt1.setString(3, Question3);
                            pstmt1.setString(4, num1);
                            
                            pstmt.executeUpdate();
                            pstmt1.executeUpdate();
                            
                            pstmt.close();
                            pstmt1.close();
                            
                            con.commit();
                        }
                        catch (SQLException ex)
                        {
                            System.err.println("SQLException: " + ex.getMessage());
                        } 
                        finally 
                        {
                            if (pstmt != null) 
                            {
                                try 
                                {
                                    pstmt.close();
                                }
                                catch(SQLException ex) 
                                {
                                    System.err.println("SQLException: " + ex.getMessage());
                                }
                            }
                            if (con != null) {
                                try {
                                    con.close();
                                }
                                catch(SQLException ex) 
                                {
                                    System.err.println("SQLException: " + ex.getMessage());
                                }
                            }
                        }
                
            }else{
                System.out.println("Account Already created");
            }
            
            results_email.close();
            
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
    }
    
    public static void main(String[] arg){
        
        String fname = "Sim";
        String lname = "Sam";
        String email = "KOKI1@student.com";
        String password = "KingSimSam";
        
        String Question1 = "Am Gay";
        String Question2 = "Am Gay1";
        String Question3 = "Am Gay2";
        
        SingUP signup = new SingUP();
                
        signup.InputSignUp(fname, lname, email, password, Question1, Question2, Question3);
        
        
        
    }
}
