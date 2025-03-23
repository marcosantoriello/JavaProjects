package com.example.db;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DatabaseManager {
    // prevent instantiation according to the Singleton pattern
    private DatabaseManager() {}

    private static String dbName;
    // Taking the db name from a JSON file just as an exercise
    static {
        try {
            InputStream inputStream = DatabaseManager.class.getClassLoader().getResourceAsStream("db_name.json");
            if (inputStream == null) {
                System.err.println("Error: file db_name.json not found in classpath!");
            }
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(inputStream);
            dbName = rootNode.get("db_name").asText();
        } catch (Exception e) {
            System.err.println("Error while reading db_name.json: " + e.getMessage());
        }
    }

    private static final String URL = "jdbc:sqlite:" + dbName;

    public static Connection connect() {
        try {
            return DriverManager.getConnection(URL);
        } catch (SQLException e) {
            System.err.println("Connection Error: " + e.getMessage());
            return null;
        }
    }

    public static void closeConnection(Connection connection) {
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
