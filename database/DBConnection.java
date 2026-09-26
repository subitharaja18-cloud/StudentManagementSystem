package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    static String url = "jdbc:mysql://localhost:3306/student_db";
    static String username = "root";
    static String password = "Subitha@1801";

    public static Connection getConnection() throws Exception {

        return DriverManager.getConnection(
                url,
                username,
                password
        );
    }
}