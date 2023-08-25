package int103_test2;

import java.sql.*;
import java.util.*;

public class StudentManagementSystem {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        Scanner input = new Scanner(System.in);
        School sc = new School("KMUTT");
        int option = 0;
        while(option!=5){
            System.out.println("Main Menu");
            System.out.println("1.Add a new student.");
            System.out.println("2.Delete the existing student.");
            System.out.println("3.Display all student details.");
            System.out.println("4.Search a student details.");
            System.out.println("5.Exit.");
            System.out.println(" ");
            System.out.print("Enter your choice: ");
            option=input.nextInt();
            System.out.println("");
            switch(option){
                case 1:
                    System.out.print("Enter your Student ID: ");
                    String sID=input.next();
                    System.out.print("Enter your FirstName: ");
                    String fName=input.next();
                    System.out.print("Enter your LastName: ");
                    String lName=input.next();
                    System.out.print("Enter your Email: ");
                    String email=input.next();
                    System.out.print("Enter your Degree: ");
                    String degree=input.next();
                    System.out.println(" ");
                    Student s = new Student(sID,fName,lName,email,degree);
                    sc.addStudent(s);
                    
                    break;
                case 2:
                    System.out.print("Enter your Student ID: ");
                    String ID=input.next();
                    sc.removeStudent(sc.getStudent(ID));
                    System.out.println(" ");
                    
                    break;
                case 3:
                    sc.displayStudentDetails();
                    System.out.println(" ");
                    break;
                case 4:
                    System.out.print("Enter your Student ID: ");
                    String stID=input.next();
                    sc.searchStudent(stID);
                    System.out.println(" ");
                    break;
            }
        }
        
    }
    public static Connection connect() throws ClassNotFoundException, SQLException{
        String URL = "jdbc:mysql://localhost:3306/school";
        String user = "root";
        String pass = "mysql@sit";
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(URL,user,pass);
        return con;
        
    }
    
}
