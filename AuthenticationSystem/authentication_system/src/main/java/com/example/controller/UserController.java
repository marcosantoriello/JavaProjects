package com.example.controller;

import java.sql.SQLException;

import org.apache.commons.codec.digest.DigestUtils;

import com.example.DAO.UserDAO;
import com.example.model.User;

public class UserController {
    private UserDAO userDAO = null;

    public UserController() {
        userDAO = new UserDAO();
    }
 
    public boolean registerUser(String username, String password) {
        if (!isUsernameAlreadyTaken(username)) {
            String hashedPassword = DigestUtils.sha256Hex(password);
            try {
                userDAO.insertUser(username, hashedPassword);
            } catch (SQLException e) {
                System.err.println("There was an error in registering the user.");
                return false;
            }
        }
        System.out.println("Username already taken.");
        return false;
    }

    public boolean login(String username, String password) {
        String hashedPassword = DigestUtils.sha256Hex(password);
            try {
                User user = userDAO.selectUserByUsername(username);
                if (user == null || !user.getPassword().equals(hashedPassword)) {
                    return false;
                }
                return true; // if username and pw matches are found
            } catch (SQLException e) {
                System.err.println("There was an error in registering the user.");
                return false;
            }
    }

    private boolean isUsernameAlreadyTaken(String username) {
        try {
            if (userDAO.selectUserByUsername(username) != null) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println("There was an error while retrieving the user.");
            // prevent the user from signing up if we can't verify username availability
            return true; 
        }
        return false;
    }
}
