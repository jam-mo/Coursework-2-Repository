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

public class level_language extends readLevel implements ActionListener { 
    
    
    levelContext lc;
    
    JFrame frame;
    
    JPanel Mainpanel;
    
    JPanel sub_panel;
    JPanel sub_panel1;

    int getid;
    
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
    JLabel[] label4;
    JLabel[] label5;
    
    ArrayList getText = new ArrayList();
    
    ImageIcon[] icon3;
    Image img;
    Image newImg;
    
    ImageIcon icon = new ImageIcon("home-page.png");
    ImageIcon icon1 = new ImageIcon("Search.png");
    ImageIcon icon2 = new ImageIcon("account.png");
    
    Font myFont1 = new Font("Rockwell",Font.BOLD,25);
    Font myFont2 = new Font("Herculanum",Font.BOLD,16);
    Font myFont3 = new Font("Rockwell",Font.PLAIN,13);
    Font myFont4 = new Font("Lucida Grande",Font.PLAIN,16);
    Font myFont5 = new Font("Lucida Grande",Font.PLAIN,14);
    
    level_language(int id){
        
        getid = id;
        
        label = new JLabel();

        label.setForeground(new java.awt.Color(198,102,104));

        label.setText("Choose Level of Spainish");

        label.setBounds(10, 35, 388, 50);
        label.setFont(myFont1);
        

        each_sub_panel1 = new JPanel[4];
        each_sub_panel1_1 = new JPanel[4];
        each_sub_button1_1 = new JButton[4];
        
        label5 = new JLabel[4];
        label4 = new JLabel[4];
        icon3 = new ImageIcon[4];
        
        
        for(int i = 0; i < each_sub_panel1.length; i++){
            // Image for each ImageIcon level A1 - B2
            icon3[0] = new ImageIcon("1.png");
            icon3[1] = new ImageIcon("2.png");
            icon3[2] = new ImageIcon("3.png");
            icon3[3] = new ImageIcon("4.png");
//            icon3  = new ImageIcon();
            img = icon3[i].getImage();
            newImg = img.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
            icon3[i] = new ImageIcon(newImg);
            
            label4[i] = new JLabel();
            label4[i].setPreferredSize(new Dimension(100,100));
            label4[i].setIcon(icon3[i]);
            
            label5[i] = new JLabel();
            label5[i].setPreferredSize(new Dimension(135,100));
            
            each_sub_panel1[i] = new JPanel();
            each_sub_panel1[i].setBackground(new java.awt.Color(198+i+22+i,15*(5*i),50*i+(i*10)));
            each_sub_panel1[i].setLayout(new BorderLayout());
            
            each_sub_panel1_1[i] = new JPanel();
            each_sub_panel1_1[i].setPreferredSize(new Dimension(50,50));
            each_sub_panel1_1[i].setLayout(new BorderLayout());
            
            each_sub_panel1_1[i].setBackground(new java.awt.Color(255, 255, 255));
            
            each_sub_panel1[i].add(label5[i],BorderLayout.WEST);
            each_sub_panel1[i].add(label4[i],BorderLayout.CENTER);
            each_sub_panel1[i].add(each_sub_panel1_1[i],BorderLayout.SOUTH);
            
            each_sub_button1_1[i] = new JButton();

            
        }
        
            each_sub_button1_1[0].setText(" LEVEL_A1");
            each_sub_button1_1[1].setText(" LEVEL_A2");
            each_sub_button1_1[2].setText(" LEVEL_B1");
            each_sub_button1_1[3].setText(" LEVEL_B2");
            
        for(int i = 0; i < each_sub_panel1.length; i++){
            
            
            each_sub_button1_1[i].setForeground(new java.awt.Color(153,102,255));
            each_sub_button1_1[i].setPreferredSize(new Dimension(50,50));
            each_sub_button1_1[i].addActionListener(this); //when clicked it will lead to specific pages selected
//            each_sub_button1_1[i].setBorder(null);
            each_sub_button1_1[i].setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            
            each_sub_panel1_1[i].add(each_sub_button1_1[i],BorderLayout.SOUTH);
            
        }        
        sub_panel = new JPanel();
        sub_panel.setBackground(Color.getHSBColor(255, 204, 204));
            
        for (JPanel each_sub_panel11 : each_sub_panel1) {
            sub_panel.add(each_sub_panel11);
        }
        
        sub_panel.setLayout(new GridLayout(4,1,5,5));
        sub_panel.setPreferredSize(new Dimension(380,136*4));
        
        //when scrollpane is used, it will allow all levels to be scrolled if it doesn't fit into view
        
        JScrollPane scroll = new JScrollPane(sub_panel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(10, 80, 380, 580);
        scroll.setBorder(null);
        
        img = icon.getImage(); //retrieve image and set style
        newImg = img.getScaledInstance(45, 45, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(newImg);
        each_sub_Button1_1 = new JButton();
        each_sub_Button1_1.setIcon(icon);
        each_sub_Button1_1.setText("Home");
        each_sub_Button1_1.setBorder(null);
        each_sub_Button1_1.setHorizontalTextPosition(JButton.CENTER);
        each_sub_Button1_1.setVerticalTextPosition(JButton.BOTTOM);
        each_sub_Button1_1.setForeground(Color.WHITE);
        each_sub_Button1_1.setIconTextGap(-10);
        each_sub_Button1_1.addActionListener(this);
        
        img = icon1.getImage(); //retrieve image and set style
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
        
        img = icon2.getImage(); //retrieve image and set style
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
        
        frame = new JFrame("ChooseLevelSpainish");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 750);
        frame.setLayout(null);
        frame.setResizable(false);
        
        frame.add(Mainpanel);
        
        frame.setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        //button to lead to specific page selected A1-B2
        
        if(e.getSource() == each_sub_button1_1[0]){
            lc = new levelContext("A1",getid );
            frame.dispose();
        }
        
        if(e.getSource() == each_sub_button1_1[1]){
            lc = new levelContext("A2",getid );
            frame.dispose();
        }
        
        if(e.getSource() == each_sub_button1_1[2]){
            lc = new levelContext("B1",getid );
            frame.dispose();
        }
        
        if(e.getSource() == each_sub_button1_1[3]){
            lc = new levelContext("B2",getid );
            frame.dispose();
        }
        
        //button to ( Go back to sign in with userActivity logout ) 
        if(e.getSource() == each_sub_Button1_1 )
        {
            userActivity userAct = new userActivity();

            userAct.userLogouttime(getid);
            SignIn si = new SignIn();
            frame.dispose();
        }
        //button to ( going to Search page )
        if(e.getSource() == each_sub_Button1_2){
           SearchPage Searchbar  = new SearchPage(getid);
           frame.dispose();
        }
        //button to ( going to profile page )
        if(e.getSource() == each_sub_Button1_3 )
        {
            ProfilePage Pp= new ProfilePage(getid);
            Pp.setVisible(true);
            frame.dispose();
        }
        
        
    }
    
    
    
}
