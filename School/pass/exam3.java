package int103_test2;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class exam3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
            try {
                ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("exam3.dat"));
                for(int i=0;i<3;i++){
                    System.out.print("Enter Student ID: ");
                    String sID=input.next();
                    System.out.print("Enter First Name: ");
                    String fName=input.next();
                    System.out.print("Enter Last Name: ");
                    String lName=input.next();
                    System.out.print("Enter Score: ");
                    double score=input.nextDouble();
                    System.out.println(" ");
                    Student3 s = new Student3(sID,fName,lName,score);
                    output.writeObject(s);
                }
                output.flush();
                output.close();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(exam3.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(exam3.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        
        
        
    }
}
