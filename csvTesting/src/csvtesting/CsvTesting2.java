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
public class CsvTesting2 {

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
                String[] splitSt = str.split(",");

                if (splitSt.length == 5) { // if it reaches where title, context, subconext, person and prompt are,will call this
                    if (level.isEmpty()) { // for first iteration
                        level = splitSt[0];
                        Context = splitSt[1];
                        Subcontext = splitSt[2];
                        Conversation = splitSt[3] + ": " + splitSt[4];
                        //Spanish = splitSt[5];
                    } else { 
                        String contextSql = "INSERT INTO CONTEXT(CONTEXT_TITLE, CONTEXT_LEVEL, SUB_CONTEXT, CONVERSATION_PROMPT, SPANISH_WORDS) VALUES(?,?,?,?,?)";
                        ps = con.prepareStatement(contextSql);
                        ps.setString(1, level);
                        ps.setString(2, Context);
                        ps.setString(3, Subcontext);
                        ps.setString(4, Conversation);
                        ps.setString(5, Spanish);
                        ps.execute();

                        level = splitSt[0];
                        Context = splitSt[1];
                        Subcontext = splitSt[2];
                        Conversation = splitSt[3] + ": " + splitSt[4];
                        //Spanish = splitSt[5];
                    }
                } else if (splitSt.length == 3) {
                    Conversation += splitSt[0] + ":" + splitSt[1];
                    Spanish += splitSt[2];
                     String contextSql = "INSERT INTO CONTEXT(CONTEXT_TITLE, CONTEXT_LEVEL, SUB_CONTEXT, CONVERSATION_PROMPT, SPANISH_WORDS) VALUES(?,?,?,?,?)";
                        ps = con.prepareStatement(contextSql);
                        // do a random check - ex have a method that checks if number is in db
                        ps.setString(1, level);
                        ps.setString(2, Context);
                        ps.setString(3, Subcontext);
                        ps.setString(4, Conversation);
                        ps.setString(5, Spanish);
                        ps.execute();
                } else if (splitSt.length == 2) {
                    Conversation += splitSt[0] + ":" + splitSt[1];
                     String contextSql = "INSERT INTO CONTEXT(CONTEXT_TITLE, CONTEXT_LEVEL, SUB_CONTEXT, CONVERSATION_PROMPT, SPANISH_WORDS) VALUES(?,?,?,?,?)";
                        ps = con.prepareStatement(contextSql);
                        // do a random check - ex have a method that checks if number is in db
                        ps.setString(1, level);
                        ps.setString(2, Context);
                        ps.setString(3, Subcontext);
                        ps.setString(4, Conversation);
                        ps.setString(5, Spanish);
                        ps.execute();
                }
                //System.out.println(Arrays.toString(splitSt));

            }  // after its done, and last loop, then do a sqlString to send outside the for loop
           // String sqlString = "INSERT INTO CONTEXT (LEVEL, CONTEXT_TITLE, SUB_CONTEXT, CONVERSATION_PROMPT, SPANISH_WORDS) VALUES \n"
                   // + "('" + level + "'," + Context + "," + Subcontext + ",'" + Conversation + ",'" + Spanish + "');";
            // System.out.println("sqlString : "+ sqlString);
            /*con.setAutoCommit(false);
            stmt = con.createStatement();
            stmt.executeUpdate(sqlString);
            stmt.close();
            con.commit();*/
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
