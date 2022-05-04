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
 * @author kokmeng
 */
public class ReadProfile {
    
    Connection con;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    PreparedStatement pstmt1 = null;
    String getuser = null;
    String getemail = null;
    String getFirstName = null;
    
    String getLastName = null;
    

        public boolean ReadProfile(String email){
                   String readword = """
                                SELECT username
                                    FROM USERS
                                    WHERE emailAddress = ?;
                                     """;
                   con = ConnectingDB.connect();
                   int n = 0;

                    try {

                        pstmt = con.prepareStatement(readword);

                        pstmt.setString(1, email);

                        ResultSet rs = pstmt.executeQuery();
                        while(rs.next()){
                            int numColumns = rs.getMetaData().getColumnCount();
                            n++;

                            for (int i = 1; i <= numColumns; i++) {
                                System.out.print(" something : "+rs.getObject(i));
                                this.getuser = (String) rs.getObject(i);

                            }
                            System.out.println("");
                        }
                        System.out.println("");
                        rs.close();

                         } catch (SQLException ex) {
                         System.out.println("Error i die"); 
                         };
                         return false;



        }
        
        String getuser(){
            return getuser;
        }
        public boolean ReadFirstName(String email){
                   String readword = """
                                SELECT firstName
                                    FROM USERS
                                    WHERE emailAddress = ?;
                                     """;
                   con = ConnectingDB.connect();
                   int n = 0;

                    try {

                        pstmt = con.prepareStatement(readword);

                        pstmt.setString(1, email);

                        ResultSet rs = pstmt.executeQuery();
                        while(rs.next()){
                            int numColumns = rs.getMetaData().getColumnCount();
                            n++;

                            for (int i = 1; i <= numColumns; i++) {
                                System.out.print(" something : "+rs.getObject(i));
                                this.getFirstName = (String) rs.getObject(i);

                            }
                            System.out.println("");
                        }
                        System.out.println("");
                        rs.close();

                         } catch (SQLException ex) {
                         System.out.println("Error i die"); 
                         };
                         return false;



        }
        
        String getFirstName(){
            return getFirstName;
        }
        
        public boolean ReadLastName(String email){
                   String readword = """
                                SELECT lastName
                                    FROM USERS
                                    WHERE emailAddress = ?;
                                     """;
                   con = ConnectingDB.connect();
                   int n = 0;

                    try {

                        pstmt = con.prepareStatement(readword);

                        pstmt.setString(1, email);

                        ResultSet rs = pstmt.executeQuery();
                        while(rs.next()){
                            int numColumns = rs.getMetaData().getColumnCount();
                            n++;

                            for (int i = 1; i <= numColumns; i++) {
                                System.out.print(" something : "+rs.getObject(i));
                                this.getLastName = (String) rs.getObject(i);

                            }
                            System.out.println("");
                        }
                        System.out.println("");
                        rs.close();

                         } catch (SQLException ex) {
                         System.out.println("Error i die"); 
                         };
                         return false;



        }
   
        
        String getLastName(){
            return getLastName;
        }
        
        public boolean ReadEmail(String email){
                   String readword = """
                                SELECT emailAddress
                                    FROM USERS
                                    WHERE emailAddress = ?;
                                     """;
                   con = ConnectingDB.connect();
                   int n = 0;

                    try {

                        pstmt = con.prepareStatement(readword);

                        pstmt.setString(1, email);

                        ResultSet rs = pstmt.executeQuery();
                        while(rs.next()){
                            int numColumns = rs.getMetaData().getColumnCount();
                            n++;

                            for (int i = 1; i <= numColumns; i++) {
                                System.out.print(" something : "+rs.getObject(i));
                                this.getemail = (String) rs.getObject(i);

                            }
                            System.out.println("");
                        }
                        System.out.println("");
                        rs.close();

                         } catch (SQLException ex) {
                         System.out.println("Error i die"); 
                         };
                         return false;



        }
   
        
        String getemail(){
            return getemail;
        }

}

