package com.example.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.db.DatabaseManager;
import com.example.model.User;

public class UserDAO {
    public void insertUser(String username, String password) throws SQLException{
        String sql = "INSERT INTO users (username, password) values(?, ?)";
        try(Connection connection = DatabaseManager.connect();
            PreparedStatement pstmt = connection.prepareStatement(sql)) {

                pstmt.setString(1, username);
                pstmt.setString(2, password);
                pstmt.executeUpdate();
                System.out.println("User successfully added.");
        }
    }

    public User selectUserByUsername(String username) throws SQLException {
        String sql = "SELECT * FROM users WHERE username = ?";
        try (Connection connection = DatabaseManager.connect();
             PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new User(rs.getString("username"), rs.getString("password"));
            } 
        }
        return null;  
    }
}
