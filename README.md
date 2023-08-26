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
        Student[] students = new Student[3];

        for (int i = 0; i < students.length; i++) {
            System.out.print("Enter student ID: ");
            String id = scanner.nextLine();

            System.out.print("Enter student name: ");
            String name = scanner.nextLine();

            System.out.print("Enter student score: ");
            int score = Integer.parseInt(scanner.nextLine());

            students[i] = new Student(id, name, score);
        }

        // Write Student objects to file
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("exam5.dat"))) {
            for (Student student : students) {
                outputStream.writeObject(student);
            }
            System.out.println("Student objects written to the file.");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read Student objects from file and calculate average score
        double totalScore = 0;
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("exam5.dat"))) {
            for (Student student : students) {
                student = (Student) inputStream.readObject();
                totalScore += student.getScore();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        if (students.length > 0) {
            double averageScore = totalScore / students.length;
            System.out.println("Student array read from file:");
            for (Student student : students) {
                System.out.println(student);
            }
            System.out.println("Average score: " + averageScore);
        } else {
            System.out.println("No students read from the file.");
        }

        scanner.close();
    }
}
