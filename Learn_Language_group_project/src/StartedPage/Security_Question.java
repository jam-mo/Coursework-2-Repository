/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StartedPage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author kokmeng
 */

public class Security_Question extends ReadDatabase implements ActionListener{
    
    String qestionText1;
    String qestionText2;
    String qestionText3;
    
    String firstname;
    String lastname;
    String emailAddress;
    String password;
    
    JFrame frame;
    
    JPanel Mpanel;
        
    JLabel label;
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;
        
    JTextField text1;
    JTextField text2;
    JTextField text3;
        
    JButton buttonSubmit;
    
    ImageIcon icon = new ImageIcon(getClass().getResource(""));
    
    Font myFont1 = new Font("Arial Rounded MT Bold",Font.BOLD,30);
    Font myFont2 = new Font("Herculanum",Font.BOLD,16);
    Font myFont3 = new Font("Rockwell",Font.PLAIN,13);
    Font myFont4 = new Font("Lucida Grande",Font.PLAIN,16);
    Font myFont5 = new Font("Lucida Grande",Font.PLAIN,14);
    
    Security_Question(String fname, String lname, String email, String password){
        
        this.firstname = fname;
        this.lastname = lname;
        this.emailAddress = email;
        this.password = password;
        
        label = new JLabel();
        label.setText("Security Question");
        label.setForeground(new java.awt.Color(255,51,51));
        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        label.setBounds(0, 50, 388, 50);
        label.setFont(myFont1);
        
        label1 = new JLabel();
        label1.setText("Quetion 1: Are you single?");
        label1.setForeground(new java.awt.Color(102,102,255));
        label1.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        label1.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        label1.setBounds(10, 180, 388, 50);
        label1.setFont(myFont2);
        
        label2 = new JLabel();
        label2.setText("Quetion 2: Are you single?");
        label2.setForeground(new java.awt.Color(102,102,255));
        label2.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        label2.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        label2.setBounds(10, 260, 388, 50);
        label2.setFont(myFont2);
        
        label3 = new JLabel();
        label3.setText("Quetion 3: Are you single?");
        label3.setForeground(new java.awt.Color(102,102,255));
        label3.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        label3.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        label3.setBounds(10, 340, 388, 50);
        label3.setFont(myFont2);
        
        label4 = new JLabel();
        label4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        label4.setBounds(-50, 650, 388, 30);
        label4.setText("if you want to change something click |");
        
        label5 = new JLabel();
        label5.setText("Go Back");
        label5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        label5.setBounds(110, 650, 388, 30);
        label5.setForeground(new java.awt.Color(51, 51, 255));
        label5.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e)  
            {  
               // you can open a new frame here as
               // i have assumed you have declared "frame" as instance variable
                SignUp signUP = new SignUp();
                frame.dispose();


            }  
        });
        
        text1 = new JTextField();
        text1.setForeground(new java.awt.Color(255,51,51));
        text1.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        text1.setBounds(5, 220, 388, 50);
        text1.setFont(myFont3);
        
        text2 = new JTextField();
        text2.setForeground(new java.awt.Color(255,51,51));
        text2.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        text2.setBounds(5, 300, 388, 50);
        text2.setFont(myFont3);
        
        text3 = new JTextField();
        text3.setForeground(new java.awt.Color(255,51,51));
        text3.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        text3.setBounds(5, 380, 388, 50);
        text3.setFont(myFont3);
        
        buttonSubmit = new JButton();
        buttonSubmit.setText("Submit");
        buttonSubmit.setForeground(new java.awt.Color(153,102,255));
        buttonSubmit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buttonSubmit.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        buttonSubmit.setAlignmentY((float) 0.5);
        buttonSubmit.setBounds(5, 560, 388, 50);
        buttonSubmit.setFont(myFont4);
        
        buttonSubmit.addActionListener(this);
        
        Mpanel = new JPanel();
        Mpanel.setBackground(Color.getHSBColor(255, 204, 204));
        Mpanel.setLayout(null);
        Mpanel.setSize(400,750);
        
        Mpanel.add(label);
        Mpanel.add(label1);
        Mpanel.add(label2);
        Mpanel.add(label3);
        Mpanel.add(label4);
        Mpanel.add(label5);
        
        Mpanel.add(text1);
        Mpanel.add(text2);
        Mpanel.add(text3);
        
        Mpanel.add(buttonSubmit);
        
        frame = new JFrame("Security Question");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 750);
        frame.setLayout(null);
        frame.setResizable(false);
        
        frame.add(Mpanel);
        
        frame.setVisible(true);
        
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==buttonSubmit){
            
            this.qestionText1 = text1.getText();
            this.qestionText2 = text2.getText();
            this.qestionText3 = text3.getText();
            
            if(qestionText1.equals("")){
                JOptionPane.showMessageDialog(null, "Please Answer Question 1");
            }else if (qestionText2.equals("")){
                JOptionPane.showMessageDialog(null, "Please Answer Question 2");
            }else if (qestionText3.equals("")){
                JOptionPane.showMessageDialog(null, "Please Answer Question 3");
            }else if(!(qestionText1.equals("") && qestionText2.equals("") && qestionText3.equals("")))
            {
                
                if(qestionText1.equalsIgnoreCase(qestionText2) || qestionText1.equalsIgnoreCase(qestionText3))
                {
                    JOptionPane.showMessageDialog(null, "Sorry! You can not have the same answer");
                }
                else if (qestionText2.equalsIgnoreCase(qestionText1) || qestionText2.equalsIgnoreCase(qestionText3))
                {
                    JOptionPane.showMessageDialog(null, "Sorry! You can not have the same answer");
                }
                else if(qestionText2.equalsIgnoreCase(qestionText1) || qestionText2.equalsIgnoreCase(qestionText3))
                {
                    JOptionPane.showMessageDialog(null, "Sorry! You can not have the same answer");
                }
                else
                {
                
                    JOptionPane.showMessageDialog(null, "Wow amazing answer! Your account is created");

                    ReadDatabase Input = new ReadDatabase();
                    Input.InputSignUp(firstname, lastname, emailAddress, password, qestionText1, qestionText2, qestionText3);

                    SignIn SignIn = new SignIn();
                    frame.dispose();
                }
                
            }
                
        }
    }
    
}
