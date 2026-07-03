package ir.maktabsharif.util;

import ir.maktabsharif.exception.DatabaseConnectionException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    private static final String URL = "jdbc:postgresql://localhost:5432/bookstore";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "2117";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        catch (SQLException e) {
            throw new DatabaseConnectionException("Database Connection Failed!");
        }
    }
}
