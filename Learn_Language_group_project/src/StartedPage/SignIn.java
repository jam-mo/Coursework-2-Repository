
package StartedPage;

import Validation_Email_Password.Validation_Email;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.*;
import javadb.*;

/**
 *
 * @author kokmeng
 */

public class SignIn extends ReadDatabase implements ActionListener{
    
    JFrame frame;
    
    JPanel Mainpanel;
    
    JLabel label;
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;
    
    JTextField text1;
    JPasswordField password;
    
    JButton buttonSubmit;
    
    JButton goback_button;
    
    JCheckBox checkbox;
    
    String userType;
    
    JComboBox combobox;
    
    ImageIcon icon = new ImageIcon("eye.png");
    ImageIcon icon1 = new ImageIcon("hidden.png");
    ImageIcon icon2 = new ImageIcon("back.png");
    
    Font myFont1 = new Font("Arial Rounded MT Bold",Font.BOLD,30);
    Font myFont2 = new Font("Herculanum",Font.BOLD,16);
    Font myFont3 = new Font("Rockwell",Font.PLAIN,13);
    Font myFont4 = new Font("Lucida Grande",Font.PLAIN,16);
    Font myFont5 = new Font("Lucida Grande",Font.PLAIN,14);
    
    SignIn(){
        
        goback_button = new JButton();
        goback_button.setIcon(icon2);
        goback_button.setBounds(5, 15, 35, 35);
        goback_button.setBorder(null);
        goback_button.addActionListener(this);
        
        String[] valueType = {"Select","Student","Staff"};
        
        combobox = new JComboBox(valueType);
        combobox.setBounds(300, 0, 100, 50);
        combobox.addActionListener(this);
        
        userType = (String) combobox.getSelectedItem();
        
        
        label = new JLabel();
        label.setText("SignIn");
        label.setForeground(new java.awt.Color(198,102,104));
        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        label.setBounds(0, 50, 388, 50);
        label.setFont(myFont1);
        
        label1 = new JLabel();
        label1.setText("Email:");
        label1.setForeground(new java.awt.Color(102,102,255));
        label1.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        label1.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        label1.setBounds(10, 200, 388, 50);
        label1.setFont(myFont2);
        
        label2 = new JLabel();
        label2.setText("Password:");
        label2.setForeground(new java.awt.Color(102,102,255));
        label2.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        label2.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        label2.setBounds(10, 280, 388, 50);
        label2.setFont(myFont2);
        
        label3 = new JLabel();
        label3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        label3.setBounds(-50, 650, 388, 30);
        label3.setText("If you dont have Any Account |");
        
        label4 = new JLabel();
        label4.setText("Sign Up");
        label4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        label4.setBounds(80, 650, 388, 30);
        label4.setForeground(new java.awt.Color(51, 51, 255));
        label4.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e)  
            {  
               // you can open a new frame here as
               // i have assumed you have declared "frame" as instance variable
                SignUp signUP = new SignUp();
                frame.dispose();

            }  
        });
        
        label5 = new JLabel();
        label5.setText("Reset_Password");
        label5.setFont(myFont5);
        label5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        label5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        label5.setBounds(230, 365, 150, 30);
        label5.setForeground(new java.awt.Color(255,51,51));
        label5.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e)  
            {  
               // you can open a new frame here as
               // i have assumed you have declared "frame" as instance variable
                
                if(!(userType.equalsIgnoreCase("student" )|| userType.equalsIgnoreCase("staff"))){
                    JOptionPane.showMessageDialog(null, "Please select your student or teacher" ,"SELECT",JOptionPane.INFORMATION_MESSAGE);
                }else{
                    Reset_password rspw=new Reset_password(userType);
                    frame.dispose();
                }

            }  
        });
        
        
        checkbox = new JCheckBox();
        checkbox.setIcon(icon1);
        checkbox.setForeground(new java.awt.Color(255,51,51));
        checkbox.setFocusable(false);
        checkbox.setBounds(350, 280, 50, 50);
        checkbox.addActionListener(this);
        checkbox.setFont(myFont5);
        
        text1 = new JTextField(); 
        text1.setForeground(new java.awt.Color(255,51,51));
        text1.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        text1.setBounds(5, 240, 388, 50);
        text1.setFont(myFont3);
        
        password = new JPasswordField();
        password.setForeground(new java.awt.Color(255,51,51));
        password.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        password.setBounds(5, 320, 388, 50);
        password.setFont(myFont3);
        
        buttonSubmit = new JButton();
        buttonSubmit.setText("Submit");
        buttonSubmit.setForeground(new java.awt.Color(153,102,255));
        buttonSubmit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buttonSubmit.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        buttonSubmit.setAlignmentY((float) 0.5);
        buttonSubmit.setBounds(5, 560, 388, 50);
        buttonSubmit.setFont(myFont4);
        buttonSubmit.addActionListener(this);
        
        Mainpanel = new JPanel();
        Mainpanel.setBackground(Color.getHSBColor(255, 204, 204));
        Mainpanel.setLayout(null);
        Mainpanel.setSize(400,750);
        
        Mainpanel.add(label);
        Mainpanel.add(label1);
        Mainpanel.add(label2);
        Mainpanel.add(label3);
        Mainpanel.add(label4);
        Mainpanel.add(label5);
        
        Mainpanel.add(checkbox);
        
        Mainpanel.add(text1);
        
        Mainpanel.add(password);
        Mainpanel.add(goback_button);
        
        Mainpanel.add(buttonSubmit);
        
        Mainpanel.add(combobox);
        
        frame = new JFrame("SignIn");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 750);
        frame.setLayout(null);
        frame.setResizable(false);
        
        frame.add(Mainpanel);
        
        frame.setVisible(true);
        
    }
    
    public static void main(String[] arg){
        SignIn signin = new SignIn();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == goback_button){
            
            openning op = new openning();
            frame.dispose();
            
        }
        
        if(e.getSource()==combobox){
            if(combobox.getSelectedItem().equals("Admin")){
                userType = (String) combobox.getSelectedItem();
                System.out.println(userType);
                
            }
            else if(combobox.getSelectedItem().equals("Student")){
                userType = (String) combobox.getSelectedItem();
                
                System.out.println(userType);
            }else{
                userType = (String) combobox.getSelectedItem();
                System.out.println(userType);
            }
        }
        
        if(e.getSource()==checkbox)
        {
            if(checkbox.isSelected())
            {
                checkbox.setIcon(icon);
                password.setEchoChar((char)0);
                
            }
            else
            {
                checkbox.setIcon(icon1);
                password.setEchoChar('\u25cf');
                
            }
        }
        
        if(e.getSource()==buttonSubmit)
        {
            System.out.println("user: "+userType);
            
            String email = text1.getText();
            String password01 = String.valueOf(password.getPassword());
        
            if(email.equalsIgnoreCase("") || email.equalsIgnoreCase(null))
            {
                JOptionPane.showMessageDialog(null, "Add a Email","EMAIL", JOptionPane.ERROR_MESSAGE);
            }
            else if(password01.equals("") || password01.equals(null))
            {
                JOptionPane.showMessageDialog(null, "Add a password" ,"PASSWORD", JOptionPane.ERROR_MESSAGE);
            }
            else if(Validation_Email.validationEmail(email)==false)
            {
                JOptionPane.showMessageDialog(null, "Your email need to include "+email+"@Example.com");
            }
            else{

                if(userType.equalsIgnoreCase("Staff"))
                { //insertStaff and insertStaffUse
                    ReadDatabase ReadSignIn = new ReadDatabase();
                    // 
                    try {
                        if(ReadSignIn.ReadSignIn(userType, email, password01) == true){
                            userActivity userAct = new userActivity();
                            userAct.userLogintime(email);
                            level_language lvlanguage = new level_language(email);
                            frame.dispose();
                            //level_language lvlanguage = new level_language();
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(SignIn.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                else if(userType.equalsIgnoreCase("student"))
                { // call insertUser
                    ReadDatabase ReadSignIn = new ReadDatabase();
                    
                    try {
                        if(ReadSignIn.ReadSignIn(userType, email, password01) == true){
                            userActivity userAct = new userActivity();
                            userAct.userLogintime(email);
                            level_language lvlanguage = new level_language(email);
                            frame.dispose();

                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(SignIn.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Please select your student or teacher" ,"SELECT",JOptionPane.INFORMATION_MESSAGE);
                }
            }
            
        }
    }
   
    
    
}
