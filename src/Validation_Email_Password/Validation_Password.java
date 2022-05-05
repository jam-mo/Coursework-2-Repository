/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Validation_Email_Password;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author kokmeng /Abdullahi
 */

public class Validation_Password {
    
    public static boolean validationPassword(String password){ //checks for password length, must be equal or more than 8 characters
        if(password.length() > 7){
            
            if(checkPass(password)){
                return true;
            }
            else{
                return false;
            }
            
        }else{
            return false;
        }
    }
    
    private static boolean checkPass(String password){ //checks for at least 1 capital letter, 1 lower case letter and 1 number
        
        boolean hasNum = false;
        boolean hasCap = false;
        boolean hasLow = false;
        char c;
        
        for(int i = 0; i < password.length(); i++){
            
            c = password.charAt(i);
            
            if(Character.isDigit(c)){
                hasNum = true;
            }else if(Character.isUpperCase(c)){
                hasCap = true;
            }else if(Character.isLowerCase(c)){
                hasLow = true;
            }if(hasNum && hasCap && hasLow){
                return true;
            } 
        }
        
        return false;
    }
    
    public static boolean isSpace(String password)
    { // check for no Space
        
        for(char currentChar : password.toCharArray()){
            
            if(Character.isWhitespace(currentChar))
            {
                return false;
            }
            
        }
        
        return true;
    }
    
    public static boolean hasSpecialCharactor(String password)
    {  //checks for SpecialCharactor
        
        Pattern sPattern = Pattern.compile("[a-zA-Z0-9]*");
        Matcher sMatcher = sPattern.matcher(password);
        
        if(!sMatcher.matches()){
            return true;
        }
        
        return false;
    }
    
}
