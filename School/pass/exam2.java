package int103_test2;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class exam2 {
    public static void main(String[] args) {
        try {
            Scanner input = new Scanner(new FileReader("exam1.txt"));
            System.out.println(input.next());
            System.out.println(input.next());
            System.out.println(input.next());
            System.out.println(input.next());
            System.out.println(input.next());
        } catch (FileNotFoundException ex) {
            Logger.getLogger(exam2.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
