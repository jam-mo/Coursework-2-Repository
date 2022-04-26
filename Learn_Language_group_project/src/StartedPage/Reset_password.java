
package StartedPage;

import Validation_Email_Password.Validation_Email;
import Validation_Email_Password.Validation_Password;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Reset_password extends ReadDatabase implements ActionListener{
    
    JFrame frame;
    JFrame frame1;
    
    JPanel Mainpanel;
    JPanel Sub_panel;
    
    JLabel label;
    JLabel label1;
    
    JLabel label3;
    JLabel label4;
    
    JLabel label5;
    JLabel label6;
    
    JTextField text1;
    JTextField text2;
    JTextField text3;
    JTextField text4;
    
    JPasswordField text5;
    JPasswordField text6;
    
    JButton buttonSubmit;
    JButton buttonNext;
    JButton buttonNext1;
    JButton buttonNext2;
    
    JButton buttonSubmit1;
    
    JCheckBox checkbox;
    JCheckBox checkbox1;
    
    Font myFont1 = new Font("Arial Rounded MT Bold",Font.BOLD,30);
    Font myFont2 = new Font("Herculanum",Font.BOLD,16);
    Font myFont3 = new Font("Rockwell",Font.PLAIN,13);
    Font myFont4 = new Font("Lucida Grande",Font.PLAIN,16);
    Font myFont5 = new Font("Lucida Grande",Font.PLAIN,14);
    
    ImageIcon icon = new ImageIcon("/Users/kokmeng/Desktop/Coursework-2-Repository/Learn_Language/src/image/eye.png");
    ImageIcon icon1 = new ImageIcon("/Users/kokmeng/Desktop/Coursework-2-Repository/Learn_Language/src/image/hidden.png");
    
    Reset_password(){
        
        text2 = new JTextField();
        text3 = new JTextField();
        
        
        label = new JLabel();
        label.setText("Confirm email");
        label.setForeground(new java.awt.Color(255,51,51));
        label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        label.setBounds(0, 50, 388, 50);
        label.setFont(myFont1);
        
        label1 = new JLabel();
        label1.setText("Email:");
        label1.setForeground(new java.awt.Color(102,102,255));
        label1.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        label1.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        label1.setBounds(10, 160, 388, 50);
        label1.setFont(myFont2);
        
        label3 = new JLabel();
        label3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        label3.setBounds(-50, 330, 388, 30);
        label3.setText("IF you forget you Email Account | ");
        
        label4 = new JLabel();
        label4.setText("Sign Up");
        label4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        label4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        label4.setBounds(100, 330, 388, 30);
        label4.setForeground(new java.awt.Color(51, 51, 255));
        label4.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e)  
            {  
               // you can open a new frame here as
               // i have assumed you have declared "frame" as instance variable
                SignUp signUP = new SignUp();
                frame.dispose();

            }  
        });
        
        text1 = new JTextField(); 
        text1.setForeground(new java.awt.Color(255,51,51));
        text1.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        text1.setBounds(5, 200, 388, 50);
        text1.setFont(myFont3);
        
        text3 = new JTextField(); 
        text3.setForeground(new java.awt.Color(255,51,51));
        text3.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        text3.setBounds(5, 200, 388, 50);
        text3.setFont(myFont3);
        
        buttonSubmit = new JButton();
        buttonSubmit.setText("Submit");
        buttonSubmit.setForeground(new java.awt.Color(153,102,255));
        buttonSubmit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buttonSubmit.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        buttonSubmit.setAlignmentY((float) 0.5);
        buttonSubmit.setBounds(5, 280, 388, 50);
        buttonSubmit.setFont(myFont4);
        buttonSubmit.addActionListener(this);
        
        buttonNext = new JButton();
        buttonNext.setText("Next");
        buttonNext.setForeground(new java.awt.Color(153,102,255));
        buttonNext.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buttonNext.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        buttonNext.setAlignmentY((float) 0.5);
        buttonNext.setBounds(5, 280, 388, 50);
        buttonNext.setFont(myFont4);
        buttonNext.addActionListener(this);
        
        buttonNext1 = new JButton();
        buttonNext1.setText("Next");
        buttonNext1.setForeground(new java.awt.Color(153,102,255));
        buttonNext1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buttonNext1.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        buttonNext1.setAlignmentY((float) 0.5);
        buttonNext1.setBounds(5, 280, 388, 50);
        buttonNext1.setFont(myFont4);
        buttonNext1.addActionListener(this);
        
        buttonNext2 = new JButton();
        buttonNext2.setText("Next");
        buttonNext2.setForeground(new java.awt.Color(153,102,255));
        buttonNext2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        buttonNext2.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
        buttonNext2.setAlignmentY((float) 0.5);
        buttonNext2.setBounds(5, 280, 388, 50);
        buttonNext2.setFont(myFont4);
        buttonNext2.addActionListener(this);
        
        Mainpanel = new JPanel();
        Mainpanel.setOpaque(true);
        Mainpanel.setBackground(new java.awt.Color(238, 238, 237));
        Mainpanel.setLayout(null);
        Mainpanel.setBounds(0, 0, 400, 400);
        
        Mainpanel.add(label);
        Mainpanel.add(label1);
        
        Mainpanel.add(label3);
        Mainpanel.add(label4);
        
        Mainpanel.add(text1);
        Mainpanel.add(buttonSubmit);
        
        frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(400, 400);
        frame.setResizable(false);
        
        frame.add(Mainpanel);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
