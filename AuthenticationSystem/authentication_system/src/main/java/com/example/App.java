package com.example;

import java.io.Console;
import java.util.Scanner;

import com.example.controller.UserController;
import com.example.db.DatabaseInitializer;
import com.example.model.User;

public class App 
{
    public static void main( String[] args )
    {
        DatabaseInitializer.initializeDatabase();
        UserController userController = new UserController();
        boolean exit = false;

        System.out.println("Welcome!");
        while (!exit) {
            System.out.println("Select an operation:\n"
            + "1. Sign in\n"
            + "2. Login\n"
            + "3. Exit");

            Console console = System.console();
            int choice = Integer.parseInt(console.readLine());

            switch (choice) {
                case 1:
                    while (true) {          
                        System.out.println("Register a new account\n"
                            + "----------------------");
                        System.out.println("Choose an username: ");
                        String inputUsername = console.readLine();
                        System.out.println("Choose a password");
                        // password masking
                        char[] passwordArray = console.readPassword();
                        String inputPassword = new String(passwordArray);
                        if (userController.registerUser(inputUsername, inputPassword)) {
                            System.out.println("User successfully registered.");
                            break;
                        }
                    }
                    break;
                case 2:
                    System.out.println("Login\n"
                        + "----------------------");
                    System.out.println("Username: ");
                    String inputUsername = console.readLine();
                    System.out.println("Password: ");
                    char[] passwordArray = console.readPassword();
                    String inputPassword = new String(passwordArray);

                    if (userController.login(inputUsername, inputPassword)) {
                        System.out.println("You are now logged in!");
                    } else {
                        System.out.println("Invalid credentials.");
                    }
                    break;

                case 3:
                    System.out.println("Goodbye!");
                    exit = true;
                    break;
            
                default:
                    System.out.println("Option not available");
                    break;
            }
        }

    }
}
