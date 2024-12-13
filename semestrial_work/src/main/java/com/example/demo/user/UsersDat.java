package com.example.demo.user;

import javafx.scene.control.TextField;

import java.sql.*;

public class UsersDat {

    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/BOOKSTORE?useSSL=false";
    private static final String DATABASE_USERNAME = "semestralka";
    private static final String DATABASE_PASSWORD = "123456";
    private static final String INSERT_QUERY = "INSERT INTO user (email, password, role, username) VALUES (?, ?, ?, ?)";
    private static final String SELECT_QUERY = "SELECT * FROM user WHERE username = ?";
    private static final String DELETE_QUERY = "DELETE FROM user WHERE username = ?";
    private static final String SELECT_QUERY_P = "SELECT * FROM user WHERE username = ? AND password = ?;";
    private static final String SELECT_ROLE = "SELECT * FROM user WHERE role = ? AND username = ?";
    private static final String CHANGE_ROLE = "UPDATE user SET role = '1' WHERE username = ?";
    private static final String FIND_ID = "SELECT user_id FROM user WHERE username = ?";


    public int FindId(String username) {
        int id = -1;
        try (Connection connection = DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ID)) {

            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                id = resultSet.getInt("user_id");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return id;
    }


    public void insertRecord(String username, String email, String password) throws SQLException {
        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, "0");
            preparedStatement.setString(4, username);

            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            // print SQL exception information
            printSQLException(e);
        }
    }

    public int findRecord(String fullName) throws SQLException {
        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY)) {
            preparedStatement.setString(1, fullName);


            ResultSet resultSet = preparedStatement.executeQuery();


            if (!resultSet.next()) {
                return 1;
            }


        } catch (SQLException e) {
            printSQLException(e);
        }
        return 0;
    }

    public int rightPassword(String fullName, String password) {
        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);


             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY_P)) {
            preparedStatement.setString(1, fullName);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();


            if (!resultSet.next()) {
                return 1;
            }


        } catch (SQLException e) {
            printSQLException(e);
        }
        return 0;
    }

    public int findRole(String fullName) {
        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);


             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ROLE)) {
            preparedStatement.setString(1, "1");
            preparedStatement.setString(2, fullName);

            ResultSet resultSet = preparedStatement.executeQuery();


            if (!resultSet.next()) {
                return 1;
            }


        } catch (SQLException e) {
            printSQLException(e);
        }
        return 0;
    }

    public void deleteUser(String fullName) {
        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);


             PreparedStatement preparedStatement = connection.prepareStatement(DELETE_QUERY)) {
            preparedStatement.setString(1, fullName);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public void changeRole(String fullName) {
        try (Connection connection = DriverManager
                .getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);


             PreparedStatement preparedStatement = connection.prepareStatement(CHANGE_ROLE)) {
            preparedStatement.setString(1, fullName);

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            printSQLException(e);
        }
    }


    public static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}