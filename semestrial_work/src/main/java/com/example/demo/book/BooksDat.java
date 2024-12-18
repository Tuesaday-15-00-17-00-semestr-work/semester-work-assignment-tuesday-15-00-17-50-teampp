package com.example.demo.book;

import java.sql.*;
import java.util.ArrayList;

import static com.example.demo.user.UsersDat.printSQLException;


public class BooksDat {
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/BOOKSTORE?useSSL=false";
    private static final String DATABASE_USERNAME = "semestralka";
    private static final String DATABASE_PASSWORD = "123456";
    private static final String INSERT_QUERY = "INSERT INTO book (title, author, isbn, available_copies) VALUES (?, ?, ?, ?)";
    private static final String SELECT_QUERY = "SELECT * FROM book WHERE title = ?";
    private static final String FIND_ID = "SELECT book_id FROM book WHERE title = ?";
    private static final String DECREASE = "UPDATE book SET available_copies = available_copies - 1 WHERE book_id = ?";


    public int FindId(String title) {
        int id = -1;
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ID)) {

            preparedStatement.setString(1, title);
            ResultSet resultSet = preparedStatement.executeQuery();

            // If a result is found, retrieve the book_id
            if (resultSet.next()) {
                id = resultSet.getInt("book_id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }

    public ArrayList<String> findBookByTitle(String title) {
        ArrayList<String> book = new ArrayList<>();
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY)) {

            preparedStatement.setString(1, title);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                //int id = resultSet.getInt("book_id");
                String bookTitle = resultSet.getString("title");
                String author = resultSet.getString("author");
                String isbn = resultSet.getString("isbn");
                int available = resultSet.getInt("available_copies");

                book.add(author);
                book.add(isbn);
                book.add(String.valueOf(available));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }


    public void insertRecord(String title, String author, String isbn, int available_copies) throws SQLException {

        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

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

    public void Decrease(int id) {
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(DECREASE)) {

            // Set the parameters for the prepared statement
            preparedStatement.setInt(1, id);     // Set the book_id to update

            // Execute the update
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

