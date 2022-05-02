/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adminpage;

/**
 *
 * @author ridwan
 */
public class User {
    private int user_ID;
    private String firstName, lastName;
    
    public User(int user_ID, String firstName, String lastName){
        this.user_ID = user_ID;
        this.firstName = firstName;
        this.lastName = lastName;
       
    }
    
    public int getuserID(){
        return user_ID;
    }
    
    public String getfirstName(){
        return firstName;
    }
    
    public String getlastName(){
        return lastName;
    }
    

}
