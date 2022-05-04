/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StartedPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


/**
 *
 * @author kokmeng
 */
public class profilePage implements ActionListener{
    JFrame frame;
    
    ReadProfile Rp = new ReadProfile();
    
    SearchPage  Searchbar;
    
    level_language ll2;
    
    String getemail;
    
    JPanel Mainpanel;
    
    JPanel sub_panel_center;
    
    JPanel sub_panel1;
    
    JLabel label;
    
    JPanel sub_panel_center_Top;
    
    JLabel label_top;
    
    JPanel Panel_top;
    JPanel Panel_top1;
    
    JButton panel_button_top;
    JTextField panel_Text_top;
    
    JLabel label_top1;
    
    JLabel label_top2;
    
    JLabel label_top3;
    
    JPanel sub_panel_center_center;
    JPanel sub_panel_center_center1;
    JTable sub_table_center_center2;
    JScrollPane scrolls;
    
    JButton sub_panel_center_button_logout;
    
    JButton each_sub_Button1_1;
    JButton each_sub_Button1_2;
    JButton each_sub_Button1_3;
    
    Image img;
    Image newImg;
    ImageIcon[] icon = new ImageIcon[3];
    
    Font myFont1 = new Font("Arial Rounded MT Bold",Font.BOLD,30);
    Font myFont2 = new Font("Herculanum",Font.BOLD,16);
    Font myFont3 = new Font("Rockwell",Font.PLAIN,13);
    Font myFont4 = new Font("Lucida Grande",Font.PLAIN,16);
    Font myFont5 = new Font("Lucida Grande",Font.PLAIN,14);
    
