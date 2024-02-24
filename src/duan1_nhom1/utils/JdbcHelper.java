package duan1_nhom1.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;


public class JdbcHelper {
        public static Connection getConnection() {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String url = "jdbc:sqlserver://localhost:1433;databaseName=PRO1041_Duan12";
            String username = "sa";
            String pass = "123456aA@";
            return DriverManager.getConnection(url, username, pass);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
