
# Simple Java Authentication and Registration System

## Overview

This project is a simple authentication and registration system built using **Java** and an **SQLite database**. The goal was to refresh my Java skills and learn how to work with **JSON files**, **SQLite**, and **password hashing**.

The system allows users to:
- **Register** with a username and password (hashed before storing).
- **Log in** with their username and password.
- Ensure that the username is unique during registration (the system will ask the user to pick another if the username is already taken).
- The **password** is hidden in the terminal during input.
- The database name is stored in a **JSON file** located in `src/main/resources/db_name.json`.

## Features

- **Password Hashing**: Passwords are stored **hashed** using the SHA-256 algorithm (instead of storing them in plaintext).
- **SQLite Database**: The system uses an SQLite database to store user information.
- **JSON Configuration**: The database name is fetched dynamically from a `JSON` file.
- **Parameterized Queries**: To prevent SQL injection, parameterized queries are used when interacting with the database.
- **Terminal Input Masking**: The password input is hidden on the terminal for security reasons.

## Technologies Used

- **Java 23**
- **SQLite** (for database storage)
- **Jackson** (for parsing JSON)
- **Apache Commons Codec** (for SHA-256 hashing)
