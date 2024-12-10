package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class BrowseController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField title;
    @FXML
    private TextField author;

    String t, a;

    public void find(ActionEvent event) throws IOException {
        t = title.getText();
        a = author.getText();
        

    }

    public void back(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/BookActionsAdmin.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
