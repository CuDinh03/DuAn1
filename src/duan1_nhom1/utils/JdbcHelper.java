package duan1_nhom1.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;


public class JdbcHelper {
        public static Connection getConnection() {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String url = "jdbc:sqlserver://localhost:1433;databaseName=PRO1041_Duan1;encrypt=true;trustServerCertificate=true;";
            String username = "sa123";
            String pass = "123";
            return DriverManager.getConnection(url, username, pass);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
