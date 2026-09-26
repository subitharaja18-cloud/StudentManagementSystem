import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class DeleteStudent {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/student_db";
        String username = "root";
        String password = "Subitha@1801";

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter student ID to delete: ");
        int id = scanner.nextInt();

        String query = "DELETE FROM students WHERE id = ?";

        try {
            Connection connection =
                    DriverManager.getConnection(url, username, password);

            PreparedStatement statement =
                    connection.prepareStatement(query);

            statement.setInt(1, id);

            int rows = statement.executeUpdate();

            if (rows > 0) {
                System.out.println("Student deleted successfully!");
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