
package StartedPage;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author kokmeng / christopher
 */

public class SearchPage extends SearchBarData implements ActionListener{
    
    JFrame frame;
    
    JPanel Mainpanel;
    
    JLabel label;
    JPanel sub_panel1;
    
    JPanel PaneSearch;
    
    JPanel SubpaneCenter;
    
    JLabel[] labelContainer;
    
    JTextField SearchText;
    
    JButton SearchButton;
    
    Image img;
    Image newImg;
    
    SearchBarData sbd;
    
    ArrayList <String> list1 = new ArrayList<>();
    ArrayList <String> list2 = new ArrayList<>();
    ArrayList <String> list3 = new ArrayList<>();
    ArrayList <String> list4 = new ArrayList<>();
    ArrayList <String> list5 = new ArrayList<>();
    ArrayList <String> list6 = new ArrayList<>();
    ArrayList <String> list7 = new ArrayList<>();
    ArrayList <String> list8 = new ArrayList<>();
    
    ArrayList <String> StealValue = new ArrayList<>();
    
    JButton each_sub_Button1_1;
    JButton each_sub_Button1_2;
    JButton each_sub_Button1_3;
    
    ImageIcon icon = new ImageIcon("go-back.png");
    ImageIcon icon1 = new ImageIcon("home-page.png");
    ImageIcon icon2 = new ImageIcon("account.png");
    
    ImageIcon icon3 = new ImageIcon("Search.png");
    ImageIcon icon4 = new ImageIcon("Search1.png");
    
    Font myFont1 = new Font("Rockwell",Font.BOLD,25);
    
