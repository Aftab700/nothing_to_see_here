package init_db_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class init_db {
    public static Connection connect_mysql() {

        String url = "jdbc:mysql://localhost:3306/Test";
        String username = "root";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Connected to MySQL server: " + connection.getMetaData().getDatabaseProductName());
            // String unicode = "useSSL=false&autoReconnect=true&useUnicode=yes&characterEncoding=UTF-8";
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.err.println("Error connecting to MySQL server: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
