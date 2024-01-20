<<<<<<< HEAD
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
=======
>>>>>>> ec9267bf7e7e17fbe46ce1ec122c1cd5d17263ba
package duan1_nhom1.utils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;

<<<<<<< HEAD
/**
 *
 * @author maccuacu
 */
=======
>>>>>>> ec9267bf7e7e17fbe46ce1ec122c1cd5d17263ba
public class JdbcHelper {
        public static Connection getConnection() {

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=PRO1041_Duan1";
            String username = "sa";
<<<<<<< HEAD
            String pass = "172354";
=======
            String pass = "Password.1";
>>>>>>> ec9267bf7e7e17fbe46ce1ec122c1cd5d17263ba
            return DriverManager.getConnection(url, username, pass);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
