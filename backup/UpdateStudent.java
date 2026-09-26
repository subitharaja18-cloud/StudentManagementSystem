import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class UpdateStudent {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/student_db";
        String username = "root";
        String password = "Subitha@1801";

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter new name: ");
        String name = scanner.nextLine();

        System.out.print("Enter new department: ");
        String department = scanner.nextLine();

        System.out.print("Enter new CGPA: ");
        double cgpa = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Enter new email: ");
        String email = scanner.nextLine();

        String query = "UPDATE students SET name = ?, department = ?, cgpa = ?, email = ? WHERE id = ?";

        try {
            Connection connection =
                    DriverManager.getConnection(url, username, password);

            PreparedStatement statement =
                    connection.prepareStatement(query);

            statement.setString(1, name);
            statement.setString(2, department);
            statement.setDouble(3, cgpa);
            statement.setString(4, email);
            statement.setInt(5, id);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Student updated successfully!");
            } else {
                System.out.println("Student ID not found!");
            }

            connection.close();

        } catch (Exception e) {
            System.out.println("Error!");
            e.printStackTrace();
        }

        scanner.close();
    }
}