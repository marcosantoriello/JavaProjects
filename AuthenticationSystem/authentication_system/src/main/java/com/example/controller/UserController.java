package com.example.controller;

import java.sql.SQLException;

import org.apache.commons.codec.digest.DigestUtils;

import com.example.DAO.UserDAO;

public class UserController {
    private UserDAO userDAO = null;

    public UserController() {
        userDAO = new UserDAO();
    }
 
    public boolean registerUser(String username, String password) {
        if (!isUsernameAlreadyTaken(username)) {
            String hashedPassword = DigestUtils.sha256Hex(password);
            System.out.println("PASSWORD HASH:\n" + hashedPassword);
            try {
                userDAO.insertUser(username, hashedPassword);
            } catch (SQLException e) {
                System.err.println("There was an error in registering the user.");
                return false;
            }
        }
        return false;
    }

    private boolean isUsernameAlreadyTaken(String username) {
        try {
            if (userDAO.selectUserByUsername(username) != null) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println("There was an error while retrieving the user.");
            e.printStackTrace();
            // prevent the user from signing up if we can't verify username availability
            return true; 
        }
        return false;
    }
}
