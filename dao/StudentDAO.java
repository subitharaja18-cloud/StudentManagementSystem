package dao;

import database.DBConnection;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // Add Student
    public void addStudent(Student student) {

        String query = "INSERT INTO students (name, department, cgpa, email) VALUES (?, ?, ?, ?)";

        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, student.getName());
            statement.setString(2, student.getDepartment());
            statement.setDouble(3, student.getCgpa());
            statement.setString(4, student.getEmail());

            statement.executeUpdate();

            System.out.println("Student added successfully!");

            connection.close();

        } catch (Exception e) {
            System.out.println("Error while adding student!");
            e.printStackTrace();
        }
    }

    // View Students
    public void viewStudents() {

        String query = "SELECT * FROM students";

        try {
            Connection connection = DBConnection.getConnection();

            Statement statement = connection.createStatement();

            ResultSet result = statement.executeQuery(query);

            System.out.println("\n----------- Student List -----------");

            while (result.next()) {

                System.out.println(
                    "ID: " + result.getInt("id") +
                    " | Name: " + result.getString("name") +
                    " | Department: " + result.getString("department") +
                    " | CGPA: " + result.getDouble("cgpa") +
                    " | Email: " + result.getString("email")
                );
            }

            connection.close();

        } catch (Exception e) {
            System.out.println("Error while viewing students!");
            e.printStackTrace();
        }
    }

    // Search Student
    public void searchStudent(int id) {

        String query = "SELECT * FROM students WHERE id = ?";

        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();

            if (result.next()) {

                System.out.println("\n----------- Student Details -----------");
                System.out.println("ID: " + result.getInt("id"));
                System.out.println("Name: " + result.getString("name"));
                System.out.println("Department: " + result.getString("department"));
                System.out.println("CGPA: " + result.getDouble("cgpa"));
                System.out.println("Email: " + result.getString("email"));

            } else {
                System.out.println("Student not found!");
            }

            connection.close();

        } catch (Exception e) {
            System.out.println("Error while searching student!");
            e.printStackTrace();
        }
    }

    // Update Student
    public void updateStudent(Student student) {

        String query =
                "UPDATE students SET name = ?, department = ?, cgpa = ?, email = ? WHERE id = ?";

        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setString(1, student.getName());
            statement.setString(2, student.getDepartment());
            statement.setDouble(3, student.getCgpa());
            statement.setString(4, student.getEmail());
            statement.setInt(5, student.getId());

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Student updated successfully!");
            } else {
                System.out.println("Student ID not found!");
            }

            connection.close();

        } catch (Exception e) {
            System.out.println("Error while updating student!");
            e.printStackTrace();
        }
    }

    // Delete Student
    public void deleteStudent(int id) {

        String query = "DELETE FROM students WHERE id = ?";

        try {
            Connection connection = DBConnection.getConnection();

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, id);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Student ID not found!");
            }

            connection.close();

        } catch (Exception e) {
            System.out.println("Error while deleting student!");
            e.printStackTrace();
        }
    }
}