    SearchPage(String email){
        
        sbd = new SearchBarData();
        
        sbd.ReadContextA1();
        sbd.ReadContextA2();
        sbd.ReadContextB1();
        sbd.ReadContextB2();
        
        sbd.ReadSubContextA1();
        sbd.ReadSubContextA2();
        sbd.ReadSubContextB1();
        sbd.ReadSubContextB2();
        
        for(int i = 0; i < sbd.CopyContextA1().size() ; i++){
            list1.add((String)sbd.CopyContextA1().get(i));
        }
        
        for(int i = 0; i < sbd.CopyContextA2().size() ; i++){
            list2.add((String)sbd.CopyContextA2().get(i));
        }
        
        for(int i = 0; i < sbd.CopyContextB1().size() ; i++){
            list3.add((String)sbd.CopyContextB1().get(i));
        }
        for(int i = 0; i < sbd.CopyContextB2().size() ; i++){
            list4.add((String)sbd.CopyContextB2().get(i));
        }
        
        for(int i = 0; i < sbd.CopySubValueA1().size() ; i++){
            list5.add((String)sbd.CopySubValueA1().get(i));
        }
        
        for(int i = 0; i < sbd.CopySubValueA2().size() ; i++){
            list6.add((String)sbd.CopySubValueA2().get(i));
        }
        
        for(int i = 0; i < sbd.CopySubValueB1().size() ; i++){
            list7.add((String)sbd.CopySubValueB1().get(i));
        }
        for(int i = 0; i < sbd.CopySubValueB2().size() ; i++){
            list8.add((String)sbd.CopySubValueB2().get(i));
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
        
        img = icon4.getImage();
        newImg = img.getScaledInstance(35, 35, java.awt.Image.SCALE_SMOOTH);
        icon4 = new ImageIcon(newImg);
        
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

        
        each_sub_Button1_1 = new JButton();
        each_sub_Button1_1.setIcon(icon);
        each_sub_Button1_1.setText("Go bAck");
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
        
        SubpaneCenter= new JPanel();
        SubpaneCenter.setBackground(new java.awt.Color(255,255,255));
        SubpaneCenter.setLayout(new GridLayout());

        
        JScrollPane scroll = new JScrollPane(SubpaneCenter,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(5, 130, 390, 535);
        scroll.setBorder(null);
            
        Mainpanel = new JPanel();
        Mainpanel.setBackground(new java.awt.Color(233,231,214));
        Mainpanel.setLayout(null);
        Mainpanel.setSize(400,750);
        
        Mainpanel.add(label);
        
        Mainpanel.add(PaneSearch);
        Mainpanel.add(scroll,BorderLayout.CENTER);
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
        SearchPage sp = new SearchPage("email");
        
        System.out.println(sp.list1);
        System.out.println(sp.list2);
        System.out.println(sp.list3);
        System.out.println(sp.list4);
        System.out.println(sp.list5);
        System.out.println(sp.list6);
        System.out.println(sp.list7);
        System.out.println(sp.list8);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == SearchButton ){
           
           
           StealValue.clear();
           
            for(String element1 : list1){
               if (element1.toLowerCase().contains(SearchText.getText().toLowerCase().trim())){
                   System.out.println("LEVEL A1 : "+ element1);
                   labelContainer = new JLabel[element1.length()];
                   for(int i = 0 ; i < labelContainer.length; i++)
                   {
                       labelContainer[i] = new JLabel();
                       labelContainer[i].setText("Level A1 : " + element1);
                       
                       SubpaneCenter.add(labelContainer[i]);
                   }
                   
                   
                   StealValue.add(element1);
                   
                   
               }
            }
            
            for(String element1 : list2){
               if (element1.toLowerCase().contains(SearchText.getText().toLowerCase().trim())){
                   System.out.println("LEVEL A2 : "+ element1);
                   labelContainer = new JLabel[element1.length()];
                   for(int i = 0 ; i < labelContainer.length; i++)
                   {
                       labelContainer[i] = new JLabel();
                       labelContainer[i].setText("Level A2 : " + element1);
                       
                       SubpaneCenter.add(labelContainer[i]);
                   }
                   
                   StealValue.add(element1);
               }
            }
            
            for(String element1 : list3){
               if (element1.toLowerCase().contains(SearchText.getText().toLowerCase().trim())){
                   System.out.println("LEVEL B1 : "+element1);
                   labelContainer = new JLabel[element1.length()];
                   for(int i = 0 ; i < labelContainer.length; i++)
                   {
                       labelContainer[i] = new JLabel();
                       labelContainer[i].setText("Level B2 : " + element1);
                       
                       SubpaneCenter.add(labelContainer[i]);
                   }
                   
                   StealValue.add(element1);
               }
            }
            
            for(String element1 : list4){
               if (element1.toLowerCase().contains(SearchText.getText().toLowerCase().trim())){
                   System.out.println("LEVEL B2 : "+element1);
                   labelContainer = new JLabel[element1.length()];
                   for(int i = 0 ; i < labelContainer.length; i++)
                   {
                       labelContainer[i] = new JLabel();
                       labelContainer[i].setText("Level A1 : " + element1);
                       
                       SubpaneCenter.add(labelContainer[i]);
                   }
                   
                   StealValue.add(element1);
                   
               }
            }
            
            for(String element1 : list5){
               if (element1.toLowerCase().contains(SearchText.getText().toLowerCase().trim())){
                   System.out.println("LEVEL A1 - Context: "+element1);
                   labelContainer = new JLabel[element1.length()];                   
                   for(int i = 0 ; i < labelContainer.length; i++)
                   {
                       labelContainer[i] = new JLabel();
                       labelContainer[i].setText("Level A1 : " + element1);
                       
                       SubpaneCenter.add(labelContainer[i]);
                   }
                   
                   StealValue.add(element1);
               }
            }
            
            for(String element1 : list6){
               if (element1.toLowerCase().contains(SearchText.getText().toLowerCase().trim())){
                   System.out.println("LEVEL A2 - Context: "+element1);
                   labelContainer = new JLabel[element1.length()];
                   for(int i = 0 ; i < labelContainer.length; i++)
                   {
                       labelContainer[i] = new JLabel();
                       labelContainer[i].setText("Level A1 : " + element1);
                       
                       SubpaneCenter.add(labelContainer[i]);
                   }
                   
                   StealValue.add(element1);
               }
            }
            
            for(String element1 : list7){
               if (element1.toLowerCase().contains(SearchText.getText().toLowerCase().trim())){
                   System.out.println("LEVEL B1 - Context: "+element1);
                   labelContainer = new JLabel[element1.length()];
                    for(int i = 0 ; i < labelContainer.length; i++)
                   {
                       labelContainer[i] = new JLabel();
                       labelContainer[i].setText("Level A1 : " + element1);
                       
                       SubpaneCenter.add(labelContainer[i]);
                   }
                   
                   StealValue.add(element1);
               }
            }
            
            for(String element1 : list8){
               if (element1.toLowerCase().contains(SearchText.getText().toLowerCase().trim())){
                   System.out.println("LEVEL B2 - Context: "+element1);
                   labelContainer = new JLabel[element1.length()];
                   for(int i = 0 ; i < labelContainer.length; i++)
                   {
                       labelContainer[i] = new JLabel();
                       labelContainer[i].setText("Level A1 : " + element1);
                       
                       SubpaneCenter.add(labelContainer[i]);
                   }
                   
                   StealValue.add(element1);
               }
            }
            
            
            System.out.println(StealValue);
            
        
       }
       
    }
}
