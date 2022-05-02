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
public class levelSubContext extends readLevel implements ActionListener{
    readLevel levelReadData;
    
    SearchPage  Searchbar;
    
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
    
    ImageIcon icon = new ImageIcon("go-back.png");
    ImageIcon icon1 = new ImageIcon("Search.png");
    ImageIcon icon2 = new ImageIcon("account.png");
    
    ImageIcon[] icon3;
    Image img;
    Image newImg;
    
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
        levelReadData.readImgSubContext(language, level, context); 

        each_sub_panel1 = new JPanel[levelReadData.getSubcontext().size()];
        each_sub_panel1_1 = new JPanel[levelReadData.getSubcontext().size()];
        each_sub_button1_1 = new JButton[levelReadData.getSubcontext().size()];
        
        icon3 = new ImageIcon[levelReadData.getSubImg().size()];
        
        for(int i = 0; i < each_sub_button1_1.length; i++){
            
            icon3[i] = new ImageIcon(String.valueOf(levelReadData.getSubImg().get(i)));
            
            img = icon3[i].getImage();
            newImg = img.getScaledInstance(380, 250, java.awt.Image.SCALE_SMOOTH);
            icon3[i] = new ImageIcon(newImg);
            
            each_sub_button1_1[i] = new JButton();
            
            each_sub_button1_1[i].setIcon(icon3[i]);
            each_sub_button1_1[i].setText("""
                                          <html>
                                          <style>
                                          .bg-text {
                                            background-color: rgb(0,0,0);
                                            background-color: rgba(225, 149, 235, 0.2);
                                            font-weight: bold;
                                            font-size: 10px;
                                            border: 3px solid #9E86EB;
                                            padding: 10px;
                                            text-align: center;
                                          }
                                          </style>
                                          <div class="bg-text">
                                          """+levelReadData.getSubcontext().get(i)+"</div></html>");
            
            each_sub_button1_1[i].setForeground(new java.awt.Color(153,102,255));
            each_sub_button1_1[i].setPreferredSize(new Dimension(50,50));
            each_sub_button1_1[i].addActionListener(this);
//            each_sub_button1_1[i].setBorder(null);
            each_sub_button1_1[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            each_sub_button1_1[i].setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
            each_sub_button1_1[i].setVerticalTextPosition(javax.swing.SwingConstants.CENTER);
           
            
        }
        
        sub_panel = new JPanel();
        sub_panel.setBackground(Color.getHSBColor(255, 204, 204));
        for (JButton each_sub_panel11 : each_sub_button1_1) {
            sub_panel.add(each_sub_panel11);
        }
        sub_panel.setLayout(new GridLayout(levelReadData.getContext().size(),1,5,5));
        sub_panel.setPreferredSize(new Dimension(380,200*levelReadData.getSubcontext().size()));
        
        JScrollPane scroll = new JScrollPane(sub_panel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        if(levelReadData.getSubcontext().size() == 1 ){
            scroll.setBounds(10, 80, 380, 210);
            scroll.setBorder(null);
        }else if(levelReadData.getSubcontext().size() < 3)
        {
            scroll.setBounds(10, 80, 380, 420);
            scroll.setBorder(null);
        }
        else{
            scroll.setBounds(10, 80, 380, 590);
            scroll.setBorder(null);
        }
        
        
        img = icon.getImage();
        newImg = img.getScaledInstance(45, 45, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImg);
        each_sub_Button1_1 = new JButton();
        each_sub_Button1_1.setIcon(icon);
        each_sub_Button1_1.setText("Go back");
        each_sub_Button1_1.setBorder(null);
        each_sub_Button1_1.setHorizontalTextPosition(JButton.CENTER);
        each_sub_Button1_1.setVerticalTextPosition(JButton.BOTTOM);
        each_sub_Button1_1.setForeground(Color.WHITE);
        each_sub_Button1_1.setIconTextGap(-10);
        each_sub_Button1_1.addActionListener(this);
        
        img = icon1.getImage();
        newImg = img.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        icon1 = new ImageIcon(newImg);
        each_sub_Button1_2 = new JButton();
        each_sub_Button1_2.setIcon(icon1);
        each_sub_Button1_2.setText("Search");
        each_sub_Button1_2.setBorder(null);
        each_sub_Button1_2.setHorizontalTextPosition(JButton.CENTER);
        each_sub_Button1_2.setVerticalTextPosition(JButton.BOTTOM);
        each_sub_Button1_2.setForeground(Color.WHITE);
        each_sub_Button1_2.setIconTextGap(-10);
        each_sub_Button1_2.addActionListener(this);
        
        img = icon2.getImage();
        newImg = img.getScaledInstance(43, 43, java.awt.Image.SCALE_SMOOTH);
        icon2 = new ImageIcon(newImg);
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
                
//                ReadDatabase ReadSignIn = new ReadDatabase();
//                String[] responses = {"Person A","Person B"};
//                int answer = JOptionPane.showOptionDialog(null, "Which language do you prefer ?","asdas", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE ,null,responses,0);
//                
//                if(answer == 0){
//                    
                    
                    Comm = new Communication("SPANISH", levels,(String) levelReadData.getSubcontext().get(i),getemail);
                    frame.dispose();
//                    
//                }else if(answer == 1){
//                    
//                    String personB = "PERSONB";
//                    
//                    Comm = new Communication("SPANISH", levels , contexts,(String) levelReadData.getSubcontext().get(i),getemail ,personB );
//                    frame.dispose();
//                    
//                }
//                
            }
        }
        
        if(e.getSource() == each_sub_Button1_1 )
        {
            lc = new levelContext("SPANISH", levels,getemail);
            frame.dispose();
        }
        
        if(e.getSource() == each_sub_Button1_2 )
        {
           Searchbar  = new SearchPage(getemail);
           frame.dispose();
        }
        
        if(e.getSource() == each_sub_Button1_3 )
        {
            openning opening= new openning();
            frame.dispose();
        }
        
    }
    
    
}
