"# School" 
import java.io.*;
import java.util.Scanner;

class Student implements Serializable {
    private String id;
    private String name;
    private int score;

    public Student(String id, String name, int score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}

public class StudentFileIO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Student1[] students = new Student1[3];

        for (int i = 0; i < students.length; i++) {
            System.out.print("Enter student ID: ");
            String id = scanner.nextLine();

            System.out.print("Enter student name: ");
            String name = scanner.nextLine();

            System.out.print("Enter student score: ");
            int score = Integer.parseInt(scanner.nextLine());

            students[i] = new Student1(id, name, score);
        }

        
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("exam5.dat"))) {
            for (Student1 student : students) {
                outputStream.writeObject(student);
            }
            
        } catch (FileNotFoundException ex) { 
            Logger.getLogger(StudentFileIO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StudentFileIO.class.getName()).log(Level.SEVERE, null, ex);
        }

       
        
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("exam5.dat"))) {
            double totalScore = 0;
            for (Student1 student : students) {
                student = (Student1) inputStream.readObject();
                totalScore += student.getScore();
            }
            double averageScore = totalScore / students.length;
            System.out.println(averageScore);
            for (Student1 student : students) {
                System.out.println(student);
            }
        } catch (FileNotFoundException ex) { 
            Logger.getLogger(StudentFileIO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StudentFileIO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StudentFileIO.class.getName()).log(Level.SEVERE, null, ex);
        }

       

        scanner.close();
    }
}
