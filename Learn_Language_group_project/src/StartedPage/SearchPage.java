
package StartedPage;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author kokmeng / christopher
 */

public class SearchPage extends readDataforSearch implements ActionListener{
    
    JFrame frame;
    
    JPanel Mainpanel;
    
    JLabel label;
    JPanel sub_panel1;
    
    JPanel PaneSearch;
    
    JTextField SearchText;
    
    JButton SearchButton;
    
    Image img;
    Image newImg;
    
    readDataforSearch rdfs;
    
    ArrayList <String> list = new ArrayList<String>();
    
    JButton each_sub_Button1_1;
    JButton each_sub_Button1_2;
    JButton each_sub_Button1_3;
    
    ImageIcon icon = new ImageIcon("go-back.png");
    ImageIcon icon1 = new ImageIcon("home-page.png");
    ImageIcon icon2 = new ImageIcon("account.png");
    
    ImageIcon icon3 = new ImageIcon("Search.png");
    
    Font myFont1 = new Font("Rockwell",Font.BOLD,25);
    
    SearchPage(){
        
        rdfs = new readDataforSearch();
        rdfs.ReadContect();
        rdfs.ReadSubContect();
        
        for(int i = 0; i < rdfs.copyValue().size(); i++ ){
            list.add((String) rdfs.copyValue().get(i));
        }
        
        
        label = new JLabel();
        label.setText("SEARCH");
        label.setForeground(new java.awt.Color(198,102,104));
        label.setBounds(10, 35, 388, 50);
        label.setFont(myFont1);
        
        SearchText = new JTextField();
        SearchText.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 10));
        SearchText.setBounds(4, 4, 315, 42);
        
        img = icon3.getImage();
        newImg = img.getScaledInstance(35, 35, java.awt.Image.SCALE_SMOOTH);
        icon3 = new ImageIcon(newImg);
        
        SearchButton = new JButton();
        SearchButton.setIcon(icon3);
        SearchButton.setBorder(null);
        SearchButton.setBounds(317, 0, 75, 50);
        SearchButton.addActionListener(this);
        
        PaneSearch = new JPanel();
        PaneSearch.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        PaneSearch.setBounds(5, 70, 390, 50);
        PaneSearch.setLayout(null);
        PaneSearch.setBackground(new java.awt.Color(198,102,104));
        
        PaneSearch.add(SearchText);
        PaneSearch.add(SearchButton);
        
//            icon3  = new ImageIcon();
        
        each_sub_Button1_1 = new JButton("Log out");
        each_sub_Button1_1.setIcon(icon);
        each_sub_Button1_1.setText("LogOut");
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
        Mainpanel.setBackground(new java.awt.Color(233,231,214));
        Mainpanel.setLayout(null);
        Mainpanel.setSize(400,750);
        
        Mainpanel.add(label);
        
        Mainpanel.add(PaneSearch);
//        Mainpanel.add(scroll,BorderLayout.CENTER);
        Mainpanel.add(sub_panel1);
        
        frame = new JFrame("Search");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(400, 750);
        frame.setLayout(null);
        frame.setResizable(false);
        
        frame.add(Mainpanel);
        
        frame.setVisible(true);
    }
    
    public static void main(String[] arg){
        SearchPage sp = new SearchPage();
        
        System.out.println(sp.list);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == SearchButton ){
           
            for (String element : list){
               if (element.toLowerCase().contains(SearchText.getText().toLowerCase().trim())){
                   System.out.println(element);
               }
            }
            
            for(String element : list ){
                
            }
        
       }
    }
}
