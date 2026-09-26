import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentList {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/student_db";
        String username = "root";
        String password = "Subitha@1801";

        try {
            Connection connection =
                    DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            String query = "SELECT * FROM students";

            ResultSet result = statement.executeQuery(query);

            System.out.println("----- Student List -----");

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
            System.out.println("Error!");
            e.printStackTrace();
        }
    }
}