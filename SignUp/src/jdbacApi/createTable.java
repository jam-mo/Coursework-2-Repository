
package jdbacApi;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class createTable {
    public static void main(String[] args) {
    
        Connection con = connectDB.getConnection();
        Statement stmt = null;
        String createString;
        createString = "CREATE TABLE if not exists USER (\n" 
                + " user_ID INTEGER AUTO_INCREMENT,\n" 
                + " firstName VARCHAR(50) NOT NULL,\n" 
                + " lastName VARCHAR(50) NOT NULL,\n" 
                + " emailAddress VARCHAR(50) UNIQUE NOT NULL,\n" 
                + " PASSWORD VARCHAR(50) NOT NULL,\n" 
                + " staff_ID INTEGER,\n"
                + " CONSTRAINT u_uID_pk PRIMARY KEY(user_ID),\n"
                + " CONSTRAINT u_sID_fk FOREIGN KEY(staff_ID) REFERENCES USER(user_ID)\n"
                
                + ") ;";
        
        try {
            stmt = con.createStatement();
            stmt.executeUpdate(createString);
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