//    public static void main(String[] arg){
//        Reset_password Rpwd = new Reset_password();
//    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonSubmit){
            String getEmail = text1.getText();
            
                if(getEmail.equalsIgnoreCase("") || getEmail.equalsIgnoreCase(null))
                {
                    JOptionPane.showMessageDialog(null, "Add a Email");
                }else if(Validation_Email.validationEmail(getEmail)==false)
                {
                    JOptionPane.showMessageDialog(null, "Your email need to include "+getEmail+"@Example.com");
                }else{
                    
                    if(ReadSecureEmail(getEmail)==true){
                        JOptionPane.showMessageDialog(null, "Amazing");
                        
                            label1.setText("Why are you Gay");
                            Mainpanel.remove(text1);
                            Mainpanel.remove(buttonSubmit);
                            
                            label.setText("Question_1");
                            
                            text2 = new JTextField(); 
                            text2.setForeground(new java.awt.Color(255,51,51));
                            text2.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
                            text2.setBounds(5, 200, 388, 50);
                            text2.setFont(myFont3);

                            Mainpanel.add(text2);
                           
                            Mainpanel.add(buttonNext);
                           
                            
                    }else{
                        JOptionPane.showMessageDialog(null, "Sorry we cant find email :  "+getEmail+" @Example.com on list");
                    }
                }
        }

        if(e.getSource() == buttonNext ){
            String changeValue = "Question_1";
            String getText = text2.getText();
            String getEmail = text1.getText();

            if(getText.equalsIgnoreCase("") || getText.equalsIgnoreCase(null))
            {
                JOptionPane.showMessageDialog(null, "Please Answer some question");
            }else{
                
                    if(ReadSecureQuestion(changeValue,getText,getEmail)==true){
                        JOptionPane.showMessageDialog(null, "Amazing");
                        
                            label1.setText("Why are you eat my food?");
                            Mainpanel.remove(text2);
                            Mainpanel.remove(buttonNext);
                            
                            label.setText("Question_2");
                            
                            text3 = new JTextField(); 
                            text3.setForeground(new java.awt.Color(255,51,51));
                            text3.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
                            text3.setBounds(5, 200, 388, 50);
                            text3.setFont(myFont3);

                            Mainpanel.add(text3);
                           
                            Mainpanel.add(buttonNext1);
                           
                            
                    }else{
                        JOptionPane.showMessageDialog(null, "Sorry it wrong answer");
                    }
                
            }

        }
       if(e.getSource() == buttonNext1 ){
            String changeValue = "Question_2";
            String getText = text3.getText();
            String getEmail = text1.getText();

            if(getText.equalsIgnoreCase("") || getText.equalsIgnoreCase(null))
            {
                JOptionPane.showMessageDialog(null, "Please Answer some question");
            }else{
                
                    if(ReadSecureQuestion(changeValue,getText,getEmail)==true){
                        JOptionPane.showMessageDialog(null, "Amazing");
                        
                            Mainpanel.remove(text3);
                            Mainpanel.remove(buttonNext1);
                            
                            label1.setText("Why fish live without breath?");
                            
                            label.setText("Question_3");
                            
                            text4 = new JTextField(); 
                            text4.setForeground(new java.awt.Color(255,51,51));
                            text4.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
                            text4.setBounds(5, 200, 388, 50);
                            text4.setFont(myFont3);

                            Mainpanel.add(text4);
                           
                            Mainpanel.add(buttonNext2);
                           
                            
                    }else{
                        JOptionPane.showMessageDialog(null, "Sorry it wrong answer");
                    }
                
            }

        }
       
        if(e.getSource() == buttonNext2 ){
            String changeValue = "Question_3";
            String getText = text4.getText();
            String getEmail = text1.getText();

            if(getText.equalsIgnoreCase("") || getText.equalsIgnoreCase(null))
            {
                JOptionPane.showMessageDialog(null, "Please Answer some question");
            }else{
                
                    if(ReadSecureQuestion(changeValue,getText,getEmail)==true){
                        JOptionPane.showMessageDialog(null, "Amazing");
                            
                            frame.dispose();
                            
                            frame1 = new JFrame();
                        
                            label.setText("New Password");
                            
                            label5 = new JLabel();
                            label5.setText("Password:");
                            label5.setForeground(new java.awt.Color(102,102,255));
                            label5.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
                            label5.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
                            label5.setBounds(10, 100, 388, 50);
                            label5.setFont(myFont2);
                            
                            label6 = new JLabel();
                            label6.setText("Comfire Password:");
                            label6.setForeground(new java.awt.Color(102,102,255));
                            label6.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
                            label6.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
                            label6.setBounds(10, 180, 388, 50);
                            label6.setFont(myFont2);
                            
                            text5 = new JPasswordField(); 
                            text5.setForeground(new java.awt.Color(255,51,51));
                            text5.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
                            text5.setBounds(5, 140, 388, 50);
                            text5.setFont(myFont3);
                            
                            checkbox = new JCheckBox();
                            checkbox.setIcon(icon1);
                            checkbox.setForeground(new java.awt.Color(255,51,51));
                            checkbox.setFocusable(false);
                            checkbox.setBounds(350, 100, 50, 50);
                            checkbox.addActionListener(this);
                            checkbox.setFont(myFont5);
                            
                            text6 = new JPasswordField(); 
                            text6.setForeground(new java.awt.Color(255,51,51));
                            text6.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
                            text6.setBounds(5, 220, 388, 50);
                            text6.setFont(myFont3);
                            
                            checkbox1 = new JCheckBox();
                            checkbox1.setIcon(icon1);
                            checkbox1.setForeground(new java.awt.Color(255,51,51));
                            checkbox1.setFocusable(false);
                            checkbox1.setBounds(350, 180, 50, 50);
                            checkbox1.addActionListener(this);
                            checkbox1.setFont(myFont5);
                            
                            buttonSubmit1 = new JButton();
                            buttonSubmit1.setText("Submit");
                            buttonSubmit1.setForeground(new java.awt.Color(153,102,255));
                            buttonSubmit1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                            buttonSubmit1.setVerticalAlignment(javax.swing.SwingConstants.CENTER);
                            buttonSubmit1.setAlignmentY((float) 0.5);
                            buttonSubmit1.setBounds(5, 280, 388, 50);
                            buttonSubmit1.setFont(myFont4);
                            buttonSubmit1.addActionListener(this);
                            
                            Sub_panel = new JPanel();
                            Sub_panel.setBackground(new java.awt.Color(238, 238, 247));
                            Sub_panel.setOpaque(true);
                            Sub_panel.setLayout(null);
                            Sub_panel.setBounds(0, 0, 400, 400);
                            
                            Sub_panel.add(label);
                            
                            Sub_panel.add(label5);
                            Sub_panel.add(label6);
                            
                            Sub_panel.add(text5);
                            Sub_panel.add(text6);
                            
                            Sub_panel.add(checkbox);
                            Sub_panel.add(checkbox1);
                            
                            Sub_panel.add(buttonSubmit1);
                            
                            frame1 = new JFrame();
                            frame1.setVisible(true);
                            frame1.setSize(400, 400);
                            frame1.setResizable(false);
                            
                            frame1.add(Sub_panel);
                            frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                    }else{
                        JOptionPane.showMessageDialog(null, "Sorry it wrong answer");
                    }
                
            }

        }
        
        if(e.getSource()==checkbox)
        {
            if(checkbox.isSelected())
            {
                checkbox.setIcon(icon);
                text5.setEchoChar((char)0);
                
            }
            else
            {
                checkbox.setIcon(icon1);
                text5.setEchoChar('\u25cf');
                
            }
        }
        
        if(e.getSource()==checkbox1)
        {
            if(checkbox1.isSelected())
            {
                checkbox1.setIcon(icon);
                text6.setEchoChar((char)0);
                
            }
            else
            {
                checkbox1.setIcon(icon1);
                text6.setEchoChar('\u25cf');
                
            }
        }
        
        if(e.getSource() == buttonSubmit1){
            String getPassword = String.valueOf(text5.getPassword());
            String re_getPassword = String.valueOf(text6.getPassword());
            String getEmail = text1.getText();
            
            if(getPassword.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Add a password");
            }
            else if(!getPassword.equals(re_getPassword))
            {
                JOptionPane.showMessageDialog(null, "Your password dont match comfirm password");
            }
            else if(Validation_Password.isSpace(getPassword)==false)
            {
                JOptionPane.showMessageDialog(null, "Please dont use space in password");
            }
            else if(Validation_Password.hasSpecialCharactor(getPassword)==false)
            {
                JOptionPane.showMessageDialog(null, "Your password require Special Charactor");
            }
            else if(Validation_Password.validationPassword(getPassword)==false)
            {
                JOptionPane.showMessageDialog(null, """
                                                    Your password need to include
                                                    At least 8 Characters
                                                    At lease 1 Capital Letter
                                                    At least 1 lower case
                                                    At least 1 number
                                                    """);
            }
            else
            {
                if(changePwd(getEmail,getPassword)==false){
                    JOptionPane.showMessageDialog(null, "Enjoy your New Password");
                    frame1.dispose();
                }else{
                    
                }
            }
            
        }
        
        
    }
 
}
