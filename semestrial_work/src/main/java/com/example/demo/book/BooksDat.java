package com.example.demo.book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.example.demo.user.UsersDat.printSQLException;


public class BooksDat {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/BOOKSTORE?useSSL=false";
    private static final String DATABASE_USERNAME = "semestralka";
    private static final String DATABASE_PASSWORD = "123456";
    private static final String INSERT_QUERY = "INSERT INTO book (title, author, isbn, available_copies) VALUES (?, ?, ?, ?)";
    private static final String SELECT_QUERY = "SELECT * FROM registration WHERE full_name = ?";
    private static final String DELETE_QUERY = "DELETE FROM registration WHERE full_name = ?";
    private static final String SELECT_QUERY_P = "SELECT * FROM registration WHERE password = ?";


    public void insertRecord(String title, String author, String isbn, int available_copies) throws SQLException {

        // Step 1: Establishing a Connection and
        // try-with-resource statement will auto close the connection.
        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, author);
            preparedStatement.setString(3, isbn);
            preparedStatement.setInt(4, available_copies);


            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
}

