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
public class Communication extends readLevel implements ActionListener{
    
    readLevel levelReadData;
    
    JFrame frame;
    
    JPanel Mainpanel;
    
    JPanel sub_panel_center;
    
    JPanel[] sub_panel_center_1 = new JPanel[3];
    JPanel[] sub_panel_center_1_1 = new JPanel[3];
    
    JPanel sub_panel_center_Top;
    JPanel sub_panel_center_center;
    JButton sub_panel_center_buttonSubmit;
    
    JPanel button_panel1;
    
    JPanel[] sub_panel_1 = new JPanel[23];
    
    JButton[] sub_Button = new JButton[3];
    
    JLabel label;
    
    JLabel label1;
    JLabel label2;
    JLabel label3;
    JLabel label4;
    
    JLabel[] label5;
    JLabel label6;
    JLabel[] label7;
    JLabel label8;
    
    Font myFont1 = new Font("Rockwell",Font.BOLD,25);
    Font myFont2 = new Font("Herculanum",Font.BOLD,16);
    Font myFont3 = new Font("Rockwell",Font.PLAIN,13);
    Font myFont4 = new Font("Lucida Grande",Font.PLAIN,16);
    Font myFont5 = new Font("Lucida Grande",Font.PLAIN,14);
    
    ImageIcon[] icon = new ImageIcon[3];
    
    Communication(String language, String level, String context, String subcontext){
        
    icon[0] = new ImageIcon("/Users/kokmeng/Desktop/Coursework-2-Repository/Learn_Language/src/image/go-back.png");
    icon[1] = new ImageIcon("/Users/kokmeng/Desktop/Coursework-2-Repository/Learn_Language/src/image/home-page.png");
    icon[2] = new ImageIcon("/Users/kokmeng/Desktop/Coursework-2-Repository/Learn_Language/src/image/account.png");
        
        label = new JLabel();
        label.setText(subcontext);
        label.setForeground(new java.awt.Color(255,51,51));
        label.setBounds(10, 35, 388, 50);
        label.setFont(myFont1);
        
        levelReadData = new readLevel();
        

        
        sub_panel_center_Top = new JPanel();
        sub_panel_center_Top.setBackground(Color.WHITE);
        sub_panel_center_Top.setPreferredSize(new Dimension(360, 230));
        sub_panel_center_Top.setLayout(new BorderLayout());
        
        levelReadData.ReadtextA(language, level, context, subcontext);
        levelReadData.ReadtextB(language, level, context, subcontext);
        
        label5 = new JLabel[levelReadData.getPersonA().size()];
        label7 = new JLabel[levelReadData.getPersonA().size()];
        
        for (int i = 0 ; i < levelReadData.getPersonA().size() ; i++) {
            
            label5[i] = new JLabel();
            label5[i].setText("<html>• Person A : "+(String) levelReadData.getPersonA().get(i)+"</html>");
            label5[i].setIconTextGap(-10);
//            label5[i].setVerticalAlignment(javax.swing.SwingConstants.TOP);
            label5[i].setPreferredSize(new Dimension(50,50));
            label5[i].setForeground(new java.awt.Color(0,0,0));
            label5[i].setFont(myFont3);
            
        }
        
        for (int i = 0 ; i < levelReadData.getPersonA().size() ; i++) {
            
            label7[i] = new JLabel();
            label7[i].setText("• Person B : "+(String) levelReadData.getPersonB().get(i));
            label7[i].setPreferredSize(new Dimension(10,50));
            label7[i].setForeground(new java.awt.Color(255,51,51));
            label7[i].setFont(myFont3);
            
        }

        sub_panel_center_center = new JPanel();
        sub_panel_center_center.setBackground(new java.awt.Color(233,255,255));
        sub_panel_center_center.setPreferredSize(new Dimension(360, 700));
        sub_panel_center_center.setLayout(new GridLayout(10,1,0,0));
        
        for (int i = 0 ; i < label5.length ; i++) {
            
            sub_panel_center_center.add(label5[i]);
            
            sub_panel_center_center.add(label7[i]);

        }
        
        
        sub_panel_center_buttonSubmit = new JButton();
        sub_panel_center_buttonSubmit.setPreferredSize(new Dimension(360, 50));
        sub_panel_center_buttonSubmit.setLayout(new BorderLayout());
        
        
        sub_panel_center_buttonSubmit.setText("Complete");
        sub_panel_center_buttonSubmit.setForeground(new java.awt.Color(153,102,255));
        sub_panel_center_buttonSubmit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sub_panel_center_buttonSubmit.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        sub_panel_center_buttonSubmit.addActionListener(this);
        
        sub_panel_center= new JPanel();
        sub_panel_center.setBackground(new java.awt.Color(233,255,255));
        sub_panel_center.setLayout(new BorderLayout(0,10));

        
        JScrollPane scroll = new JScrollPane(sub_panel_center,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(10, 80, 380, 590);
        scroll.setBorder(null);

        sub_panel_center.add(sub_panel_center_Top,BorderLayout.NORTH);
        sub_panel_center.add(sub_panel_center_center,BorderLayout.CENTER);
        sub_panel_center.add(sub_panel_center_buttonSubmit,BorderLayout.SOUTH);
        
        button_panel1 = new JPanel();
        button_panel1.setBackground(new java.awt.Color(23, 213, 164));
        button_panel1.setBounds(0, 674, 400, 55);
        button_panel1.setLayout(new GridLayout(1,3,10,10));
        
        for(int i = 0; i < sub_Button.length ; i++){
            sub_Button[i] = new JButton();
            sub_Button[i].setIcon(icon[i]);
            sub_Button[i].setBorder(null);
            sub_Button[i].addActionListener(this);
            
            button_panel1.add(sub_Button[i]);
        }
        Mainpanel = new JPanel();
        Mainpanel.setBackground(new java.awt.Color(233,255,255));
        Mainpanel.setLayout(null);
        Mainpanel.setSize(400,750);
        
        Mainpanel.add(label);
        
        Mainpanel.add(scroll,BorderLayout.CENTER);
        Mainpanel.add(button_panel1);
        
        frame = new JFrame("Learn language");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 750);
        frame.setLayout(null);
        frame.setResizable(false);
        
        frame.add(Mainpanel);
        
        frame.setVisible(true);
        
    }
    
    public static void main(String[] arg){
        Communication c = new Communication("SPANISH","LEVEL_A1" ,"Ordering food and drink" ,"Take Away");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
