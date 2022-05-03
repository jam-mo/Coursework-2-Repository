
package StartedPage;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.sound.sampled.DataLine;
import javax.swing.*;
import javax.swing.event.*;

/**
 *
 * @author kokmeng / christopher
 */

public class SearchPage extends SearchBarData implements ActionListener{
    
    level_language ll;
    
    
    JFrame frame;
    
    JPanel Mainpanel;
    
    JLabel label;
    JPanel sub_panel1;
    
    JPanel PaneSearch;
    
    JPanel SubpaneCenter;
    
    private String getemail;
    
//    JLabel labelContainer;
    
    JList listA1;
    JList listA2;
    JList listB1;
    JList listB2;
    
    JList listA1sc;
    JList listA2sc;
    JList listB1sc;
    JList listB2sc;
    
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
    
    ArrayList <String> getValue1 = new ArrayList<>();
    ArrayList <String> getValue2 = new ArrayList<>();
    ArrayList <String> getValue3 = new ArrayList<>();
    ArrayList <String> getValue4 = new ArrayList<>();
    ArrayList <String> getValue5 = new ArrayList<>();
    ArrayList <String> getValue6 = new ArrayList<>();
    ArrayList <String> getValue7 = new ArrayList<>();
    ArrayList <String> getValue8 = new ArrayList<>();
    
    
    ArrayList <String> StealValue = new ArrayList<>();
    
    JButton each_sub_Button1_1;
    JButton each_sub_Button1_2;
    JButton each_sub_Button1_3;
    
    ImageIcon icon = new ImageIcon("go-back.png");
    ImageIcon icon1 = new ImageIcon("SEarch.png");
    ImageIcon icon2 = new ImageIcon("account.png");
    
    ImageIcon icon3 = new ImageIcon("Search.png");
    
    Font myFont1 = new Font("Rockwell",Font.BOLD,25);
    