    profilePage(String email){
        
        getemail = email;
        
        Rp.ReadProfile(email);
        Rp.ReadFirstName(email);
        Rp.ReadLastName(email);
        Rp.ReadEmail(email);
        
        icon[0] = new ImageIcon("go-back.png");
        icon[1] = new ImageIcon("Search.png");
        icon[2] = new ImageIcon("account.png");
        
        label = new JLabel();
        label.setText("Profile");
        label.setForeground(new java.awt.Color(198,102,104));
        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        label.setBounds(0, 20, 388, 50);
        label.setFont(myFont1);
        
        label_top3 = new JLabel("<html><b>User Name :</b> " + Rp.getuser()+"</html>"); // put user Name
        
        label_top = new JLabel("<html><b>Last Name :</b>  "+ Rp.getLastName()+"</html>"); // put Last Name 
        
        label_top1 = new JLabel("<html><b>First Name :</b>  "+ Rp.getFirstName()+"</html>");  // put First Name
        
        Panel_top = new JPanel();
        Panel_top.setBackground(Color.WHITE);
        Panel_top.setPreferredSize(new Dimension(360, 230));
        Panel_top.setLayout(new GridLayout(1,2,0,0));
        
        Panel_top.add(label_top);
        Panel_top.add(label_top1);
        
        label_top2 = new JLabel("<html><b>Email Address : </b>"+ Rp.getemail()+"</html>");
        
        panel_button_top = new JButton("Submit Code");
        
        panel_Text_top = new JTextField();
        
        Panel_top1 = new JPanel();
        Panel_top1.setBackground(Color.getHSBColor(255, 204, 204));
        Panel_top1.setPreferredSize(new Dimension(360, 230));
        Panel_top1.setLayout(new GridLayout(1,2,10,10));
        
        Panel_top1.add(panel_button_top);
        Panel_top1.add(panel_Text_top);
        
        sub_panel_center_Top = new JPanel();
        sub_panel_center_Top.setBackground(Color.WHITE);
        sub_panel_center_Top.setPreferredSize(new Dimension(360, 230));
        sub_panel_center_Top.setLayout(new GridLayout(4,1,10,10));
        
        sub_panel_center_Top.add(label_top3);
        sub_panel_center_Top.add(Panel_top);
        sub_panel_center_Top.add(label_top2);
        sub_panel_center_Top.add(Panel_top1);
        
        sub_panel_center_center1 = new JPanel(); // resizeable
        sub_panel_center_center1.setBackground(new java.awt.Color(120,205,155));
        sub_panel_center_center1.setPreferredSize(new Dimension(360, 600));
        sub_panel_center_center1.setLayout(new GridLayout(1,1,0,10));
        
        String[] columns = {"Login time","Logout time"};
        
        String[][] data = {{"12/12/12","12/12/12"},{"12/12/12","12/12/12"}};
        
        sub_table_center_center2 = new JTable(data,columns);
        sub_table_center_center2.setBackground(new java.awt.Color(255,255,255));
        sub_table_center_center2.setPreferredScrollableViewportSize(new Dimension(360, 370));
        sub_table_center_center2.setFillsViewportHeight(true);
                
        scrolls = new JScrollPane(sub_table_center_center2);
        
        
        sub_panel_center_center = new JPanel(); // resizeable
        sub_panel_center_center.setBackground(Color.getHSBColor(255, 204, 204));
        sub_panel_center_center.setPreferredSize(new Dimension(360, 1000));
        sub_panel_center_center.setLayout(new BorderLayout());
        
        sub_panel_center_center.add(sub_panel_center_center1,BorderLayout.NORTH);
        sub_panel_center_center.add(scrolls,BorderLayout.SOUTH);
        
        sub_panel_center_button_logout = new JButton();
        sub_panel_center_button_logout.setPreferredSize(new Dimension(360, 50));
        sub_panel_center_button_logout.setLayout(new BorderLayout());
        
        sub_panel_center_button_logout.setText("Log Out");
        sub_panel_center_button_logout.setForeground(new java.awt.Color(153,102,255));
        sub_panel_center_button_logout.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sub_panel_center_button_logout.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        sub_panel_center_button_logout.addActionListener(this);
        
        sub_panel_center= new JPanel();
        sub_panel_center.setBackground(Color.getHSBColor(255, 204, 204));
        sub_panel_center.setLayout(new BorderLayout(0,0));

        
        JScrollPane scroll = new JScrollPane(sub_panel_center,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(10, 80, 380, 570);
        scroll.setBorder(null);
        
        sub_panel_center.add(sub_panel_center_Top,BorderLayout.NORTH);
        sub_panel_center.add(sub_panel_center_center,BorderLayout.CENTER);
        sub_panel_center.add(sub_panel_center_button_logout,BorderLayout.SOUTH);
        
        img = icon[0].getImage();
        newImg = img.getScaledInstance(45, 45, java.awt.Image.SCALE_SMOOTH);
        icon[0] = new ImageIcon(newImg);
        
        each_sub_Button1_1 = new JButton();
        each_sub_Button1_1.setIcon(icon[0]);
        each_sub_Button1_1.setText("Go back");
        each_sub_Button1_1.setBorder(null);
        each_sub_Button1_1.setHorizontalTextPosition(JButton.CENTER);
        each_sub_Button1_1.setVerticalTextPosition(JButton.BOTTOM);
        each_sub_Button1_1.setForeground(Color.WHITE);
        each_sub_Button1_1.setIconTextGap(-10);
        each_sub_Button1_1.addActionListener(this);
        
        
        img = icon[1].getImage();
        newImg = img.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
        icon[1] = new ImageIcon(newImg);
        
        each_sub_Button1_2 = new JButton();
        each_sub_Button1_2.setIcon(icon[1]);
        each_sub_Button1_2.setText("Search");
        each_sub_Button1_2.setBorder(null);
        each_sub_Button1_2.setHorizontalTextPosition(JButton.CENTER);
        each_sub_Button1_2.setVerticalTextPosition(JButton.BOTTOM);
        each_sub_Button1_2.setForeground(Color.WHITE);
        each_sub_Button1_2.setIconTextGap(-10);
        each_sub_Button1_2.addActionListener(this);
        
        img = icon[2].getImage();
        newImg = img.getScaledInstance(45, 45, java.awt.Image.SCALE_SMOOTH);
        icon[2] = new ImageIcon(newImg);
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
        Mainpanel.setBackground(Color.getHSBColor(255, 204, 204));
        Mainpanel.setLayout(null);
        Mainpanel.setSize(400,750);
        
        Mainpanel.add(label);
        
        Mainpanel.add(scroll,BorderLayout.CENTER);
        Mainpanel.add(sub_panel1);
        
        frame = new JFrame("SignIn");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 750);
        frame.setLayout(null);
        frame.setResizable(false);
        
        frame.add(Mainpanel);
        
        frame.setVisible(true);
    }
    
    public static void main(String[] arg){
        profilePage p = new profilePage("Monster12@student.com");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if( e.getSource() == sub_panel_center_button_logout){
            SignIn si = new SignIn();
            userActivity userAct = new userActivity();
            userAct.userLogouttime(getemail);
            
            frame.dispose();
        }
        
        if(e.getSource() == each_sub_Button1_1)
        {
            ll2 = new level_language(getemail);
            frame.dispose();
        }
        
        if(e.getSource() == each_sub_Button1_2)
        {
           Searchbar  = new SearchPage(getemail);
           frame.dispose();
        }
        
        
        if(e.getSource() == each_sub_Button1_3 )
        {
            profilePage Pg= new profilePage(getemail);
            frame.dispose();
        }
        
    }
    
}
