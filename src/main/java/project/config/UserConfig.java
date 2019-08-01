package project.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class UserConfig {

    private Connection connection;

    public Connection getConnection() {
        try {
            String URL = "jdbc:mysql://localhost:3306/users_manager?serverTimezone=UTC";
            String USERNAME = "root";
            String PASSWORD = "root";
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
