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
import javadb.*;
import static javadb.Javadb.generateId;

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
        // checks if email doesnt exist,
        boolean getvalue = false;
        String get_Email = "SELECT emailAddress FROM USERS WHERE emailAddress = ? ;";
        con = ConnectingDB.connect();
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
    protected boolean ReadUserName(String user_name){
        // checks if email doesnt exist,
        boolean unValue = false;
        String get_userName = "SELECT username FROM USERS WHERE username = ? ;"; // figure out what this is
        con = ConnectingDB.connect();
        try
        {
            pstmt = con.prepareStatement(get_userName);
            
            pstmt.setString(1, user_name);
            
            ResultSet results_uName = pstmt.executeQuery();
            int n =0;
            
                if(results_uName.next()){
                        unValue = true;
                }else{
                        unValue = false;
                }
            
            results_uName.close();
            
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
        return unValue;
    }
// USERNAME NEEDS ADDING, NEEDS READUSERNAME ALSO
  

    
    protected boolean ReadSignIn(String userType,  String userEmail, String userPassword) throws SQLException{
        
        // should also pass in userType here, 
        // USERNAME NEEDS ADDING
        String TypeOfUser = userType;
        String changeEmail = null;
        String encryptedpassword = null;
        String encryted = null;
        
        String providedPassword = userPassword;
        
        
        boolean re_Value = false;
        
        if(TypeOfUser.equalsIgnoreCase("staff")){
            // checks if student says user or staff
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
            con = ConnectingDB.connect();
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
        con = ConnectingDB.connect();
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
        con = ConnectingDB.connect();
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
        con = ConnectingDB.connect(); 
        
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
    
    public static void insertStaff(String UserName, String firstName, String lastName, String email, String password, String securityQuestion) {
        Connection con = ConnectingDB.connect();
        PreparedStatement ps = null; 
        int staff_ID = generateId();
        
        // also, call other method
        
        // first, check table row, and if num doesnt exist, add in staff ID 
        
        // SET _ID IN HERE OR SOMETHING, DONT HAVE IT IN THE PPARAMETER
        try {
            String staffSql = "INSERT INTO STAFF(staff_ID, staffUsername, staffFirstName, staffLastName, staffEmailAddress, staffPassword,staffSecurityQuestion) VALUES(?,?,?,?,?,?,?)";
            ps = con.prepareStatement(staffSql);
            // do a random check - ex have a method thaint staff_ID = generateId();t checks if number is in db
            ps.setInt(1, staff_ID);
            ps.setString(2, UserName);
            ps.setString(3, firstName);
            ps.setString(4, lastName);
            ps.setString(5, email);
            ps.setString(6, password);
            ps.setString(7, securityQuestion);
            ps.execute();
            System.out.println("Data has been added");
            //insertStaffUser(UserName, firstName, lastName, email, password,securityQuestion, staff_ID);
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        // call 
        // check nums in 
    }

    public static void insertUser(String userName, String firstName, String lastName, String emailAddress, String Password,String securityQuestion) {
        Connection con = ConnectingDB.connect();
        PreparedStatement psUser = null;
        //int languages = generateId();
        //insertLanguages(languages);
        int user_ID = generateId();
        // SET _ID IN HERE OR SOMETHING, DONT HAVE IT IN THE PPARAMETER
        try {
            String userSql = "INSERT INTO USERS(user_ID, username, firstName, lastName, emailAddress, Password,securityQuestion) VALUES(?,?,?,?,?,?,?)";
            psUser = con.prepareStatement(userSql);
            // do a random check - ex have a method that checks if number is in db
            psUser.setInt(1, user_ID);
            psUser.setString(2, userName);
            psUser.setString(3, firstName);
            psUser.setString(4, lastName);
            psUser.setString(5, emailAddress);
            psUser.setString(6, Password);      
            psUser.setString(7, securityQuestion);
            psUser.execute();
            System.out.println("Data has been added to User Table");
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

    }

    public static void insertStaffUser(String userName, String firstName, String lastName, String emailAddress, String Password,String securityQuestion, int staff_ID) {
        Connection con = ConnectingDB.connect();
        PreparedStatement psStaff = null;
        ; // should I have a seperate userID for staff, or the userID and staffID be the same
        // SET _ID IN HERE OR SOMETHING, DONT HAVE IT IN THE PPARAMETER
        try {
            String staffSql = "INSERT INTO USERS(user_ID, username, firstName, lastName, emailAddress, Password,securityQuestion, staff_ID) VALUES(?,?,?,?,?,?,?,?)";
            psStaff = con.prepareStatement(staffSql);
            // do a random check - ex have a method that checks if number is in db
            psStaff.setInt(1, staff_ID);
            psStaff.setString(2, userName);
            psStaff.setString(3, firstName);
            psStaff.setString(4, lastName);
            psStaff.setString(5, emailAddress);
            psStaff.setString(6, Password);
            psStaff.setString(7, securityQuestion);
            psStaff.setInt(8, staff_ID);
            psStaff.execute();
            System.out.println("Data has been added to users");
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        // check nums in 
    }

    public static void insertLevels(int languages_ID) {
        // what am i going to do for this one? // get lanugages_ID 
        Connection con = ConnectingDB.connect();
        PreparedStatement psLevel = null;
        int difficulty_ID = generateId();
        String levelA1 = "/22";  // these will update in each individuals id - ex the language_id matching the user_id will update these when the user finished one of these.
        String levelA2 = "/25";
        String levelB1 = "/11";
        String levelB2 = "/4";
        // SET _ID IN HERE OR SOMETHING, DONT HAVE IT IN THE PPARAMETER
        try {
            String levelSql = "INSERT INTO LEVELS(difficulty_ID, level_A1, level_A2, level_B1, level_B2, languages_ID) VALUES(?,?,?,?,?,?)";
            psLevel = con.prepareStatement(levelSql);
            // do a random check - ex have a method that checks if number is in db
            psLevel.setInt(1, difficulty_ID);
            psLevel.setString(2, levelA1);
            psLevel.setString(3, levelA2);
            psLevel.setString(4, levelB1);
            psLevel.setString(5, levelB2);
            psLevel.setInt(6, languages_ID);
            //psLevel.setString(6, languages_ID);    
            //insertContext(difficulty_ID);
            psLevel.execute();
            System.out.println("Data has been added to Level table");
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    }

        public static void insertLanguages(int languages_ID) {

	// fetch userID, or when creating user, call this function, and pass a parameted for languages_id
         Connection con = ConnectingDB.connect();
         PreparedStatement psLanguage = null;
         //int languages_ID = generateId();
         String spanish = "Yes";
         insertLevels(languages_ID);
         // SET _ID IN HERE OR SOMETHING, DONT HAVE IT IN THE PPARAMETER
         try{
             String languageSql = "INSERT INTO LANGUAGES(languages_ID, spanish) VALUES(?,?)";
             psLanguage = con.prepareStatement(languageSql);
             // do a random check - ex have a method that checks if number is in db
             psLanguage.setInt(1,languages_ID);
             psLanguage.setString(2, spanish);
             
             psLanguage.execute();
             insertLevels(languages_ID);
             System.out.println("Data has been added");
         } catch(SQLException e) {
             System.out.println(e.toString());
         }
    }

    public static void insertContext(int context_ID, String contextTitle, String contextLevel, String subContext, String conversationPrompt,String spanishWords) {
         Connection con = ConnectingDB.connect();
         PreparedStatement psContext = null;
         // SET _ID IN HERE OR SOMETHING, DONT HAVE IT IN THE PPARAMETER - fetch id too - difficulty
         /*
         int context_ID, 
         String contextTitle, 
         String contextLevel,
         String subContext, 
         String conversationPrompt,
         String spanishWords
         
         */
         // read csv file into here, 
         try{
             String contextSql = "INSERT INTO CONTEXT(CONTEXT_ID, CONTEXT_TITLE, CONTEXT_LEVEL, SUB_CONTEXT, CONVERSATION_PROMPT, SPANISH_WORDS) VALUES(?,?,?,?,?,?)";
             psContext = con.prepareStatement(contextSql);
             // do a random check - ex have a method that checks if number is in db
             psContext.setInt(1, context_ID);
             psContext.setString(2, contextTitle);
             psContext.setString(3, contextLevel);
             psContext.setString(4, subContext);
             psContext.setString(5, conversationPrompt);
             psContext.setString(6, spanishWords);
             psContext.execute();
             System.out.println("Data has been added to Context table");
         } catch(SQLException e) {
             System.out.println(e.toString());
         }
    }

      public static void insertUserActivity(int userActivity_ID, String loginDate, String loginTime, String logoutTime, String activity_completed){
          Connection con = ConnectingDB.connect();
         PreparedStatement psUserActivity = null;
         // add user_ID in here, call from user_ID
         // SET _ID IN HERE OR SOMETHING, DONT HAVE IT IN THE PPARAMETER
         try{
             String userActivitySql = "INSERT INTO USERACTIVITY(userActivity_ID, loginDate, loginTime, logoutTime, activity_completed) VALUES(?,?,?,?,?)";
             psUserActivity = con.prepareStatement(userActivitySql);
             // do a random check - ex have a method that checks if number is in db
             psUserActivity.setInt(1, userActivity_ID);
             psUserActivity.setString(2, loginDate);
             psUserActivity.setString(3, loginTime);
             psUserActivity.setString(4, logoutTime);
             psUserActivity.setString(5, activity_completed);
             psUserActivity.execute();
             System.out.println("Data has been added to user activity table");
         } catch(SQLException e) {
             System.out.println(e.toString());
         }
     }
      private static void readAllDatabase() {
          Connection con = ConnectingDB.connect();
          PreparedStatement psRead = null;
          ResultSet rs = null;
          
          
          
      }
      
      public static Integer generateId() { // https://tutorial.eyehunts.com/java/random-number-generator-java-range-5-digit/ source
          Random rand = new Random();
          int number = rand.nextInt(100000);
          String formatNum =  String.format("%05d",number);
          int returnNum = Integer.parseInt(formatNum);
          return returnNum;
      }
      public static void readFromFile() {
          
      }

    
    
    public static void main(String[] arg){
        ReadDatabase rd = new ReadDatabase();
        
        
        
    }

}