    SearchPage(String email){
        
        this.getemail = email;
        
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
        sub_panel1.setBounds(0, 673, 400, 55);
        
        sub_panel1.setLayout(new GridLayout(1,3,10,10));
        
        sub_panel1.add(each_sub_Button1_1);
        sub_panel1.add(each_sub_Button1_2);
        sub_panel1.add(each_sub_Button1_3);
        
//                   labelContainer= new JLabel[100];
                   
//                   for(int i = 0; i < labelContainer.length ; i++){

//                       labelContainer[i].setText("");
//                   }
        
        listA1 = new JList<>();
//        listA1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(java.awt.Color.white, java.awt.Color.gray), "Level_A1_Context", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        listA1.setBorder(javax.swing.BorderFactory.createTitledBorder("Level_A1_Context"));
        listA1.setModel(new javax.swing.AbstractListModel<String>() {

            @Override
            public int getSize() { return list1.size(); }
            @Override
            public String getElementAt(int i) { return list1.get(i); }
        });
        
        listA1.addListSelectionListener((ListSelectionEvent e) -> {
            if(!e.getValueIsAdjusting()){
                System.out.println(listA1.getSelectedValue().toString());
                levelSubContext lsc = new levelSubContext("A1",listA1.getSelectedValue().toString(),email);
                frame.dispose();
            }
        });
        
        listA2 = new JList<>();
        listA2.setBorder(javax.swing.BorderFactory.createTitledBorder("Level_A2_Context"));
        listA2.setModel(new javax.swing.AbstractListModel<String>() {

            @Override
            public int getSize() { return list2.size(); }
            @Override
            public String getElementAt(int i) { return list2.get(i); }
        });
        
        listA2.addListSelectionListener((ListSelectionEvent e) -> {
            if(!e.getValueIsAdjusting()){
                System.out.println(listA2.getSelectedValue().toString());
                levelSubContext lsc = new levelSubContext("A2",listA2.getSelectedValue().toString(),email);
                frame.dispose();
            }
        });
        
        listB1 = new JList<>();
        listB1.setBorder(javax.swing.BorderFactory.createTitledBorder("Level_B1_Context"));
        listB1.setModel(new javax.swing.AbstractListModel<String>() {

            @Override
            public int getSize() { return list3.size(); }
            @Override
            public String getElementAt(int i) { return list3.get(i); }
        });
        listB1.addListSelectionListener((ListSelectionEvent e) -> {
            if(!e.getValueIsAdjusting()){
                System.out.println(listB1.getSelectedValue().toString());
                levelSubContext lsc = new levelSubContext("B1",listB1.getSelectedValue().toString(),email);
                frame.dispose();
            }
        });
        
        listB2 = new JList<>();
        listB2.setBorder(javax.swing.BorderFactory.createTitledBorder("Level_B2_Context"));
        listB2.setModel(new javax.swing.AbstractListModel<String>() {

            @Override
            public int getSize() { return list4.size(); }
            @Override
            public String getElementAt(int i) { return list4.get(i); }
        });
        listB2.addListSelectionListener((ListSelectionEvent e) -> {
            if(!e.getValueIsAdjusting()){
                System.out.println(listB2.getSelectedValue().toString());
                levelSubContext lsc = new levelSubContext("B2",listB2.getSelectedValue().toString(),email);
                frame.dispose();
            }
        });
        
        listA1sc = new JList<>();
        listA1sc.setBorder(javax.swing.BorderFactory.createTitledBorder("Level_A1_Sub_Context"));
        listA1sc.setModel(new javax.swing.AbstractListModel<String>() {

            @Override
            public int getSize() { return list5.size(); }
            @Override
            public String getElementAt(int i) { return list5.get(i); }
        });
        listA1sc.addListSelectionListener((ListSelectionEvent e) -> {
            if(!e.getValueIsAdjusting()){
                System.out.println(listA1sc.getSelectedValue().toString());
                Communication com= new Communication("A1",listA1sc.getSelectedValue().toString(),email );
                frame.dispose();
            }
        });
        
        listA2sc = new JList<>();
        listA2sc.setBorder(javax.swing.BorderFactory.createTitledBorder("Level_A2_Sub_Context"));
        listA2sc.setModel(new javax.swing.AbstractListModel<String>() {

            @Override
            public int getSize() { return list6.size(); }
            @Override
            public String getElementAt(int i) { return list6.get(i); }
        });
        listA2sc.addListSelectionListener((ListSelectionEvent e) -> {
            if(!e.getValueIsAdjusting()){
                System.out.println(listA2sc.getSelectedValue().toString());
                Communication com= new Communication( "A2",listA2sc.getSelectedValue().toString(),email );
                frame.dispose();
            }
        });
        
        listB1sc = new JList<>();
        listB1sc.setBorder(javax.swing.BorderFactory.createTitledBorder("Level_B1_Sub_Context"));
        listB1sc.setModel(new javax.swing.AbstractListModel<String>() {

            @Override
            public int getSize() { return list7.size(); }
            @Override
            public String getElementAt(int i) { return list7.get(i); }
        });
        listB1sc.addListSelectionListener((ListSelectionEvent e) -> {
            if(!e.getValueIsAdjusting()){
                System.out.println(listB1sc.getSelectedValue().toString());
                Communication com= new Communication("B1",listB1sc.getSelectedValue().toString(),email );
                frame.dispose();
            }
        });
        
        listB2sc = new JList<>();
        listB2sc.setBorder(javax.swing.BorderFactory.createTitledBorder("Level_B2_Sub_Context"));
        listB2sc.setModel(new javax.swing.AbstractListModel<String>() {

            @Override
            public int getSize() { return list8.size(); }
            @Override
            public String getElementAt(int i) { return list8.get(i); }
        });
        listB2sc.addListSelectionListener((ListSelectionEvent e) -> {
            if(!e.getValueIsAdjusting()){
                System.out.println(listB2sc.getSelectedValue().toString());
                Communication com= new Communication("B2",listB2sc.getSelectedValue().toString(),email );
                frame.dispose();
            }
        });
        
        SubpaneCenter= new JPanel();
        SubpaneCenter.setBackground(new java.awt.Color(233,231,214));
        SubpaneCenter.setLayout(new GridLayout(8,1,10,10));
        
        SubpaneCenter.add(listA1);
        SubpaneCenter.add(listA2);
        SubpaneCenter.add(listB1);
        SubpaneCenter.add(listB2);
        SubpaneCenter.add(listA1sc);
        SubpaneCenter.add(listA2sc);
        SubpaneCenter.add(listB1sc);
        SubpaneCenter.add(listB2sc);
        
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
           
           getValue1.clear();
           getValue2.clear();
           getValue3.clear();
           getValue4.clear();
           getValue5.clear();
           getValue6.clear();
           getValue7.clear();
           getValue8.clear();
           
           SubpaneCenter.removeAll();
//           
           for(String element : list1){
               
                if (element.toLowerCase().contains(SearchText.getText().toLowerCase().trim())){
                    System.out.println("LEVEL A1 : "+ element);
                    getValue1.add(element);

                    listA1.setModel(new javax.swing.AbstractListModel<String>() {
                        
                        @Override
                        public int getSize() { return getValue1.size(); }
                        @Override
                        public String getElementAt(int i) { return getValue1.get(i); }
                    });
                    
                    SubpaneCenter.add(listA1);
                }
           }
           

            
            for(String element1 : list2){
               if (element1.toLowerCase().contains(SearchText.getText().toLowerCase().trim())){
                    StealValue.add(element1);
                    getValue2.add(element1);

                    listA2.setModel(new javax.swing.AbstractListModel<String>() {
                        
                        @Override
                        public int getSize() { return getValue2.size(); }
                        @Override
                        public String getElementAt(int i) { return getValue2.get(i); }
                    });
                    
                    SubpaneCenter.add(listA2);
               }
            }
            
            for(String element1 : list3){
               if (element1.toLowerCase().contains(SearchText.getText().toLowerCase().trim())){
                   System.out.println("LEVEL B1 : "+element1);
                    StealValue.add(element1);
                    getValue3.clear();
                    getValue3.add(element1);

                    listB1.setModel(new javax.swing.AbstractListModel<String>() {
                        
                        @Override
                        public int getSize() { return getValue3.size(); }
                        @Override
                        public String getElementAt(int i) { return getValue3.get(i); }
                    });
                    
                    SubpaneCenter.add(listB1);
               }
            }
            
            for(String element1 : list4){
               if (element1.toLowerCase().contains(SearchText.getText().toLowerCase().trim())){
                   System.out.println("LEVEL B2 : "+element1);
                    StealValue.add(element1);
                    getValue4.add(element1);

                    listB2.setModel(new javax.swing.AbstractListModel<String>() {
                        
                        @Override
                        public int getSize() { return getValue4.size(); }
                        @Override
                        public String getElementAt(int i) { return getValue4.get(i); }
                    });
                    
                    SubpaneCenter.add(listB2);
                   
               }
            }
            
            for(String element1 : list5){
               if (element1.toLowerCase().contains(SearchText.getText().toLowerCase().trim())){
                   System.out.println("LEVEL A1 - Context: "+element1);
                    StealValue.add(element1);
                    getValue5.add(element1);

                    listA1sc.setModel(new javax.swing.AbstractListModel<String>() {
                        
                        @Override
                        public int getSize() { return getValue5.size(); }
                        @Override
                        public String getElementAt(int i) { return getValue5.get(i); }
                    });
                    
                    SubpaneCenter.add(listA1sc);
               }
            }
            
            for(String element1 : list6){
               if (element1.toLowerCase().contains(SearchText.getText().toLowerCase().trim())){
                   System.out.println("LEVEL A2 - Context: "+element1);
                    StealValue.add(element1);
                    getValue6.add(element1);

                    listA2sc.setModel(new javax.swing.AbstractListModel<String>() {
                        
                        @Override
                        public int getSize() { return getValue6.size(); }
                        @Override
                        public String getElementAt(int i) { return getValue6.get(i); }
                    });
                    
                    SubpaneCenter.add(listA2sc);
               }
            }
            
            for(String element1 : list7){
               if (element1.toLowerCase().contains(SearchText.getText().toLowerCase().trim())){
                   System.out.println("LEVEL B1 - Context: "+element1);
                    StealValue.add(element1);
                    getValue7.add(element1);

                    listB1sc.setModel(new javax.swing.AbstractListModel<String>() {
                        
                        @Override
                        public int getSize() { return getValue7.size(); }
                        @Override
                        public String getElementAt(int i) { return getValue7.get(i); }
                    });
                    
                    SubpaneCenter.add(listB1sc);
               }
            }
            
            for(String element1 : list8){
               if (element1.toLowerCase().contains(SearchText.getText().toLowerCase().trim())){
                   System.out.println("LEVEL B2 - Context: "+element1);
                    StealValue.add(element1);
                    getValue8.add(element1);

                    listB2sc.setModel(new javax.swing.AbstractListModel<String>() {
                        
                        @Override
                        public int getSize() { return getValue8.size(); }
                        @Override
                        public String getElementAt(int i) { return getValue8.get(i); }
                    });
                    
                    SubpaneCenter.add(listB2sc);
               }
            }
            
            
            System.out.println(StealValue);
            
        
       }
       
        if(e.getSource() == each_sub_Button1_1 )
        {
            ll = new level_language(getemail);
            frame.dispose();
        }
        
        if(e.getSource() == each_sub_Button1_2 )
        {
           SearchPage Searchbar  = new SearchPage(getemail);
           frame.dispose();
        }
        
        if(e.getSource() == each_sub_Button1_3 )
        {
            openning opening= new openning();
            frame.dispose();
        }
       
    }
}
