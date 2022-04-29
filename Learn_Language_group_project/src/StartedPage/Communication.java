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
 * @author kokmeng / christopher
 */
public class Communication extends readLevel implements ActionListener{
    
    readLevel levelReadData;
    
    JFrame frame;
    
    JPanel Mainpanel;
    
    JPanel sub_panel_center;
    
    levelSubContext lsc;
    
    String levels;
    String contexts;
    String subContexts;
    String getemail;
    
    JPanel[] sub_panel_center_1 = new JPanel[3];
    JPanel[] sub_panel_center_1_1 = new JPanel[3];
    
    JPanel sub_panel_center_Top;
    JPanel sub_panel_center_center;
    JButton sub_panel_center_buttonSubmit;
    
    JPanel sub_panel1;
    
    JPanel[] sub_panel_1 = new JPanel[23];
    
    JButton each_sub_Button1_1;
    JButton each_sub_Button1_2;
    JButton each_sub_Button1_3;
    
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
    
    Communication(String language, String level, String context, String subcontext,String email){
        
        levels = level;
        contexts = context;
        subContexts = subcontext;
        getemail = email;
        
        icon[0] = new ImageIcon("go-back.png");
        icon[1] = new ImageIcon("home-page.png");
        icon[2] = new ImageIcon("account.png");
        
        label = new JLabel();
        label.setText(subcontext);
        label.setForeground(new java.awt.Color(198,102,104));
        label.setBounds(10, 35, 388, 50);
        label.setFont(myFont1);
        
        levelReadData = new readLevel();
        

        
        sub_panel_center_Top = new JPanel();
        sub_panel_center_Top.setBackground(Color.WHITE);
        sub_panel_center_Top.setPreferredSize(new Dimension(360, 230));
        sub_panel_center_Top.setLayout(new BorderLayout());
        
        levelReadData.ReadtextA(language, level, context, subcontext);
        levelReadData.ReadtextB(language, level, context, subcontext);
        

        
        if(levelReadData.getPersonA().size()> levelReadData.getPersonB().size()){
            label5 = new JLabel[levelReadData.getPersonA().size()];
            label7 = new JLabel[levelReadData.getPersonA().size()];
            
            levelReadData.getPersonB().add("<p style='color:red;' >_______________________END _____________________(Thank you for using ours app 🥰)</p>");
          
            for (int i = 0 ; i < levelReadData.getPersonA().size() ; i++) {

                label5[i] = new JLabel();
                label5[i].setText("<html> <b>+</b> Person A : <p> →  "+(String) levelReadData.getPersonA().get(i)+"</p></html>");
                label5[i].setVerticalAlignment(javax.swing.SwingConstants.TOP);
                label5[i].setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
                label5[i].setForeground(new java.awt.Color(174,3,49));
                label5[i].setFont(myFont3);
                
                label7[i] = new JLabel();
                label7[i].setText("<html> <b>+</b>  Person B : <p> → "+(String) levelReadData.getPersonB().get(i)+"</p></html>");
                label7[i].setVerticalAlignment(javax.swing.SwingConstants.TOP);
                label7[i].setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
                label7[i].setForeground(new java.awt.Color(120,150,240));
                label7[i].setFont(myFont3);

            }
            
            sub_panel_center_center = new JPanel();
            sub_panel_center_center.setBackground(new java.awt.Color(233,231,214));
            sub_panel_center_center.setPreferredSize(new Dimension(360, 900));
            sub_panel_center_center.setLayout(new GridLayout(levelReadData.getPersonA().size()+5,1,0,10));
            
            for (int i = 0 ; i < levelReadData.getPersonA().size() ; i++) {     
                
                sub_panel_center_center.add(label5[i]);
                sub_panel_center_center.add(label7[i]);
                
            }
            
        }else if (levelReadData.getPersonA().size()< levelReadData.getPersonB().size()){
            label5 = new JLabel[levelReadData.getPersonB().size()];
            label7 = new JLabel[levelReadData.getPersonB().size()];
            
            levelReadData.getPersonA().add("<p>_______________________END _____________________(Thank you for using ours app 🥰)");
            
            for (int i = 0 ; i < levelReadData.getPersonB().size() ; i++) {

                label5[i] = new JLabel();
                label5[i].setText("<html> <b>+</b> Person A : <br> → "+(String) levelReadData.getPersonA().get(i)+"</html>");
//                label5[i].setIconTextGap(-5);
                label5[i].setVerticalAlignment(javax.swing.SwingConstants.TOP);
                label5[i].setPreferredSize(new Dimension(50,50));
                label5[i].setForeground(new java.awt.Color(174,3,49));
                label5[i].setFont(myFont3);

                label7[i] = new JLabel();
                label7[i].setText("<html> <b>+</b>  Person B : <br> → "+(String) levelReadData.getPersonB().get(i)+"</html>");
//                label7[i].setIconTextGap(-5);
                label7[i].setVerticalAlignment(javax.swing.SwingConstants.TOP);
                label7[i].setPreferredSize(new Dimension(10,50));
                label7[i].setForeground(new java.awt.Color(120,150,240));
                label7[i].setFont(myFont3);
            }
            sub_panel_center_center = new JPanel();
            sub_panel_center_center.setBackground(new java.awt.Color(233,231,214));
            sub_panel_center_center.setPreferredSize(new Dimension(360, 900));
            sub_panel_center_center.setLayout(new GridLayout(levelReadData.getPersonB().size()+5,1,0,10));
            
            for (int i = 0 ; i < levelReadData.getPersonA().size() ; i++) {

                sub_panel_center_center.add(label5[i]);
                sub_panel_center_center.add(label7[i]);
                
            }
            
        }else if (levelReadData.getPersonA().size() == levelReadData.getPersonB().size()){
            
            label5 = new JLabel[levelReadData.getPersonA().size()];
            label7 = new JLabel[levelReadData.getPersonB().size()];
            
            for (int i = 0 ; i < levelReadData.getPersonB().size() ; i++) {

                label5[i] = new JLabel();
                label5[i].setText("<html> <b>+</b> Person A : <br> → "+(String) levelReadData.getPersonA().get(i)+"</html>");
//                label5[i].setIconTextGap(-5);
                label5[i].setVerticalAlignment(javax.swing.SwingConstants.TOP);
                label5[i].setPreferredSize(new Dimension(50,50));
                label5[i].setForeground(new java.awt.Color(174,3,49));
                label5[i].setFont(myFont3);

                label7[i] = new JLabel();
                label7[i].setText("<html> <b>+</b>  Person B : <br> → "+(String) levelReadData.getPersonB().get(i)+"</html>");
//                label7[i].setIconTextGap(-5);
                label7[i].setVerticalAlignment(javax.swing.SwingConstants.TOP);
                label7[i].setPreferredSize(new Dimension(10,50));
                label7[i].setForeground(new java.awt.Color(120,150,240));
                label7[i].setFont(myFont3);
            }
            sub_panel_center_center = new JPanel();
            sub_panel_center_center.setBackground(new java.awt.Color(233,232,214));
            sub_panel_center_center.setPreferredSize(new Dimension(360, 900));
            sub_panel_center_center.setLayout(new GridLayout(levelReadData.getPersonB().size()+5,1,0,10));
            
            for (int i = 0 ; i < levelReadData.getPersonA().size() ; i++) {

                sub_panel_center_center.add(label5[i]);
                sub_panel_center_center.add(label7[i]);
                
            }
            
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
        sub_panel_center.setBackground(new java.awt.Color(233,231,214));
        sub_panel_center.setLayout(new BorderLayout(0,10));

        
        JScrollPane scroll = new JScrollPane(sub_panel_center,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(10, 80, 380, 570);
        scroll.setBorder(null);

        sub_panel_center.add(sub_panel_center_Top,BorderLayout.NORTH);
        sub_panel_center.add(sub_panel_center_center,BorderLayout.CENTER);
        sub_panel_center.add(sub_panel_center_buttonSubmit,BorderLayout.SOUTH);
        
        each_sub_Button1_1 = new JButton();
        each_sub_Button1_1.setIcon(icon[0]);
        each_sub_Button1_1.setText("Go back");
        each_sub_Button1_1.setBorder(null);
        each_sub_Button1_1.setHorizontalTextPosition(JButton.CENTER);
        each_sub_Button1_1.setVerticalTextPosition(JButton.BOTTOM);
        each_sub_Button1_1.setForeground(Color.WHITE);
        each_sub_Button1_1.setIconTextGap(-10);
        each_sub_Button1_1.addActionListener(this);
        
        each_sub_Button1_2 = new JButton();
        each_sub_Button1_2.setIcon(icon[1]);
        each_sub_Button1_2.setText("Home");
        each_sub_Button1_2.setBorder(null);
        each_sub_Button1_2.setHorizontalTextPosition(JButton.CENTER);
        each_sub_Button1_2.setVerticalTextPosition(JButton.BOTTOM);
        each_sub_Button1_2.setForeground(Color.WHITE);
        each_sub_Button1_2.setIconTextGap(-10);
        each_sub_Button1_2.addActionListener(this);
        
        each_sub_Button1_3 = new JButton();
        each_sub_Button1_3.setText("Profile");
        each_sub_Button1_3.setIcon(icon[2]);
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
        Mainpanel.setBackground(new java.awt.Color(233,231,214));
        Mainpanel.setLayout(null);
        Mainpanel.setSize(400,750);
        
        Mainpanel.add(label);
        
        Mainpanel.add(scroll,BorderLayout.CENTER);
        Mainpanel.add(sub_panel1);
        
        frame = new JFrame("Learn language");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 750);
        frame.setLayout(null);
        frame.setResizable(false);
        
        frame.add(Mainpanel);
        
        frame.setVisible(true);
        
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        
        if(e.getSource() == each_sub_Button1_1 || e.getSource() == each_sub_Button1_2)
        {
            lsc = new levelSubContext("SPANISH", levels, contexts,getemail);
            frame.dispose();
        }
        
        if(e.getSource() == each_sub_Button1_1 )
        {
            System.out.println("poo3");
        }
        
    }
    
}
