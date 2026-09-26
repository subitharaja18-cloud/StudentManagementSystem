import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/student_db";
        String username = "root";
        String password = "Subitha@1801";

        try {
            Connection connection =
                    DriverManager.getConnection(url, username, password);

            System.out.println("MySQL Connected Successfully!");

            connection.close();

        } catch (Exception e) {
            System.out.println("Connection Failed!");
            e.printStackTrace();
        }
    }
}