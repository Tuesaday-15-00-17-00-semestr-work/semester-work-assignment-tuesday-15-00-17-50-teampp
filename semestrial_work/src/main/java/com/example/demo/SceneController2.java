package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class SceneController2 {
    private Stage stageA;
    private Scene sceneA;
    private Parent root;

    //@FXML
    //private Label label;
    @FXML
    private TextField username_textfield;
    @FXML
    private TextField password_textfield;
    @FXML
    private TextField email_textfield;

    String username, password, email;

    public void submit2(ActionEvent event) throws IOException {
        username = username_textfield.getText();
        password = password_textfield.getText();
        email = email_textfield.getText();

        if(Objects.equals(username, "patopoco") && Objects.equals(password, "patopoco")){
            SwitchToBookActionsUser(event);
        }
    }


    public void SwitchToBookActionsUser(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/BookActionsUser.fxml"));
        stageA = (Stage)((Node)event.getSource()).getScene().getWindow();
        sceneA = new Scene(root);
        stageA.setScene(sceneA);
        stageA.show();
    }
}

