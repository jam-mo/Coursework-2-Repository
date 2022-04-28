/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StartedPage;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author kokmeng
 */
public class levelSubContext extends readLevel implements ActionListener{
    readLevel levelReadData;
    
    levelContext lc;
    
    Communication Comm;
    
    level_language ll2;
    
    JFrame frame;
    
    JPanel Mainpanel;
    
    JPanel sub_panel;
    JPanel sub_panel1;

    String levels;
    String contexts;
    String getemail;
    
    JPanel[] each_sub_panel1;
    
    JPanel[] each_sub_panel1_1;
    
    JButton[] each_sub_button1_1;
    
    JButton each_sub_Button1_1;
    JButton each_sub_Button1_2;
    JButton each_sub_Button1_3;
    
    JLabel label;
    JLabel label1;
    JLabel label2;
    
    JLabel label3;
    
    ArrayList getText = new ArrayList();
    
    MouseAdapter Map = new MouseAdapter() {
        
    };
    
    ImageIcon icon = new ImageIcon("/Users/kokmeng/Desktop/Coursework-2-Repository/Learn_Language/src/image/go-back.png");
    ImageIcon icon1 = new ImageIcon("/Users/kokmeng/Desktop/Coursework-2-Repository/Learn_Language/src/image/home-page.png");
    ImageIcon icon2 = new ImageIcon("/Users/kokmeng/Desktop/Coursework-2-Repository/Learn_Language/src/image/account.png");
    
    Font myFont1 = new Font("Rockwell",Font.BOLD,25);
    Font myFont2 = new Font("Herculanum",Font.BOLD,16);
    Font myFont3 = new Font("Rockwell",Font.PLAIN,13);
    Font myFont4 = new Font("Lucida Grande",Font.PLAIN,16);
    Font myFont5 = new Font("Lucida Grande",Font.PLAIN,14);
    
