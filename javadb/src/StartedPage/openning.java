/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StartedPage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javadb.*;


/**
 *
 * @author kokmeng
 */
public class openning implements ActionListener {
    
    JFrame frame;
    
    JPanel Mpanel;
    
    JButton button;
    
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    JLabel label5;
    JLabel label6;
    
    Font myFont1 = new Font("Herculanum",Font.BOLD,60);
    Font myFont2 = new Font("Luminari",Font.PLAIN,20);
    
    openning(){
        
        label1 = new JLabel();
        label1.setText("WELCOME");
        label1.setForeground(new java.awt.Color(255, 51, 102));
        label1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label1.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        label1.setBounds(0, 250, 388, 50);
        label1.setFont(myFont1);
        
        label2 = new JLabel();
        label2.setText("To Understading Moth Team");
        label2.setForeground(new java.awt.Color(153, 0, 51));
        label2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label2.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        label2.setBounds(0, 350, 388, 30);
        label2.setFont(myFont2);
        
        label3 = new JLabel();
        label3.setText("Speaking Assitance Application");
        label3.setForeground(new java.awt.Color(153, 0, 51));
        label3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label3.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        label3.setBounds(0, 400, 388, 30);
        label3.setFont(myFont2);
        
        label4 = new JLabel();
        label4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        label4.setBounds(-50, 650, 388, 30);
        label4.setText("If you dont have any Account |");
        
        label5 = new JLabel();
        label5.setText("Sign Up");
        label5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        label5.setBounds(80, 650, 388, 30);
        label5.setForeground(new java.awt.Color(51, 51, 255));
        label5.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e)  
            {  
               // you can open a new frame here as
               // i have assumed you have declared "frame" as instance variable
                SignUp signIn = new SignUp();
                frame.dispose();


            }  
        });
        

        label6 = new JLabel();
        label6.setFont(new java.awt.Font("Phosphate", 0, 15)); 
        label6.setForeground(new java.awt.Color(102, 51, 255));
        label6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label6.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        label6.setText("GET START");
        
        
        Mpanel = new JPanel();
        Mpanel.setBackground(Color.getHSBColor(255, 204, 204));
        Mpanel.setLayout(null);
        Mpanel.setSize(400,750);
        
        button = new JButton();
        button.setBackground(Color.WHITE);
        button.setPreferredSize(new Dimension(388,50));
        button.setBounds(10, 500, 380, 50);
        button.setLayout(new BorderLayout());
        button.addActionListener(this);
//        button.addMouseListener(new MouseAdapter(){
//            public void mouseClicked(MouseEvent e)  
//            {  
//               // you can open a new frame here as
//               // i have assumed you have declared "frame" as instance variable
////                SignIn signIn = new SignIn();
////                frame.dispose();
//
//            }  
//        });

        
        button.add(label6);
        
        
        Mpanel.add(label1);
        Mpanel.add(label2);
        Mpanel.add(label3);
        
        Mpanel.add(button);
        
        Mpanel.add(label4);
        Mpanel.add(label5);
        
        
        frame = new JFrame("LearnSpainLanguage");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 750);
        frame.setLayout(null);
        frame.setResizable(false);
        
        frame.add(Mpanel);
        
        frame.setVisible(true);
        
    }
    
    
    public static void main(String[] arg){
       openning opening= new openning();
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==button){
            System.out.println("lets get started");
                SignIn signIn = new SignIn();
                frame.dispose();
        }
        
    }
    
}
