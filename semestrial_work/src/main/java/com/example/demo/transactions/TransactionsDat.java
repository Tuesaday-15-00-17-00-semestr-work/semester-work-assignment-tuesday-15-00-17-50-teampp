package com.example.demo.transactions;

import java.sql.*;
import java.time.LocalDateTime;

import static com.example.demo.user.UsersDat.printSQLException;

public class TransactionsDat {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/BOOKSTORE?useSSL=false";
    private static final String DATABASE_USERNAME = "semestralka";
    private static final String DATABASE_PASSWORD = "123456";
    private static final String INSERT_QUERY = "INSERT INTO transactions (user_id, book_id, action, date) VALUES (?, ?, ?, ?)";


    public void insertTransaction(int user_id, int book_id, String action) throws SQLException {

        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {
            preparedStatement.setInt(1, user_id);
            preparedStatement.setInt(2, book_id);
            preparedStatement.setString(3, action);
            preparedStatement.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            printSQLException(e);
        }
    }
}
