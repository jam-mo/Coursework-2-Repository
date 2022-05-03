/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javadb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Random;

/**
 *
 * @author Jamie
 */
public class Javadb {
    // https://hacksmile.com/category/java-database/ - big help
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //ConnectingDB.connect();
       // insertStaff("BeBoop", "Jeff", "Faffle", "emaddil@email.com", "boo", "boo", "tangerine", "math", "610AB");
        //insertStaff("JBeBoop", "JeffEY", "wafle", "eremaddil@email.com", "bozo", "bozo", "tanqgerine", "msath", "6aa10AB");
    }

    public static void insertStaff(String UserName, String firstName, String lastName, String email, String password, String encryptedPassword, String securityQuestion, String Department, String teacherCode) {
        Connection con = ConnectingDB.connect();
        PreparedStatement ps = null; 
        int staff_ID = generateId();
        
        // also, call other method
        
        // first, check table row, and if num doesnt exist, add in staff ID 
        
        // SET _ID IN HERE OR SOMETHING, DONT HAVE IT IN THE PPARAMETER
        try {
            String staffSql = "INSERT INTO STAFF(staff_ID, staffUsername, staffFirstName, staffLastName, staffEmailAddress, staffPassword, staffEncryptedPassword, staffSecurityQuestion,"
                    + "staffDepartment, teacherCode) VALUES(?,?,?,?,?,?,?,?,?,?)";
            ps = con.prepareStatement(staffSql);
            // do a random check - ex have a method thaint staff_ID = generateId();t checks if number is in db
            ps.setInt(1, staff_ID);
            ps.setString(2, UserName);
            ps.setString(3, firstName);
            ps.setString(4, lastName);
            ps.setString(5, email);
            ps.setString(6, password);
            ps.setString(7, encryptedPassword);
            ps.setString(8, securityQuestion);
            ps.setString(9, Department);
            ps.setString(10, teacherCode);
            ps.execute();
            System.out.println("Data has been added");
            insertStaffUser(UserName, firstName, lastName, email, password, encryptedPassword, securityQuestion, staff_ID);
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        // call 
        // check nums in 
    }

    public static void insertUser(String userName, String firstName, String lastName, String emailAddress, String Password, String encryptedPassword, String securityQuestion, int userProgress) {
        Connection con = ConnectingDB.connect();
        PreparedStatement psUser = null;
        int languages = generateId();
        insertLanguages(languages);
        int user_ID = generateId();
        // SET _ID IN HERE OR SOMETHING, DONT HAVE IT IN THE PPARAMETER
        try {
            String userSql = "INSERT INTO USERS(user_ID, username, firstName, lastName, emailAddress, Password, encryptedPassword, securityQuestion,"
                    + "userProgress) VALUES(?,?,?,?,?,?,?,?,?)";
            psUser = con.prepareStatement(userSql);
            // do a random check - ex have a method that checks if number is in db
            psUser.setInt(1, user_ID);
            psUser.setString(2, userName);
            psUser.setString(3, firstName);
            psUser.setString(4, lastName);
            psUser.setString(5, emailAddress);
            psUser.setString(6, Password);
            psUser.setString(7, encryptedPassword);
            psUser.setString(8, securityQuestion);
            psUser.setInt(9, userProgress);
            psUser.execute();
            System.out.println("Data has been added to User Table");
        } catch (SQLException e) {
            System.out.println(e.toString());
        }

    }

    public static void insertStaffUser(String userName, String firstName, String lastName, String emailAddress, String Password, String encryptedPassword, String securityQuestion, int staff_ID) {
        Connection con = ConnectingDB.connect();
        PreparedStatement psStaff = null;
        ; // should I have a seperate userID for staff, or the userID and staffID be the same
        // SET _ID IN HERE OR SOMETHING, DONT HAVE IT IN THE PPARAMETER
        try {
            String staffSql = "INSERT INTO USERS(user_ID, username, firstName, lastName, emailAddress, Password, encryptedPassword, securityQuestion,"
                    + "staff_ID) VALUES(?,?,?,?,?,?,?,?,?)";
            psStaff = con.prepareStatement(staffSql);
            // do a random check - ex have a method that checks if number is in db
            psStaff.setInt(1, staff_ID);
            psStaff.setString(2, userName);
            psStaff.setString(3, firstName);
            psStaff.setString(4, lastName);
            psStaff.setString(5, emailAddress);
            psStaff.setString(6, Password);
            psStaff.setString(7, encryptedPassword);
            psStaff.setString(8, securityQuestion);
            psStaff.setInt(9, staff_ID);
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
      
      private static void readSpecificData() {
          
      }
      
      public static void readCSVFile() {
          
      }
      public static Integer generateId() { // https://tutorial.eyehunts.com/java/random-number-generator-java-range-5-digit/ source
          Random rand = new Random();
          int number = rand.nextInt(100000);
          String formatNum =  String.format("%05d",number);
          int returnNum = Integer.parseInt(formatNum);
          return returnNum;
      }

    // function to generate random id, with 5 00000's
    // functions to update, and to retrieve from database
      
      //fetch
      
      // func to generate random id
}
