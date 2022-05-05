/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package csvtesting;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

/**
 *
 * @author Jamie
 */
public class CsvTesting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        Connection con = cnctDB.cnct();
        Statement stmt = null;
        PreparedStatement ps = null;

        try {

            FileInputStream fstream = new FileInputStream("./workbook.csv");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;
            ArrayList list = new ArrayList();
            String level = "";
            String Context = "";
            String Subcontext = "";
            String Conversation = "";
            String Spanish = "";

            int count = 0;
            while ((strLine = br.readLine()) != null) {

                list.add(strLine);
                count++;
            }
            list.remove(0); // removes title, etc
            Iterator itr;
            for (itr = list.iterator(); itr.hasNext();) { // loops through
                String str = itr.next().toString();
                String[] splitSt = str.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);//str.split(",");// 
                System.out.println(splitSt.length); // https://www.baeldung.com/java-split-string-commas
                    // checks string length
                    if (splitSt[0] != null || splitSt[0].length() != 0) { // splitSt[0].length() != 0 or splitSt[0].isEmpty()
                    // if strings not null and if length not equal to 0
                    if (level.isEmpty()) {
                        level = splitSt[0];
                        Context = splitSt[1];
                        Subcontext = splitSt[2];
                        Conversation = splitSt[3] + ": " + splitSt[4];
                        Spanish = splitSt[5];
                    } else { // if level not empty, & splitSt not = null, means its a new conversation, thus push the old one
                         String contextSql = "INSERT INTO CONTEXT(CONTEXT_TITLE, CONTEXT_LEVEL, SUB_CONTEXT, CONVERSATION_PROMPT, SPANISH_WORDS) VALUES(?,?,?,?,?)";
                        ps = con.prepareStatement(contextSql);
                        // do a random check - ex have a method that checks if number is in db
                        ps.setString(1, level);
                        ps.setString(2, Context);
                        ps.setString(3, Subcontext);
                        ps.setString(4, Conversation);
                        ps.setString(5, Spanish);
                        ps.execute();

                        // assign new  level, context, subcontext, conversation, & spanish
                        level = splitSt[0];
                        Context = splitSt[1];
                        Subcontext = splitSt[2];
                        Conversation = splitSt[3] + ": " + splitSt[4];
                        Spanish = splitSt[5];
                    }
                    // check if string empty, if it isn't push to db

                } else if (splitSt[0] == null || splitSt[0].isEmpty()) {
                    Conversation += "\n" + splitSt[3] + ":" + splitSt[4];
                    Spanish += splitSt[5];
                    //if (splitSt[5] != null || !splitSt[5].isEmpty()) {
                      //  Spanish += splitSt[5];
                    //}
                    // add person a or  b + ":: + ", "\n" - check if spanish section empty, and if it isnt, add it
                }
                    
                    
                System.out.println(Arrays.toString(splitSt));

            }  
            
            
            String contextSql = "INSERT INTO CONTEXT(CONTEXT_TITLE, CONTEXT_LEVEL, SUB_CONTEXT, CONVERSATION_PROMPT, SPANISH_WORDS) VALUES(?,?,?,?,?)";
                        ps = con.prepareStatement(contextSql);
                        // do a random check - ex have a method that checks if number is in db
                        ps.setString(1, level);
                        ps.setString(2, Context);
                        ps.setString(3, Subcontext);
                        ps.setString(4, Conversation);
                        ps.setString(5, Spanish);
                        ps.execute();

//
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public static Integer generateId() { // https://tutorial.eyehunts.com/java/random-number-generator-java-range-5-digit/ source
        Random rand = new Random();
        int number = rand.nextInt(100000);
        String formatNum = String.format("%05d", number);
        int returnNum = Integer.parseInt(formatNum);
        return returnNum;
    }

}
