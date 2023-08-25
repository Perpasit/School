package int103_test2;

import java.io.*;

public class Student3 implements Serializable{
    String studentID;
    String firstName;
    String lastName;
    double score;

    public Student3(String studentID, String firstName, String lastName, double score) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student3{" + "studentID=" + studentID + ", firstName=" + firstName + ", lastName=" + lastName + ", score=" + score + '}';
    }
    
    public double getScore(){
        return this.score;
    }
}
