package StartedPage;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.*;        
import java.sql.Statement;
import javadb.ConnectingDB;
import javax.swing.JFrame;


public class ProfilePage extends javax.swing.JFrame {
    PreparedStatement pstmt = null;
    PreparedStatement pstmt1 = null;
    
    
    Connection con = null;
    int Cuser_ID = 0; //should be input retrieved when account is logged into
    int languages_ID = 41470; // also needs to be retrieved elsewhere
    int Userinput;                                                  //User input from submit button
       

    public ProfilePage(int id) { // Profile page method which is used to run all other methods essentially creating the popup and changing the information
        
        Cuser_ID = id;
        
        
        initComponents();
        jLabel13.setText(retrieveUsername());
        jLabel6.setText(retrieveForename());
        jLabel7.setText(retrieveSurname()); //sets text with the information given by the return of the run methods
        jLabel8.setText(retrieveEmail());
        
        jLabel19.setText(retrieveA1());
        jLabel20.setText(retrieveA2());
        jLabel21.setText(retrieveB1());
        jLabel22.setText(retrieveB2());
       
        
        jButton1.addActionListener((ActionEvent e) -> {// Change ActionListener to ActionEvent e ( make function working properly )
            openning  openning= new openning();
            this.dispose();
        } //home button
        );         
            
        jButton2.addActionListener((ActionEvent e) -> {// Change ActionListener to ActionEvent e ( make function working properly )
            level_language  ll2= new level_language(Cuser_ID);
            this.dispose();
        } // level button
        );
         
            
        jButton3.addActionListener((ActionEvent e) -> { // Change ActionListener to ActionEvent e ( make function working properly )
            userActivity userAct = new userActivity();
            userAct.userLogouttime(Cuser_ID);
            SignIn si = new SignIn();
             this.dispose();
        } // Logout button
        );
        
              
        jButton4.addActionListener((ActionEvent e) -> { // Change ActionListener to ActionEvent e ( make function working properly )
            level_language  ll2= new level_language(Cuser_ID);
             this.dispose();
        } // back button
        );
        jButton5.addActionListener((ActionEvent e) -> { // Change ActionListener to ActionEvent e ( make function working properly )
             System.out.println("PLACEHOLDER");
            
            String temp =  jTextField1.getText();
            Userinput = Integer.valueOf(temp);
            System.out.println(temp);
           SetTeacherCode();
           System.out.println(TeacherCodeTest());
        } //submit button which adds the textfield integers to the program database
        );
        
        
        
    }
    
    
    public String retrieveUsername(){
    con = ConnectingDB.connect();
    PreparedStatement ps = null;                                                //preparedstatement object created and initilised 
    ResultSet rs = null ;                                                       //ResultSet object created and initilised

           
            try {
        String readWord = "SELECT username from USERS where user_ID = ?";       //Query to be ran in a string
                ps = con.prepareStatement(readWord);                            //preparedstatement database is opened and object is turned into the query string

                ps.setInt(1, Cuser_ID);                                      //ps statement first ? is set as Cuser_ID
        rs = ps.executeQuery();                                                 //rs is set to rexcuse the query
        String username = rs.getString(1);                                      //username is set as the result of the query
        System.out.println(username); 
         rs = ps.executeQuery();                                                  
         con.close();                                                           //database connection is closed
         return username;                                                       //username returned

        } catch(SQLException e) {
        System.out.println(e.toString());
        }
            return null;
} 
   
    public String retrieveForename(){
    con = ConnectingDB.connect();
    PreparedStatement ps = null;
    ResultSet rs = null ;

           
            try {
        String readWord = "SELECT firstname from USERS where user_ID = ?";
                ps = con.prepareStatement(readWord);

                ps.setInt(1, Cuser_ID);
        rs = ps.executeQuery();
        String Forename = rs.getString(1);
        System.out.println(Forename);
         rs = ps.executeQuery();
         
         con.close();
         return Forename;

        } catch(SQLException e) {
        System.out.println(e.toString());
        }
            return null;
} 
    
    public String retrieveSurname(){
    con = ConnectingDB.connect();
    PreparedStatement ps = null;
    ResultSet rs = null ;

           
            try {
        String readWord = "SELECT lastname from USERS where user_ID = ?";
                ps = con.prepareStatement(readWord);

                ps.setInt(1, Cuser_ID);
        rs = ps.executeQuery();
        String Surname = rs.getString(1);
        System.out.println(Surname);
         rs = ps.executeQuery();
         
         con.close();
         return Surname;

        } catch(SQLException e) {
        System.out.println(e.toString());
        }
            return null;
} 
    
    public String retrieveEmail(){
    con = ConnectingDB.connect();
    PreparedStatement ps = null;
    ResultSet rs = null ;

           
            try {
        String readWord = "SELECT emailAddress from USERS where user_ID = ?";
                ps = con.prepareStatement(readWord);

                ps.setInt(1, Cuser_ID);
        rs = ps.executeQuery();
        String emailAddress = rs.getString(1);
        System.out.println(emailAddress);
         rs = ps.executeQuery();
         
         con.close();
         return emailAddress;

        } catch(SQLException e) {
        System.out.println(e.toString());
        }
            return null;
} 
    
