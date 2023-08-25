package int103_test2;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class exam4 {
    public static void main(String[] args) {
        try {
            Student3[] allstudents = new Student3[3];
            double sum=0;
            ObjectInputStream input = new ObjectInputStream(new FileInputStream("exam3.dat"));
            for(int i = 0;i<3;i++){
                Student3 s =(Student3) input.readObject();
                allstudents[i] = s;
                sum += allstudents[i].getScore();
            }
            input.close();
            double average = sum/3;
            System.out.println("Average Score is "+average);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(exam4.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(exam4.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
