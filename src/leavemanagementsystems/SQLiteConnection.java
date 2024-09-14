/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package leavemanagementsystems;

/**
 *
 * @author AMSY
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConnection {
    public static Connection connect() {
        Connection connection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:C:\\Users\\AMSY\\Documents\\NetBeansProjects\\LeaveManagementSystems\\src\\leavemanagementsystemsdatabase.db";  // Replace with the path to your SQLite database file
            connection = DriverManager.getConnection(url);
            System.out.println("Connected to the SQLite database.");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

