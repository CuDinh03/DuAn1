/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author anhtuanle
 */
public class JDBCConnection {

    public static Connection getjdbcConnection() {
        String url = "jdbc:sqlserver://localhost:1433;databaseName=PRO1041_Duan1;user=sa;password=123456aA@; encrypt=true;trustServerCertificate=true";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(url);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;

    }
}