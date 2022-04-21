/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StartedPage;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import javax.swing.*;
import jdbacApi.connectDB;

/**
 *
 * @author kokmeng
 */
public class level_language implements ActionListener {
    
    Connection con = connectDB.getConnection();
    Statement stmt = null;
    
    JFrame frame;
    
    JPanel Mainpanel;
    
    JPanel sub_panel;
    JPanel sub_panel1;
    
    JPanel[] each_sub_panel1 = new JPanel[4];
    
    JPanel[] each_sub_panel1_1 = new JPanel[4];
    
    JLabel[] each_sub_label1_1 = new JLabel[4];
    
    JButton each_sub_Button1_1;
    JButton each_sub_Button1_2;
    JButton each_sub_Button1_3;
    
    JLabel label;
    JLabel label1;
    JLabel label2;
    
    JLabel label3;
    
    ArrayList getText = new ArrayList();
    
    ImageIcon icon = new ImageIcon("/Users/kokmeng/Desktop/Coursework-2-Repository/Learn_Language/src/image/logout.png");
    ImageIcon icon1 = new ImageIcon("/Users/kokmeng/Desktop/Coursework-2-Repository/Learn_Language/src/image/home-page.png");
    ImageIcon icon2 = new ImageIcon("/Users/kokmeng/Desktop/Coursework-2-Repository/Learn_Language/src/image/account.png");
    
    Font myFont1 = new Font("Bradley hand",Font.BOLD,25);
    Font myFont2 = new Font("Herculanum",Font.BOLD,16);
    Font myFont3 = new Font("Rockwell",Font.PLAIN,13);
    Font myFont4 = new Font("Lucida Grande",Font.PLAIN,16);
    Font myFont5 = new Font("Lucida Grande",Font.PLAIN,14);
    
    level_language(){
        
        label = new JLabel();
        label.setText("Choose Level of Spainese");
        label.setForeground(new java.awt.Color(255,51,51));
        label.setBounds(10, 35, 388, 50);
        label.setFont(myFont1);
        
        for(int i = 0; i < each_sub_panel1.length; i++){
            
            
            each_sub_panel1[i] = new JPanel();
            each_sub_panel1[i].setBackground(new java.awt.Color(160+i+22+i,14*i,35*i));
            each_sub_panel1[i].setLayout(new BorderLayout());
            
            each_sub_panel1_1[i] = new JPanel();
            each_sub_panel1_1[i].setPreferredSize(new Dimension(50,50));
            each_sub_panel1_1[i].setLayout(new BorderLayout());
            
            
            each_sub_panel1_1[i].setBackground(new java.awt.Color(255, 255, 255));
            
            each_sub_panel1[i].add(each_sub_panel1_1[i],BorderLayout.SOUTH);
            
            each_sub_label1_1[i] = new JLabel();
            each_sub_label1_1[i].setForeground(new java.awt.Color(153,102,255));
            each_sub_label1_1[i].setPreferredSize(new Dimension(50,50));
            
            each_sub_panel1_1[i].add(each_sub_label1_1[i],BorderLayout.SOUTH);
            
        }
        
        sub_panel = new JPanel();
        sub_panel.setBackground(Color.getHSBColor(255, 204, 204));
        sub_panel.setLayout(new GridLayout(4,1,2,5));
        sub_panel.setBounds(10, 80, 380, 590);
            
        for(int i = 0; i < each_sub_panel1.length ; i++ ){
            sub_panel.add(each_sub_panel1[i]);
        }
        
        each_sub_Button1_1 = new JButton();
        each_sub_Button1_1.setIcon(icon);
        each_sub_Button1_1.setBorder(null);
        
        
        each_sub_Button1_2 = new JButton();
        each_sub_Button1_2.setIcon(icon1);
        each_sub_Button1_2.setBorder(null);
        
        each_sub_Button1_3 = new JButton();
        each_sub_Button1_3.setIcon(icon2);
        each_sub_Button1_3.setBorder(null);
        
        sub_panel1 = new JPanel();
        sub_panel1.setBackground(new java.awt.Color(23, 213, 164));
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
        
        Mainpanel.add(sub_panel,BorderLayout.CENTER);
        Mainpanel.add(sub_panel1);
        
        frame = new JFrame("ChooseLevelSpainese");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 750);
        frame.setLayout(null);
        frame.setResizable(false);
        
        frame.add(Mainpanel);
        
        frame.setVisible(true);
        
    }
    
    public void changetext(String student){
        
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT l.Language_level FROM STUDENT_USER su JOIN LEVELS l ON su.user_ID=l.user_ID AND su.user_ID='"+student+"' ;");
            
            while (rs.next()) {
                
                int numColumns = rs.getMetaData().getColumnCount();

                for (int i = 1; i <= numColumns; i++) {
                    System.out.print(rs.getObject(i));
                    
                    getText.add(rs.getObject(i));
                    System.out.println(getText);
                }
                System.out.println("");
                
            }
            
            for(int i = 0; i < each_sub_label1_1.length ; i++ ){
                each_sub_label1_1[i].setText("   "+(String) getText.get(i));
            }

        rs.close();
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
    
    public static void main(String[] arg){
        level_language eachLevel = new level_language();
        String student = "110001";
        eachLevel.changetext(student);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
    
    
}
