package com.example.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.example.App;

public class DatabaseManager {
    private static final String URL = "jdbc:sqlite:database.db";

    private static Connection connection = null;

    public static Connection connect() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL);
            } catch (SQLException e) {
                System.err.println("Connection Error: " + e.getMessage());
                return null;
            }
        }
        return connection;
    }

    public static Connection getConnection() {
        if (connection != null) {
            return connection;
        }
        System.err.println("There is no db connection.");
        return null;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
                System.out.println("Database connection closed.");
            } catch (Exception e) {
                System.err.println("Error closing connection: " + e.getMessage());
            }
        }
    }
}
