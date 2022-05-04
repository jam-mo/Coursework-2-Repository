package StartedPage;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.*;
import javadb.*;

public class levelcontext implements ActionListener{
    
    Connection con = ConnectingDB.connect();
    Statement stmt = null;
    
    JFrame frame;
    
    ArrayList getText = new ArrayList();
    
    JPanel Mainpanel;
    
    JPanel sub_panel;
    JPanel sub_panel1;
    
    JPanel[] sub_panel_1 = new JPanel[11];
    JPanel[] sub_panel_1_1 = new JPanel[11];
    
    JButton sub_Button1_1;
    JButton sub_Button1_2;
    JButton sub_Button1_3;
    
    JLabel label;
    JLabel[] label1 = new JLabel[11];
    
    Font myFont1 = new Font("Bradley hand",Font.BOLD,25);
    Font myFont2 = new Font("Herculanum",Font.BOLD,16);
    Font myFont3 = new Font("Rockwell",Font.PLAIN,13);
    Font myFont4 = new Font("Lucida Grande",Font.PLAIN,16);
    Font myFont5 = new Font("Lucida Grande",Font.PLAIN,14);
    
    ImageIcon icon = new ImageIcon("/Users/kokmeng/Desktop/Coursework-2-Repository/Learn_Language/src/image/go-back.png");
    ImageIcon icon1 = new ImageIcon("/Users/kokmeng/Desktop/Coursework-2-Repository/Learn_Language/src/image/home-page.png");
    ImageIcon icon2 = new ImageIcon("/Users/kokmeng/Desktop/Coursework-2-Repository/Learn_Language/src/image/account.png");
    
    levelContext(){
        
        label = new JLabel();
        label.setText("Context");
        label.setForeground(new java.awt.Color(255,51,51));
        label.setBounds(10, 35, 388, 50);
        label.setFont(myFont1);
        
        for(int i = 0; i < sub_panel_1.length ; i++ ){
            sub_panel_1[i] =  new JPanel();
            sub_panel_1[i].setBackground(new java.awt.Color(200+i/2,20*i,228+i));
            sub_panel_1[i].setLayout(new BorderLayout());
            
            sub_panel_1_1[i] =  new JPanel();
            sub_panel_1_1[i].setBackground(new java.awt.Color(255, 255, 255));
            sub_panel_1_1[i].setPreferredSize(new Dimension(50,50));
            sub_panel_1_1[i].setLayout(new BorderLayout());
            sub_panel_1[i].add(sub_panel_1_1[i],BorderLayout.SOUTH);
            

            
        }
        
        for(int i = 0; i < label1.length ; i++ ){
            label1[i] = new JLabel();
            label1[i].setForeground(new java.awt.Color(0,0,0));
            label1[i].setPreferredSize(new Dimension(50,50));
            
            sub_panel_1_1[i].add(label1[i],BorderLayout.SOUTH);
        }
        
        sub_panel = new JPanel();
        sub_panel.setBackground(Color.getHSBColor(255, 204, 204));
        sub_panel.setLayout(new GridLayout(11,1,5,5));
        sub_panel.setPreferredSize(new Dimension(380,1500));
        
        JScrollPane scroll = new JScrollPane(sub_panel,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(10, 80, 380, 590);
        scroll.setBorder(null);
        
        for(int i = 0; i < sub_panel_1.length ; i++ ){
            sub_panel.add(sub_panel_1[i]);
        }
        
        
        sub_panel1 = new JPanel();
        sub_panel1.setBackground(new java.awt.Color(23, 213, 164));
        sub_panel1.setBounds(0, 674, 400, 55);
        
        sub_Button1_1 = new JButton();
        sub_Button1_2 = new JButton();
        sub_Button1_3 = new JButton();
        
        sub_Button1_1.setIcon(icon);
        sub_Button1_2.setIcon(icon1);
        sub_Button1_3.setIcon(icon2);
        
        sub_Button1_1.setBorder(null);
        sub_Button1_2.setBorder(null);
        sub_Button1_3.setBorder(null);
        
        sub_Button1_1.addActionListener(this);
        sub_Button1_2.addActionListener(this);
        sub_Button1_3.addActionListener(this);
        
        sub_panel1.setLayout(new GridLayout(1,3,10,10));
        sub_panel1.add(sub_Button1_1);
        sub_panel1.add(sub_Button1_2);
        sub_panel1.add(sub_Button1_3);
        
        
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
        
    public static void main(String[] arg){
        levelContext levelContext = new levelContext();
        levelContext.changetext();
    }
    
    public void changetext(){
    
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT c.CONTEXT FROM LEVELS l JOIN CONTEXT c ON l.difficulty_ID =c.difficulty_ID AND l.difficulty_ID ='101010';");
            int n = 0;
            while (rs.next()) {
                
                int numColumns = rs.getMetaData().getColumnCount();
                
                n++;

                for (int i = 1; i <= numColumns; i++) {
                    System.out.print(rs.getObject(i));
                    
                    getText.add(rs.getObject(i));
                    System.out.println(getText);
                }
                System.out.println("");
            }
        rs.close();
        
            for(int i = 0; i < label1.length ; i++ ){
                label1[i].setText("  "+ (String) getText.get(i));
            }
        
        } catch (SQLException ex) {
        System.err.println("SQLException: " + ex.getMessage());
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
        }
    
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}