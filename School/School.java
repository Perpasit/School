package int103_test2;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class School {

    private String schoolName;

    public School(String schoolName) {
        this.schoolName = schoolName;
    }

    public void addStudent(Student student) {

        try {
            Connection con = StudentManagementSystem.connect();
            PreparedStatement pre = con.prepareStatement("insert into student(studentID, firstName, lastName, email, degree)" + "values (?, ?, ?, ?, ?)");
            pre.setString(1, student.getStudentID());
            pre.setString(2, student.getFirstName());
            pre.setString(3, student.getLastName());
            pre.setString(4, student.getEmail());
            pre.setString(5, student.getDegree());
            pre.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(School.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void removeStudent(Student student) {
        try {
            Connection con = StudentManagementSystem.connect();
            PreparedStatement pre = con.prepareStatement("delete * from student where studentID = ?");
            pre.setString(1, student.getStudentID());
            pre.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(School.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void displayStudentDetails() {
        try {
            Connection con = StudentManagementSystem.connect();
            Statement state = con.createStatement();
            ResultSet results = state.executeQuery("select * from student");
            while (results.next()) {
                System.out.println(results.getString(1) + " "
                        + results.getString(2) + " "
                        + results.getString(3) + " "
                        + results.getString(4) + " "
                        + results.getString(5));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(School.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void searchStudent(String studentID) {
        try {
            Connection con = StudentManagementSystem.connect();
            Statement state = con.createStatement();
            ResultSet results = state.executeQuery("select * from student where studentID = " + studentID);
            while (results.next()) {
                System.out.println(results.getString(1) + " "
                        + results.getString(2) + " "
                        + results.getString(3) + " "
                        + results.getString(4) + " "
                        + results.getString(5));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(School.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Student getStudent(String studentID) throws ClassNotFoundException, SQLException {
        Connection con = StudentManagementSystem.connect();
        Statement state = con.createStatement();
        ResultSet results = state.executeQuery("select * from student where studentID = " + studentID);
        Student ss = new Student(results.getString(1), results.getString(2), results.getString(3), results.getString(4), results.getString(5));
        return ss;
    }
}
