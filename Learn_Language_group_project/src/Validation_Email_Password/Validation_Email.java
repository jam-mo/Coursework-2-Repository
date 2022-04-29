/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validation_Email_Password;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author kokmeng / christopher
 */
public class Validation_Email {
   
    public static boolean validationEmail(String input){
        
        String emailRegex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z{2,6}$]";
        Pattern emailPat = Pattern.compile(emailRegex, Pattern.CASE_INSENSITIVE);
        Matcher matcher = emailPat.matcher(input);
        return matcher.find();
    
    }
}