    levelSubContext (String language, String level, String context,String email){
        
        levels = level;
        contexts = context;
        getemail = email;
        
        label = new JLabel();
        label.setText(context);
        label.setForeground(new java.awt.Color(198,102,104));
        label.setBounds(10, 35, 388, 50);
        label.setFont(myFont1);
        
        levelReadData = new readLevel();
        
        levelReadData.subcontext(language, level, context); // change 

        each_sub_panel1 = new JPanel[levelReadData.getSubcontext().size()];
        each_sub_panel1_1 = new JPanel[levelReadData.getSubcontext().size()];
        each_sub_button1_1 = new JButton[levelReadData.getSubcontext().size()];
        
        for(int i = 0; i < each_sub_panel1.length; i++){
            
            
            each_sub_panel1[i] = new JPanel();
            each_sub_panel1[i].setBackground(new java.awt.Color(220-i-i-i-i-i,220/2-i-i-i-i,255/2-i-i));
            each_sub_panel1[i].setLayout(new BorderLayout());
            
            each_sub_panel1_1[i] = new JPanel();
            each_sub_panel1_1[i].setPreferredSize(new Dimension(50,50));
            each_sub_panel1_1[i].setLayout(new BorderLayout());
            
            each_sub_panel1_1[i].setBackground(new java.awt.Color(255, 255, 255));
            
            
            each_sub_panel1[i].add(each_sub_panel1_1[i],BorderLayout.SOUTH);
            
            each_sub_button1_1[i] = new JButton();
            
            
            each_sub_button1_1[i].setText(" "+levelReadData.getSubcontext().get(i));
            
            
            each_sub_button1_1[i].setForeground(new java.awt.Color(153,102,255));
            each_sub_button1_1[i].setPreferredSize(new Dimension(50,50));
            each_sub_button1_1[i].addActionListener(this);
//            each_sub_button1_1[i].setBorder(null);
            each_sub_button1_1[i].setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            
            each_sub_panel1_1[i].add(each_sub_button1_1[i],BorderLayout.SOUTH);
            
        }
        
        sub_panel = new JPanel();
        sub_panel.setBackground(Color.getHSBColor(255, 204, 204));
        for (JPanel each_sub_panel11 : each_sub_panel1) {
            sub_panel.add(each_sub_panel11);
        }
        sub_panel.setLayout(new GridLayout(levelReadData.getContext().size(),1,5,5));
        sub_panel.setPreferredSize(new Dimension(380,136*levelReadData.getSubcontext().size()));
        
        JScrollPane scroll = new JScrollPane(sub_panel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(10, 80, 380, 580);
        scroll.setBorder(null);
            
        
        each_sub_Button1_1 = new JButton("Return to Content page");
        each_sub_Button1_1.setIcon(icon);
        each_sub_Button1_1.setText("Go back");
        each_sub_Button1_1.setBorder(null);
        each_sub_Button1_1.setHorizontalTextPosition(JButton.CENTER);
        each_sub_Button1_1.setVerticalTextPosition(JButton.BOTTOM);
        each_sub_Button1_1.setForeground(Color.WHITE);
        each_sub_Button1_1.setIconTextGap(-10);
        each_sub_Button1_1.addActionListener(this);
        
        each_sub_Button1_2 = new JButton();
        each_sub_Button1_2.setIcon(icon1);
        each_sub_Button1_2.setText("Home");
        each_sub_Button1_2.setBorder(null);
        each_sub_Button1_2.setHorizontalTextPosition(JButton.CENTER);
        each_sub_Button1_2.setVerticalTextPosition(JButton.BOTTOM);
        each_sub_Button1_2.setForeground(Color.WHITE);
        each_sub_Button1_2.setIconTextGap(-10);
        each_sub_Button1_2.addActionListener(this);
        

        each_sub_Button1_3 = new JButton();
        each_sub_Button1_3.setText("Profile");
        each_sub_Button1_3.setIcon(icon2);
        each_sub_Button1_3.setBorder(null);
        each_sub_Button1_3.setHorizontalTextPosition(JButton.CENTER);
        each_sub_Button1_3.setVerticalTextPosition(JButton.BOTTOM);
        each_sub_Button1_3.setForeground(Color.WHITE);
        each_sub_Button1_3.setIconTextGap(-5);
        each_sub_Button1_3.addActionListener(this);
        
        sub_panel1 = new JPanel();
        sub_panel1.setBackground(new java.awt.Color(120,139,204));
        sub_panel1.setBounds(0, 674, 400, 55);
        
        sub_panel1.setLayout(new GridLayout(1,3,10,10));
        
        sub_panel1.add(each_sub_Button1_1);
        sub_panel1.add(each_sub_Button1_2);
        sub_panel1.add(each_sub_Button1_3);
        
        Mainpanel = new JPanel();
        Mainpanel.setBackground(Color.getHSBColor(255, 204, 204));
        Mainpanel.setLayout(null);
        Mainpanel.setSize(400,750);
        
        Mainpanel.add(label);
        
        Mainpanel.add(scroll,BorderLayout.CENTER);
        Mainpanel.add(sub_panel1);
        
        frame = new JFrame("Context");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 750);
        frame.setLayout(null);
        frame.setResizable(false);
        
        frame.add(Mainpanel);
        
        frame.setVisible(true);
        
    }
    
//    public static void main(String[] arg){
//        levelSubContext lg = new levelSubContext("SPANISH","LEVEL_A1","Ordering food and drink");
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        for(int i = 0; i< levelReadData.getSubcontext().size(); i++)
        {
            if (e.getSource() == each_sub_button1_1[i]) {
                Comm = new Communication("SPANISH", levels , contexts,(String) levelReadData.getSubcontext().get(i),getemail );
                frame.dispose();
            }
        }
        
        if(e.getSource() == each_sub_Button1_1 )
        {
            lc = new levelContext("SPANISH", levels,getemail);
            frame.dispose();
        }
        
        if(e.getSource() == each_sub_Button1_2 )
        {
            ll2 = new level_language("SPANISH",getemail);
            frame.dispose();
        }
        
        if(e.getSource() == each_sub_Button1_3 )
        {
            openning opening= new openning();
            frame.dispose();
        }
        
    }
    
    
}
