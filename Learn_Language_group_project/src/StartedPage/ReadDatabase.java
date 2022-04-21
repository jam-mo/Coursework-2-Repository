/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StartedPage;

import Validation_Email_Password.PasswordUtils;
import java.sql.*;
import java.util.HashMap;
import java.util.Random;
import javax.swing.*;
import jdbacApi.*;

/**
 *
 * @author kokmeng
 */

public class ReadDatabase extends PasswordUtils {
    
    Connection con;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    PreparedStatement pstmt1 = null;
    String userEmail;
    
    protected boolean ReadEmail(String user_email){
        
        boolean getvalue = false;
        String get_Email = "SELECT emailAddress FROM STUDENT_USER WHERE emailAddress = ? ;";
        con = connectDB.getConnection();
        try
        {
            pstmt = con.prepareStatement(get_Email);
            
            pstmt.setString(1, user_email);
            
            ResultSet results_email = pstmt.executeQuery();
            int n =0;
            
                if(results_email.next()){
                        getvalue = true;
                }else{
                        getvalue = false;
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
        return getvalue;
    }

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
                        String get_Question = "INSERT INTO `Security_Question`(`Question_1`,`Question_2`,`Question_3`,`user_email`) VALUES (?,?,?,?);";
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
                            pstmt1.setString(4, user_email);
                            
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

    
    protected boolean ReadSignIn(String userType, String userEmail, String userPassword) throws SQLException{
        String TypeOfUser = userType;
        String changeEmail = null;
        String encryptedpassword = null;
        String encryted = null;
        
        String providedPassword = userPassword;
        
        
        boolean re_Value = false;
        
        if(TypeOfUser.equalsIgnoreCase("staff")){
            
            TypeOfUser = "STAFF";
            changeEmail = "staffemailAddress";
            encryptedpassword = "staffPassword";
            
        }else if(TypeOfUser.equalsIgnoreCase("student")){
            TypeOfUser = "STUDENT_USER";
            changeEmail = "emailAddress";
            encryptedpassword = "encryptedpassword";
        }
        System.out.println(TypeOfUser+changeEmail+encryptedpassword);
        
        try {
            con = connectDB.getConnection();
            stmt = con.createStatement();
            

            String checkemail = "SELECT `"+changeEmail+"` FROM `"+TypeOfUser+"` WHERE `"+changeEmail+"` =?";
            
            pstmt = con.prepareStatement(checkemail);
                
            pstmt.setString(1, userEmail);
            
            ResultSet results_checkemail = pstmt.executeQuery();
            
            int n = 0;
            if(!results_checkemail.next())
            {
                JOptionPane.showMessageDialog(null, "Your Email Incorrect");
            }
            else
            {
                String sql = "SELECT `encryptedpassword` FROM `"+TypeOfUser+"` WHERE `"+changeEmail+"` = ?;";
                String sql1 = "SELECT `encryted` FROM `"+TypeOfUser+"` WHERE `"+changeEmail+"` = ?;";
                
                pstmt = con.prepareStatement(sql);
                pstmt1 = con.prepareStatement(sql1);
                
                pstmt.setString(1, userEmail);
                pstmt1.setString(1, userEmail);
                
                ResultSet results = pstmt.executeQuery();
                ResultSet results1 = pstmt1.executeQuery();
                
                while(results.next() && results1.next()){
                    int numColumns = results.getMetaData().getColumnCount();
                    System.out.println("");
                    int numColumns1 = results1.getMetaData().getColumnCount();
                    
                    System.out.println("");
                    n++;
                    
                        for (int i = 1; i <= numColumns; i++) {
//                            System.out.print("secure password " + results.getObject(i));
//                            System.out.print("value " + results1.getObject(i));
                            
                            boolean passwordMatch = verifyUserPassword(userPassword, (String) results.getObject(i), (String) results1.getObject(i));
                            
                            if(passwordMatch){
                                System.out.println("Provided password is correct");
                                JOptionPane.showMessageDialog(null, "Provided password is correct");
                                
                                re_Value = true;
                                
                            }else{
                                System.out.println("Provided password is incorrect");
                                JOptionPane.showMessageDialog(null, "Please check your password, again");
                                re_Value = false;
                            }
                            
                        }      
                }
                results.close();

            }
            results_checkemail.close();
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
        return re_Value;
    }
    
    protected boolean ReadSecureQuestion(String value,String text1,String user_email){
        
        boolean getvalue = false;
        String get_Text1 = "SELECT "+value+" from Security_Question where "+value+" = ?  AND user_email = ?;";
        con = connectDB.getConnection();
        try
        {
            pstmt = con.prepareStatement(get_Text1);
            
            pstmt.setString(1, text1);
            pstmt.setString(2, user_email);
            
            ResultSet results_email = pstmt.executeQuery();
            
                if(results_email.next()){
                        getvalue = true;
                }else{
                        getvalue = false;
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
        return getvalue;
        
    }
    
    protected boolean ReadSecureEmail(String user_email){
        
        boolean getvalue = false;
        String get_Text1 = "SELECT user_email FROM Security_Question WHERE user_email = ? ;";
        con = connectDB.getConnection();
        try
        {
            pstmt = con.prepareStatement(get_Text1);
            
            pstmt.setString(1, user_email);
            
            ResultSet results_email = pstmt.executeQuery();
            
                if(results_email.next()){
                        getvalue = true;
                }else{
                        getvalue = false;
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
        return getvalue;
        
        
    }
    
    protected boolean changePwd(String user_email, String user_password){
        
        boolean takeValue = false;
        
        String salt1 = PasswordUtils.getSalt(99);
        String mySecurePassword = PasswordUtils.generateSecurePassword(user_password, salt1);
        
        String get_Text1 = "UPDATE STUDENT_USER SET encryted= ?, encryptedpassword=?  WHERE emailAddress =?;";
        con = connectDB.getConnection();
        
        try{
            con.setAutoCommit(false);
            pstmt = con.prepareStatement(get_Text1);
            pstmt.setString(1, salt1);
            pstmt.setString(2, mySecurePassword);
            pstmt.setString(3, user_email);

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
        return takeValue;
    }

    
    
    public static void main(String[] arg){
        ReadDatabase rd = new ReadDatabase();
        
        
        
    }

}
