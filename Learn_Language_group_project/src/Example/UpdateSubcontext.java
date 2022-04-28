/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import jdbacApi.connectDB;

public class UpdateSubcontext {
    
    ArrayList getText = new ArrayList();
    
    Connection con;
    Statement stmt = null;
    PreparedStatement pstmt = null;
    PreparedStatement pstmt1 = null;
    
    
    public static void main(String[] arg){
        
        Scanner input = new Scanner(System.in);
        
        UpdateSubcontext up = new UpdateSubcontext();
        
    while(true){
        System.out.println("Enter your Context :");
        String getContext = input.nextLine();
        
        System.out.println("");
        up.getContext_ID(getContext);
        
        for(int i = 0; i < up.getcontext().size(); i++){
            System.out.println(up.getText);
            String getText1 = String.valueOf(up.getText.get(i));
            System.out.println(getText1);
        }
        System.out.println("");
        
        System.out.println("Enter ID below");
        String getId = input.nextLine();
        System.out.println("");
        
        System.out.println("Enter your Sub Context ID :");
        int getSubContextID = input.nextInt();
        input.nextLine();
        System.out.println("");
        System.out.println("Enter your Sub Context :");
        String getSubContext = input.nextLine();
        System.out.println("");
        
        
        up.inputSubContext(getId,String.valueOf(getSubContextID), getSubContext);
        System.out.println("Context_Id = "+getContext );
        System.out.println("Sub_Context_Id = "+getSubContextID );
        System.out.println("Sub_Context = "+getSubContext );
    }

    }
    
    private void getContext_ID(String context){
        
        String get_Email = """
                           SELECT Context_ID
                             FROM CONTEXT
                             WHERE CONTEXT =? AND difficulty_ID = '434';""";
        con = connectDB.getConnection();
        
        
        
        try
        {
            pstmt = con.prepareStatement(get_Email);
            
            pstmt.setString(1, context);
            
            ResultSet rs = pstmt.executeQuery();
            
            int n = 0;
            
            while(rs.next()){
                int numColumns = rs.getMetaData().getColumnCount();
                n++;

                for (int i = 1; i <= numColumns; i++) {
                    System.out.print(" Context_ID : "+rs.getObject(i));
                    this.getText.add(rs.getObject(i));
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
        
    }
    
    ArrayList getcontext(){
        return getText;
    }
    
    public void inputSubContext(String context_id, String SubContext_Id, String SubContext)
    {
         String get_Text01 = """
                            INSERT INTO SUB_CONTEXT (
                                                        SUB_CONTEXT_ID,
                                                        SUB_CONTEXT,
                                                        Context_ID
                                                    )
                                                    VALUES (
                                                        ?,
                                                        ?,
                                                        ?
                                                    );""";
        
        
        con = connectDB.getConnection();
        
        try{
            
            con.setAutoCommit(false);
            pstmt1 = con.prepareStatement(get_Text01);
            pstmt1.setString(1, SubContext_Id);
            pstmt1.setString(2, SubContext);
            pstmt1.setString(3, context_id);

            pstmt1.executeUpdate();
            
            pstmt1.close();


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
    
}
