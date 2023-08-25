package int103_test2;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class exam1 {
    public static void main(String[] args) {
        try {
            PrintWriter output = new PrintWriter("exam1.txt");
            output.println("65130500105");
            output.println("Natthaphol Nirattisaikul");
            output.println("19");
            output.println("180");
            output.println("82");
            output.flush();
            output.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(exam1.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
