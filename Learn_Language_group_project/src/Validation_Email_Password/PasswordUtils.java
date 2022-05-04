package Validation_Email_Password;


import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
 
/**
 *
 * @author kokmeng / christopher /jamie / abdullahi
 */

public class PasswordUtils {
    
    private static final Random RANDOM = new SecureRandom();
    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int ITERATIONS = 10000;
    private static final int KEY_LENGTH = 256;
    
     public static String getSalt(int length) {  
        StringBuilder returnValue = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));   //random ALPHABET string and length
        }
        return new String(returnValue);
    }
    public static byte[] hash(char[] password, byte[] salt) {
        PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
        Arrays.fill(password, Character.MIN_VALUE);
        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            return skf.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
        } finally {
            spec.clearPassword();
        }
    }
    public static String generateSecurePassword(String password, String salt) {
        String returnValue = null;
        byte[] securePassword = hash(password.toCharArray(), salt.getBytes());
 
        returnValue = Base64.getEncoder().encodeToString(securePassword);
 
        return returnValue;
    }
    
    public static boolean verifyUserPassword(String providedPassword,String securedPassword, String salt)
    {
        boolean returnValue = false;
        
        // Generate New secure password with the same salt
        String newSecurePassword = generateSecurePassword(providedPassword, salt);
        // Check if two passwords are equal
        returnValue = newSecurePassword.equalsIgnoreCase(securedPassword);
        
        return returnValue;
    }
//    
    public static void main(String[] args)
    {

        // User provided password to validate
        String providedPassword = "123456789";
                
        // Encrypted and Base64 encoded password read from database
        String salt = "3oMDBTwGEpSGtrzFbPqAMySq8nayhZ";
        
        // Salt value stored in database 
//        String salt = "EqdmPh53c9x33EygXpTpcoJvc4VXLK";
        String securePassword = "/3CDGV2drpnbatCSHMCiHncwpaG+XodO6qJ+JFRqj4c=";
        
        boolean passwordMatch = PasswordUtils.verifyUserPassword(providedPassword, securePassword, salt);
        
        if(passwordMatch) 
        {
            System.out.println("Provided user password " + providedPassword + " is correct.");
        } else {
            System.out.println("Provided password is incorrect");
        }
        
//        
//        System.out.println("-----++++++--------");
//        String providedPassword1 = "123456789123489";
//        
//        String salt1 = PasswordUtils.getSalt(30);
//        
//        String securePassword1 = PasswordUtils.generateSecurePassword(providedPassword1, salt1);
//        
//        System.out.println(providedPassword1);
//        
//        System.out.println(salt1);
//        
//        System.out.println(securePassword1);
        
        
        
        
        
    }

}
