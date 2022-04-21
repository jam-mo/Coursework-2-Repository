/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StartedPage;

import Validation_Email_Password.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javax.swing.*;
import jdbacApi.connectDB;
import java.util.regex.*;

/**
 *
 * @author kokmeng
 */

public class SignUp extends ReadDatabase implements ActionListener{
    
    String firstName;
    String lastName;
    String password;
    String email;

    
    
    
    JFrame frame1;
    
    JPanel Mainpanel;
    
    JLabel label;
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;
    JLabel label6;
    JLabel label7;
    JLabel label8;
    
    JCheckBox checkbox;
    JCheckBox checkbox1;
    
    JTextField text1;
    JTextField text2;
    JTextField text3;
    
    JPasswordField passwordfield;
    JPasswordField re_passwordfield;
    
    JButton buttonSubmit;

    ImageIcon icon = new ImageIcon("/Users/kokmeng/Desktop/Coursework-2-Repository/Learn_Language_group_project_MOTH/src/image/eye.png");
    ImageIcon icon1 = new ImageIcon("/Users/kokmeng/Desktop/Coursework-2-Repository/Learn_Language_group_project_MOTH/src/image/hidden.png");
    
    Font myFont1 = new Font("Arial Rounded MT Bold",Font.BOLD,30);
    Font myFont2 = new Font("Herculanum",Font.BOLD,16);
    Font myFont3 = new Font("Rockwell",Font.PLAIN,13);
    Font myFont4 = new Font("Lucida Grande",Font.PLAIN,16);
    Font myFont5 = new Font("Lucida Grande",Font.PLAIN,14);
    
