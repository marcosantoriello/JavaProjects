package com.example.db;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

public class DatabaseInitializer {
    public static void initializeDatabase() {
        String sql = "CREATE TABLE IF NOT EXISTS users("
            + "id INTEGER PRIMARY KEY AUTOINCREMENT, "
            + "username TEXT NOT NULL, "
            + "password TEXT NOT NULL);";

        try (Connection connection = DatabaseManager.connect();
             Statement stmt = connection.createStatement()) {
                stmt.execute(sql);
                System.out.println("Table users successfully created!");
        } catch (SQLException e) {
            System.err.println("There was an error in creating the table: " + e.getMessage());
        }
    }
}
