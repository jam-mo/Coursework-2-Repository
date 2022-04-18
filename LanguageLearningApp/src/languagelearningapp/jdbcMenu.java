/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package languagelearningapp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class jdbcMenu{

    

    public static void insertEmp(int Eid, String Ename, String Ejob, int Esal) {

        Connection con = languageApp.getConnection();
        Statement stmt = null;
        int empID = Eid;
        String empName = Ename;
        String job = Ejob;
        int sal = Esal;
        String sqlString = "INSERT INTO employee (empName, empID, empSal, empJob) VALUES ('" + empName + "'," + empID + "," + sal + ",'" + job + "')";
        try {
            con.setAutoCommit(false);
            stmt = con.createStatement();
            stmt.executeUpdate(sqlString);
            stmt.close();
            con.commit();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
        }
    }

    public static void delEmp(int Eid) {

        Connection con = connectDB.getConnection();
        Statement stmt = null;
        //String sqlString = "SELECT empID, empName, empJob " +" FROM employee WHERE EmployeeID=1001";
        String sqlString = "DELETE from employee WHERE empID=" + Eid;
        try {
            con.setAutoCommit(false);
            stmt = con.createStatement();
            stmt.executeUpdate(sqlString);
            con.commit();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
        }
    }

    public static void amendEmp(int Eid) {

        Connection con = connectDB.getConnection();
        Statement stmt = null;
        String sqlString = ("UPDATE employee set empSal =" + 88888 + " WHERE empID=" + Eid);
        try {
            con.setAutoCommit(false);
            stmt = con.createStatement();
            stmt.executeUpdate(sqlString);
            con.commit();

        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
        }
    }

    public static void showAll() {
        Connection con = connectDB.getConnection();
        Statement stmt = null;
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("Select * from employee ");
            int n = 0;
            while (rs.next()) {
                int numColumns = rs.getMetaData().getColumnCount();
                n++;
                for (int i = 1; i <= numColumns; i++) {
                    System.out.print(" " + rs.getObject(i));
                }

                System.out.println("");
            }

            rs.close();
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        } finally {
            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (SQLException e) {
                    System.err.println("SQLException: " + e.getMessage());
                }
            }
        }

    }

    public static void menu() {
        Scanner  INPUT;
        String menuOpt;
        int menuNum = 0;
        INPUT = new Scanner(System.in);
        final String INPUT_RANGE_ERROR = "Input is out of range, please enter a number from 1-5";
        

        while (true) {
            System.out.println("\n\t Employee Menu");
            System.out.println("===========================================");
            System.out.println("Enter [1] To create a new employee");
            System.out.println("Enter [2] To delete employee");
            System.out.println("Enter [3] To display all employees");
            System.out.println("Enter [4] To update employee sal");
            System.out.println("Enter [5] To exit the program \n");
            System.out.println("");
            System.out.println("Enter your choice");
            menuOpt = INPUT.nextLine();

            try {
                menuNum = Integer.parseInt(menuOpt);
            } catch (NumberFormatException e) {
            }

            switch (menuNum) {
                case 1:
                    insertEmp(11, "A Anon", "Other", 12345);
                    break;
                case 2:
                    delEmp(11);
                    break;
                case 3:
                    showAll();
                    break;
                case 4:
                    amendEmp(11);
                    break;

                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println(INPUT_RANGE_ERROR);
            }
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        menu();

        // insertEmp(11, "A Anon", "Other", 12345);
        //delEmp(11);
        //showAll();
        //amendEmp(11);
        //showAll();
    }

}