    SignUp(){

        label = new JLabel();
        label.setText("SignUp");
        label.setForeground(new java.awt.Color(255,51,51));
        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        label.setBounds(0, 50, 388, 50);
        label.setFont(myFont1);
        
        label1 = new JLabel();
        label1.setText("First Name:");
        label1.setForeground(new java.awt.Color(102,102,255));
        label1.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        label1.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        label1.setBounds(10, 100, 388, 50);
        label1.setFont(myFont2);
        
        label2 = new JLabel();
        label2.setText("Last Name:");
        label2.setForeground(new java.awt.Color(102,102,255));
        label2.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        label2.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        label2.setBounds(10, 180, 388, 50);
        label2.setFont(myFont2);
        
        label3 = new JLabel();
        label3.setText("Email Address:");
        label3.setForeground(new java.awt.Color(102,102,255));
        label3.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        label3.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        label3.setBounds(10, 260, 388, 50);
        label3.setFont(myFont2);
        
        label4 = new JLabel();
        label4.setText("Password:");
        label4.setForeground(new java.awt.Color(102,102,255));
        label4.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        label4.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        label4.setBounds(10, 340, 388, 50);
        label4.setFont(myFont2);
        
        label5 = new JLabel();
        label5.setText("Confirm Password:");
        label5.setForeground(new java.awt.Color(102,102,255));
        label5.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        label5.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        label5.setBounds(10, 420, 388, 50);
        label5.setFont(myFont2);
        
        label6 = new JLabel();
        label6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label6.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        label6.setBounds(-50, 650, 388, 30);
        label6.setText("If you already have Account |");
        
        label7 = new JLabel();
        label7.setText("Sign In");
        label7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label7.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        label7.setBounds(80, 650, 388, 30);
        label7.setForeground(new java.awt.Color(51, 51, 255));
        label7.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e)  
            {  
               // you can open a new frame here as
               // i have assumed you have declared "frame" as instance variable
                SignIn signIn = new SignIn();
                frame1.dispose();


            }  
        });
        
        text1 = new JTextField();
        text1.setForeground(new java.awt.Color(255,51,51));
        text1.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        text1.setBounds(5, 140, 388, 50);
        text1.setFont(myFont3);
        
        text2 = new JTextField();
        text2.setForeground(new java.awt.Color(255,51,51));
        text2.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        text2.setBounds(5, 220, 388, 50);
        text2.setFont(myFont3);
        
        text3 = new JTextField();
        text3.setForeground(new java.awt.Color(255,51,51));
        text3.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        text3.setBounds(5, 300, 388, 50);
        text3.setFont(myFont3);
        
        checkbox = new JCheckBox();
        checkbox.setIcon(icon1);
        checkbox.setForeground(new java.awt.Color(255,51,51));
        checkbox.setFocusable(false);
        checkbox.setBounds(350, 340, 50, 50);
        checkbox.addActionListener(this);
        checkbox.setFont(myFont5);
        
        checkbox1 = new JCheckBox();
        checkbox1.setIcon(icon1);
        checkbox1.setForeground(new java.awt.Color(255,51,51));
        checkbox1.setFocusable(false);
        checkbox1.setBounds(350, 420, 50, 50);
        checkbox1.addActionListener(this);
        checkbox1.setFont(myFont5);
       
        passwordfield = new JPasswordField();
        passwordfield.setForeground(new java.awt.Color(255,51,51));
        passwordfield.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        passwordfield.setBounds(5, 380, 388, 50);
        passwordfield.setFont(myFont3);
        
        re_passwordfield = new JPasswordField();
        re_passwordfield.setForeground(new java.awt.Color(255,51,51));
        re_passwordfield.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        re_passwordfield.setBounds(5, 460, 388, 50);
        re_passwordfield.setFont(myFont3);
        
        buttonSubmit = new JButton();
        buttonSubmit.setText("Next");
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
        Mainpanel.add(label6);
        Mainpanel.add(label7);
        
        Mainpanel.add(text1);
        Mainpanel.add(text2);
        Mainpanel.add(text3);
        
        Mainpanel.add(passwordfield);
        Mainpanel.add(re_passwordfield);
        
        Mainpanel.add(buttonSubmit);
        
        Mainpanel.add(checkbox);
        Mainpanel.add(checkbox1);
        
        frame1 = new JFrame("SignUP");
        frame1.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame1.setSize(400, 750);
        frame1.setLayout(null);
        frame1.setResizable(false);
        
        frame1.add(Mainpanel);
        
        frame1.setVisible(true);
        
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==checkbox) //Change Icon hen show display
        {
            if(checkbox.isSelected())
            {
                checkbox.setIcon(icon);
                passwordfield.setEchoChar((char)0);
                
            }
            else
            {
                checkbox.setIcon(icon1);
                passwordfield.setEchoChar('\u25cf');
                
            }
        }
        
        if(e.getSource()==checkbox1)
        {
            if(checkbox1.isSelected())
            {
                checkbox1.setIcon(icon);
                re_passwordfield.setEchoChar((char)0);
                
            }
            else
            {
                checkbox1.setIcon(icon1);
                re_passwordfield.setEchoChar('\u25cf');
                
            }
        }
        
        if(e.getSource()==buttonSubmit){
            
            firstName = text1.getText();
            lastName = text2.getText();
            email = text3.getText();
            
            this.password = String.valueOf(passwordfield.getPassword());
            String re_password01 = String.valueOf(re_passwordfield.getPassword());
            
            if(firstName.equalsIgnoreCase("") || firstName.equalsIgnoreCase(null))
            {
                JOptionPane.showMessageDialog(null, "Add a First User");
            }
            else if(lastName.equalsIgnoreCase("") || lastName.equalsIgnoreCase(null))
            {
                JOptionPane.showMessageDialog(null, "Add a Last User");
            }
            else if(email.equalsIgnoreCase("") || email.equalsIgnoreCase(null))
            {
                JOptionPane.showMessageDialog(null, "Add a Email");
            }
            else if(password.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Add a password");
            }
            else if(!password.equals(re_password01))
            {
                JOptionPane.showMessageDialog(null, "Your password dont match comfirm password");
            }
            else if(Validation_Email.validationEmail(email)==false)
            {
                JOptionPane.showMessageDialog(null, "Your email need to include "+email+"@Example.com");
            }
            else if(Validation_Password.isSpace(password)==false)
            {
                JOptionPane.showMessageDialog(null, "Please dont use space in password");
            }
            else if(Validation_Password.hasSpecialCharactor(password)==false)
            {
                JOptionPane.showMessageDialog(null, "Your password require Special Charactor");
            }
            else if(Validation_Password.validationPassword(password)==false)
            {
                JOptionPane.showMessageDialog(null, """
                                                    Your password need to include
                                                    At least 8 Characters
                                                    At lease 1 Capital Letter
                                                    At least 1 lower case
                                                    At least 1 number
                                                    """);
            }
            else
            {
                if(ReadEmail(email)==false){
                    JOptionPane.showMessageDialog(null, "Amazing");
                    frame1.dispose();
                    Security_Question s_q = new Security_Question(firstName, lastName, email, password);

                }else{
                    JOptionPane.showMessageDialog(null, "Email Alreay Have");
                }
                
            }
            
        }
    
    }
    
    public static void main(String[] arg){
       SignUp opening= new SignUp();
       
    }
    

}
