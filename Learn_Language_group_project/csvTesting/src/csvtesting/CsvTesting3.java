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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

/**
 *
 * @author Jamie
 */
public class CsvTesting3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here
        Connection con = cnctDB.cnct();
        Statement stmt = null;

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
                String[] splitSt = str.split(",");
                
                // check index, if length = 6, do this, if = to 3, do this, = to 2, do this
                if (splitSt[0] != null || splitSt[0].length() != 0) { // splitSt[0].length() != 0 or splitSt[0].isEmpty()
                    // if strings not null and if length not equal to 0
                    if (level.isEmpty()) {
                        level = splitSt[0];
                        Context = splitSt[1];
                        Subcontext = splitSt[2];
                        Conversation = splitSt[3] + ": " + splitSt[4];
                        Spanish = splitSt[5];
                    } else { // if level not empty, & splitSt not = null, means its a new conversation, thus push the old one
                        String sqlString = "INSERT INTO CONTEXT (LEVEL, CONTEXT_TITLE, SUB_CONTEXT, CONVERSATION_PROMPT, SPANISH_WORDS) VALUES \n"
                                + "('" + level + "'," + Context + "," + Subcontext + ",'" + Conversation + ",'" + Spanish + "')";
                        // System.out.println("sqlString : "+ sqlString);
                        con.setAutoCommit(false);
                        stmt = con.createStatement();
                        stmt.executeUpdate(sqlString);
                        stmt.close();
                        con.commit();

                        // assign new  level, context, subcontext, conversation, & spanish
                        level = splitSt[0];
                        Context = splitSt[1];
                        Subcontext = splitSt[2];
                        Conversation = splitSt[3] + ": " + splitSt[4];
                        Spanish = splitSt[5];
                    }
                    // check if string empty, if it isn't push to db

                } else if (splitSt[0] == null || splitSt[0].isEmpty()) {
                    Conversation += "," + splitSt[3] + ":" + splitSt[4];
                    Spanish += splitSt[5];
                    //if (splitSt[5] != null || !splitSt[5].isEmpty()) {
                      //  Spanish += splitSt[5];
                    //}
                    // add person a or  b + ":: + ", "\n" - check if spanish section empty, and if it isnt, add it
                }
                // check if splitSt not empty, then add to strings and whatnot

                // add a check if not empty, and the string is full, reset them
                System.out.println(Arrays.toString(splitSt));
                
            }  // after its done, and last loop, then do a sqlString to send outside the for loop
            String sqlString = "INSERT INTO CONTEXT (LEVEL, CONTEXT_TITLE, SUB_CONTEXT, CONVERSATION_PROMPT, SPANISH_WORDS) VALUES \n"
                    + "('" + level + "'," + Context + "," + Subcontext + ",'" + Conversation + ",'" + Spanish + "')";
            // System.out.println("sqlString : "+ sqlString);
            con.setAutoCommit(false);
            stmt = con.createStatement();
            stmt.executeUpdate(sqlString);
            stmt.close();
            con.commit(); 

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
