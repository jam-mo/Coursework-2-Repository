/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StartedPage;

public class student_user {
    
    private String firstName;
    private String lastName;
    private String email;
    private String userName;
    
    student_user(String un, String fn, String ln, String em){
        this.userName = un;
        this.firstName = fn;
        this.lastName = ln;
        this.email = em;
    }

    String getUName() {
        return userName;
    }
    String getFName(){
        return firstName;
    }
    
    String getLName(){
        return lastName;
    }
    
    String getemail(){
        return email;
    }
    
}
