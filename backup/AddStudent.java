import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class AddStudent {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/student_db";
        String username = "root";
        String password = "Subitha@1801";

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter department: ");
        String department = scanner.nextLine();

        System.out.print("Enter CGPA: ");
        double cgpa = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        String query = "INSERT INTO students (name, department, cgpa, email) VALUES (?, ?, ?, ?)";

        try {
            Connection connection =
                    DriverManager.getConnection(url, username, password);

            PreparedStatement statement =
                    connection.prepareStatement(query);

            statement.setString(1, name);
            statement.setString(2, department);
            statement.setDouble(3, cgpa);
            statement.setString(4, email);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Student added successfully!");
            }

            connection.close();

        } catch (Exception e) {
            System.out.println("Error!");
            e.printStackTrace();
        }

        scanner.close();
    }
}