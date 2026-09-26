import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SearchStudent {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/student_db";
        String username = "root";
        String password = "Subitha@1801";

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student ID to search: ");
        int id = scanner.nextInt();

        String query = "SELECT * FROM students WHERE id = ?";

        try {
            Connection connection =
                    DriverManager.getConnection(url, username, password);

            PreparedStatement statement =
                    connection.prepareStatement(query);

            statement.setInt(1, id);

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                System.out.println("\n----- Student Details -----");
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
            System.out.println("Error!");
            e.printStackTrace();
        }

        scanner.close();
    }
}