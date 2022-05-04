/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package languagelearningapp;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class createTable {

    public static void main(String[] args) {
        Connection con = languageApp.getConnection();
        Statement stmt = null;
        String createStaff;
        String createUsers;
        String createLanguages;
        String createLevels;
        createStaff = "CREATE TABLE if not exists STAFF (\n"
                + "            staff_ID     INTEGER      PRIMARY KEY,\n"
                + "            staffUserName  VARCHAR (30) UNIQUE NOT NULL,\n"
                + "            staffFirstName  VARCHAR (30) NOT NULL,\n"
                + "            staffLastName  VARCHAR (30)NOT NULL,\n"
                + "            staffEmailAddres  VARCHAR (50) UNIQUE NOT NULL,\n"
                + "            staffPassword  VARCHAR (30) NOT NULL,\n"
                + "            staffDepartment  VARCHAR (30) NOT NULL,\n"
                + "            teacherCode  INTEGER, \n"
                + "            manager_ID   INTEGER,\n"
                + "            CONSTRAINT s_sID_pk PRIMARY KEY(staff_ID),\n"
                + "            CONSTRAINT s_mID_fk FOREIGN KEY(manager_ID) REFERENCES STAFF(staff_ID),\n" + ") ;";

        createUsers = "CREATE TABLE if not exists USERS (\n"
                + "            user_ID     INTEGER      PRIMARY KEY,\n"
                + "            userName  VARCHAR (30) UNIQUE NOT NULL,\n"
                + "            firstName  VARCHAR (30) NOT NULL,\n"
                + "            lastName  VARCHAR (30) NOT NULL,\n"
                + "            emailAddres  VARCHAR (50)UNIQUE NOT NULL,\n"
                + "            password  VARCHAR (30) NOT NULL,\n"
                + "            userProgress  INTEGER,\n"
                + "            staff_ID  INTEGER, \n"
                + "            CONSTRAINT u_uID_pk PRIMARY KEY(user_ID),\n"
                + "CONSTRAINT u_sID_fk FOREIGN KEY(staff_ID) REFERENCES STAFF(staff_ID) " + ") ;";

        createLanguages = "CREATE TABLE if not exists LANGUAGES (\n"
                + "            languages_ID     INTEGER      PRIMARY KEY,\n"
                + "            spanish  VARCHAR (30) NOTNULL,\n"
                + "            user_ID INTEGER,\n"
                + "            CONSTRAINT lang_lID_pk PRIMARY KEY(languages_ID),\n"
                + " CONSTRAINT lang_uID_fk FOREIGN KEY(user_ID) REFERENCES USERS(user_ID) " + ") ;";

        createLevels = "CREATE TABLE if not exists LEVELS (\n"
                + "            difficulty_ID     VARCHAR (30)      PRIMARY KEY,\n"
                + "            level_A1 VARCHAR(50) NOT NULL,\n"
                + "            level_A2 VARCHAR(50) NOT NULL,\n"
                + "            level_B1 VARCHAR(50) NOT NULL,\n"
                + "             level_B2 VARCHAR(50) NOT NULL,\n"
                + "            languages_ID INTEGER,\n"
                + "            CONSTRAINT lev_dID_pk PRIMARY KEY(difficulty_ID),\n"
                + "CONSTRAINT lev_lID_fk FOREIGN KEY(languages_ID) REFERENCES LANGUAGES(languages_ID) " + ") ;";

        try {
            stmt = con.createStatement();
            stmt.executeUpdate(createStaff);
            con.commit();
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
    }
}