    public void SetTeacherCode(){
        con = ConnectingDB.connect();
   
           
            try {
        String readWord = "UPDATE USERS SET teachersCode = ? WHERE user_ID = ? ";
               PreparedStatement ps = con.prepareStatement(readWord);
               ps.setInt   (1, Userinput);
               ps.setInt(2, Cuser_ID);
               
              ps.executeUpdate();
        con.close();
      
        } catch(SQLException e) {
         System.out.println(e.toString());
        }
         
        
       
} 
     
    public String TeacherCodeTest(){
    con = ConnectingDB.connect();
    PreparedStatement ps = null;
    ResultSet rs = null ;

           
            try {
        String readWord = "SELECT teachersCode from USERS where user_ID = ?";
                ps = con.prepareStatement(readWord);

                ps.setInt(1, Cuser_ID);
        rs = ps.executeQuery();
        String teacher = rs.getString(1);
      //  System.out.println(teacher);
         rs = ps.executeQuery();
  
         con.close();
         return teacher;

        } catch(SQLException e) {
        System.out.println(e.toString());
        }
            return null;
} 
    
    public String retrieveA1(){
    con = ConnectingDB.connect();
    PreparedStatement ps = null;
    ResultSet rs = null ;

           
            try {
        String readWord = "SELECT level_A1 from LEVELS where languages_ID = ?";
                ps = con.prepareStatement(readWord);

                ps.setInt(1, languages_ID);
        rs = ps.executeQuery();
        String level_A1 = rs.getString(1);
        System.out.println(level_A1);
         rs = ps.executeQuery();
       
         con.close();
         return level_A1;

        } catch(SQLException e) {
        System.out.println(e.toString());
        }
            return null;
} 
    
     public String retrieveA2(){
    con = ConnectingDB.connect();
    PreparedStatement ps = null;
    ResultSet rs = null ;

           
            try {
        String readWord = "SELECT level_A2 from LEVELS where languages_ID = ?";
                ps = con.prepareStatement(readWord);

                ps.setInt(1, languages_ID);
        rs = ps.executeQuery();
        String level_A2 = rs.getString(1);
        System.out.println(level_A2);
         rs = ps.executeQuery();
      
         con.close();
         return level_A2;

        } catch(SQLException e) {
        System.out.println(e.toString());
        }
            return null;
} 
     
     public String retrieveB1(){
    con = ConnectingDB.connect();
    PreparedStatement ps = null;
    ResultSet rs = null ;

           
            try {
        String readWord = "SELECT level_A2 from LEVELS where languages_ID = ?";
                ps = con.prepareStatement(readWord);

                ps.setInt(1, languages_ID);
        rs = ps.executeQuery();
        String level_B1 = rs.getString(1);
        System.out.println(level_B1);
         rs = ps.executeQuery();
     
         con.close();
         return level_B1;

        } catch(SQLException e) {
        System.out.println(e.toString());
        }
            return null;
} 
     
     public String retrieveB2(){
    con = ConnectingDB.connect();
    PreparedStatement ps = null;
    ResultSet rs = null ;

           
            try {
        String readWord = "SELECT level_A2 from LEVELS where languages_ID = ?";
                ps = con.prepareStatement(readWord);

                ps.setInt(1, languages_ID);
        rs = ps.executeQuery();
        String level_B2 = rs.getString(1);
        System.out.println(level_B2);
         rs = ps.executeQuery();
       
         con.close();
         return level_B2;

        } catch(SQLException e) {
        System.out.println(e.toString());
        }
            return null;
} 
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel17 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator6 = new javax.swing.JSeparator();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        jLabel17.setText("jLabel17");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(51, 255, 51));
        setForeground(new java.awt.Color(255, 153, 153));

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));
        jPanel1.setForeground(new java.awt.Color(0, 255, 0));

        jButton1.setText("Home");

        jButton2.setText("Level");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Logout");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel11.setText("Profile picture");

        jButton4.setText("Back");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel12.setText("Username:");

        jLabel14.setText("Home icon");

        jLabel1.setText("Forename:");

        jLabel2.setText("Surname:");

        jLabel3.setText("Email:");

        jLabel5.setText("Teacher code:");

        jLabel15.setText("Level Icon");

        jLabel16.setText("Logout Icon");

        jButton5.setText("submit");

        jLabel4.setText("A1");

        jLabel9.setText("A2");

        jLabel10.setText("B1");

        jLabel18.setText("B2");

        jLabel19.setText("/25");

        jLabel20.setText("/25");

        jLabel21.setText("/25");

        jLabel22.setText("/25");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(80, 80, 80)
                .addComponent(jLabel16)
                .addGap(38, 38, 38))
            .addComponent(jSeparator3)
            .addComponent(jSeparator6)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel8))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel7))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6))
                                    .addComponent(jLabel11)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel12)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel13))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addGap(30, 30, 30)
                                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel4)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel9)
                                                        .addGap(71, 71, 71))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel19)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(jLabel20)
                                                        .addGap(70, 70, 70)))))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jButton5)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(9, 9, 9)
                                                .addComponent(jLabel10))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(5, 5, 5)
                                                .addComponent(jLabel21)))
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(19, 19, 19)
                                                .addComponent(jLabel22)
                                                .addGap(26, 26, 26))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel18)
                                                .addGap(28, 28, 28))))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel13))
                .addGap(25, 25, 25)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10)
                    .addComponent(jLabel18))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21)
                    .addComponent(jLabel22))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator6, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 253, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void main(String args[]) {
     
        
    
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new ProfilePage(75835).setVisible(true);
                
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
