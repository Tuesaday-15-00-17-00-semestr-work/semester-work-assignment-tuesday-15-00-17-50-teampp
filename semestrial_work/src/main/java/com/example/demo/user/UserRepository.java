package com.example.demo.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;


@Repository
public interface UserRepository
        extends JpaRepository<User, Long> {

    //@Query("SELECT u FROM User, u WHERE u.username = ?1")
    Optional<User> findByUsername(String username);

    /*
    private static final String INSERT_QUERY = "INSERT INTO registration (full_name, email_id, password) VALUES (?, ?, ?)";


    public void insertRecord(String fullName, String emailId, String password) throws SQLException {


             // Step 2:Create a statement using connection object
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY)) {
        preparedStatement.setString(1, fullName);
        preparedStatement.setString(2, emailId);
        preparedStatement.setString(3, password);
    }
    */
}
