
package jdbacApi;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class createTable {
    public static void main(String[] args) {
    
        Connection con = connectDB.getConnection();
        Statement stmt = null;
        String createStaff;
        createStaff = 
                "CREATE TABLE if not exists STAFF (\n"
                + "staff_ID INTEGER ,\n"
                + "staffFirstName VARCHAR(50) NOT NULL,\n"
                + "staffLastName VARCHAR(50) NOT NULL,\n"
                + "staffEmailAddress VARCHAR(50) UNIQUE NOT NULL,\n"
                + "staffPassword VARCHAR(50) NOT NULL,\n"
                + "staffDepartment VARCHAR(50) NOT NULL,\n"
                + "manager_ID INTEGER,\n"
                + "teacherCode INTEGER,\n"
                + "CONSTRAINT s_sID_pk PRIMARY KEY(staff_ID),\n"
                + "CONSTRAINT s_mID_fk FOREIGN KEY(manager_ID) REFERENCES STAFF(staff_ID)\n"
                + ") ;";
        
        String createUser;
        createUser = 
                "CREATE TABLE if not exists USER (\n"
                + "user_ID INTEGER ,\n"
                + "username VARCHAR(50) UNIQUE NOT NULL,\n"
                + "firstName VARCHAR(50) NOT NULL,\n"
                + "lastName VARCHAR(50) UNIQUE NOT NULL,\n"
                + "emailAddress VARCHAR(50) UNIQUE NOT NULL,\n"
                + "PASSWORD VARCHAR(50) UNIQUE NOT NULL,\n"
                + "staff_ID INTEGER,\n"
                + "CONSTRAINT u_uID_pk PRIMARY KEY(user_ID),\n"
                + "CONSTRAINT u_sID_fk FOREIGN KEY(staff_ID) REFERENCES STAFF(staff_ID)\n"
                + ") ;";
        
        String createLanguage;
        createLanguage = 
                " CREATE TABLE if not exists LANGUAGES (\n"
                + "languages_ID INTEGER ,\n"
                + "spanish VARCHAR(50) NOT NULL,\n"
                + "user_ID INTEGER,\n"
                + "CONSTRAINT u_uID_pk PRIMARY KEY(user_ID),\n"
                + "CONSTRAINT lang_uID_fk FOREIGN KEY(user_ID) REFERENCES USERS(user_ID)\n"
                + ") ;";
        
        String createLevel;
        createLevel = 
                """
                CREATE TABLE if not exists LEVELS (
                 difficulty_ID INTEGER,
                 Level VARCHAR(50) NOT NULL,
                 languages_ID INTEGER,
                 CONSTRAINT lev_dID_pk PRIMARY KEY(difficulty_ID),
                 CONSTRAINT lev_lID_fk FOREIGN KEY(languages_ID) REFERENCES LANGUAGES(languages_ID)
                ) ;""";
        
        String createContext;
        createContext = 
                """
                CREATE TABLE if not exists Context (
                 context_ID INTEGER,
                 context_description VARCHAR(50) NOT NULL,
                 difficulty_ID INTEGER,
                 CONSTRAINT lev_dID_pk PRIMARY KEY(context_ID),
                 CONSTRAINT lev_dID_fk FOREIGN KEY(difficulty_ID) REFERENCES LEVELS(difficulty_ID)
                ) ;""";
        
        String createSubcontext;
        createSubcontext =
                """
                CREATE TABLE if not exists SubContext (
                 Subcontext_ID INTEGER,
                 Subcontext_description VARCHAR(50) NOT NULL,
                 context_ID INTEGER,
                 CONSTRAINT lev_dID_pk PRIMARY KEY(Subcontext_ID),
                 CONSTRAINT lev_dID_fk FOREIGN KEY(context_ID) REFERENCES Context(context_ID)
                ) ;""";
        
        
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(createStaff);
            stmt.executeUpdate(createUser);
            stmt.executeUpdate(createLanguage);
            stmt.executeUpdate(createLevel);
            stmt.executeUpdate(createContext);
            stmt.executeUpdate(createSubcontext);
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
