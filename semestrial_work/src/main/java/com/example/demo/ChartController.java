package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ChartController {
    private Stage stage;
    private Scene scene;
    private Parent root;

//    public void SwitchToLogInScene(ActionEvent event) throws IOException {
//        root = FXMLLoader.load(getClass().getResource("/LogIn.fxml"));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }
//    public void SwitchToSingUpScene(ActionEvent event) throws IOException {
//        root = FXMLLoader.load(getClass().getResource("/SingUp.fxml"));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
//    }

    public void switchToLogInScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/LogIn.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSingUpScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/SingUp.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
    /*
    @FXML
    private Label loginLabel;

    @FXML
    private Button loginButton;

    @FXML
    private Button signUpButton;

    // Handle Log In button
    @FXML
    private void handleLogin() {
        System.out.println("Log In button clicked!");
        loginLabel.setText("Logging in...");

    }

    // Handle Sign Up button
    @FXML
    private void handleSignUp() {
        System.out.println("Sign Up button clicked!");
        loginLabel.setText("Signing up...");
    }

    */
}

