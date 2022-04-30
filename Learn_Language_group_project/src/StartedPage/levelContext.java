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
 * @author kokmeng / christopher
 */

public class levelContext extends readLevel implements ActionListener {
    
    readLevel levelReadData;
    
    levelSubContext lsc;
    
    level_language ll2;
    
    JFrame frame;
    
    JPanel Mainpanel;
    
    JPanel sub_panel;
    JPanel sub_panel1;

    String levels;
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
    
    
    ImageIcon icon = new ImageIcon("go-back.png");
    ImageIcon icon1 = new ImageIcon("home-page.png");
    ImageIcon icon2 = new ImageIcon("account.png");
    
    ImageIcon[] icon3;
    Image img;
    Image newImg;
    
//    ImageIcon icon3;
    
    
    Font myFont1 = new Font("Rockwell",Font.BOLD,25);
    Font myFont2 = new Font("Herculanum",Font.BOLD,16);
    Font myFont3 = new Font("Rockwell",Font.PLAIN,13);
    Font myFont4 = new Font("Lucida Grande",Font.PLAIN,16);
    Font myFont5 = new Font("Lucida Grande",Font.PLAIN,14);
    
    Font myFont6 = new Font("Lucida Grande",Font.BOLD,16);
    
    levelContext(String language, String level, String email){
        
        getemail = email;
        
        label = new JLabel();
        label.setText(level);
        label.setForeground(new java.awt.Color(198,102,104));
        label.setBounds(10, 35, 388, 50);
        label.setFont(myFont1);
        
        levelReadData = new readLevel();
        
        levelReadData.context(language,level); 
        levelReadData.readImgContext(language,level); 
        
        levels = level;

        each_sub_panel1 = new JPanel[levelReadData.getContext().size()];
        each_sub_panel1_1 = new JPanel[levelReadData.getContext().size()];
        each_sub_button1_1 = new JButton[levelReadData.getContext().size()];
        
        icon3 = new ImageIcon[levelReadData.getImg().size()];
        
        for(int i = 0; i < each_sub_button1_1.length; i++){
            
            icon3[i] = new ImageIcon(String.valueOf(levelReadData.getImg().get(i)));
//            icon3  = new ImageIcon();
            img = icon3[i].getImage();
            newImg = img.getScaledInstance(380, 250, java.awt.Image.SCALE_SMOOTH);
            icon3[i] = new ImageIcon(newImg);
            
            each_sub_button1_1[i] = new JButton();
            each_sub_button1_1[i].setIcon(icon3[i]);
            each_sub_button1_1[i].setText("""
                                          <html>
                                          <style>
                                          .bg-text {
                                            background-color: rgb(250, 235, 239);
                                            background-color: rgba(250, 235, 239, 0.7);
                                            font-weight: bold;
                                            color:#D9514EFF;
                                            border: 3px solid #D9514EFF;
                                            padding: 10px;
                                            text-align: center;
                                          }
                                          </style>
                                          <div class="bg-text">
                                          """+levelReadData.getContext().get(i)+"</div></html>");
            each_sub_button1_1[i].setFont(myFont6);
            each_sub_button1_1[i].setForeground(new java.awt.Color(255,255,255));
            each_sub_button1_1[i].addActionListener(this);
//            each_sub_button1_1[i].setBorder(null);
            each_sub_button1_1[i].setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            each_sub_button1_1[i].setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
            
        }
        
        
        sub_panel = new JPanel();
        sub_panel.setBackground(Color.getHSBColor(255, 204, 204));
        
        for (JButton each_sub_panel11 : each_sub_button1_1) {
            sub_panel.add(each_sub_panel11);
        }
        
        sub_panel.setLayout(new GridLayout(levelReadData.getContext().size(),1,5,5));
        sub_panel.setPreferredSize(new Dimension(380,200*levelReadData.getContext().size()));
        
        JScrollPane scroll = new JScrollPane(sub_panel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(10, 80, 380, 580);
        scroll.setBorder(null);
            
        
        each_sub_Button1_1 = new JButton();
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
        sub_panel1.setBounds(0, 673, 400, 55);
        
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
    
    public static void  main(String[] arg){
        levelContext le = new levelContext("SPANISH","LEVEL_A1","asdas");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        for(int i = 0; i< levelReadData.getContext().size(); i++)
        {
            
            if (e.getSource() == each_sub_button1_1[i]) {
                lsc = new levelSubContext("SPANISH", levels , (String) levelReadData.getContext().get(i), getemail);
                frame.dispose();
            }
        }
        
        if(e.getSource() == each_sub_Button1_1)
        {
            ll2 = new level_language("SPANISH", getemail);
            frame.dispose();
        }
        
        if(e.getSource() == each_sub_Button1_2)
        {
            SignIn si = new SignIn();
            frame.dispose();
        }
        
        if(e.getSource() == each_sub_Button1_2)
        {
            SignIn si = new SignIn();
            frame.dispose();
        }
        
        if(e.getSource() == each_sub_Button1_3 )
        {
            openning opening= new openning();
            frame.dispose();
        }
        
    }
    
    
    
}
