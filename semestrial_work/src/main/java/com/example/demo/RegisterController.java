package com.example.demo;

import com.example.demo.book.BooksDat;
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
import java.sql.SQLException;

public class RegisterController {

    private Stage stage;
    private Scene scene;
    private Parent root;


    @FXML
    private TextField title;
    @FXML
    private TextField author;
    @FXML
    private TextField isbn;
    @FXML
    private TextField available_copies;

    String tit, aut, is;
    int available;

    public void add_book(ActionEvent event) throws IOException, SQLException {
        tit = title.getText();
        aut = author.getText();
        is = isbn.getText();
        available = Integer.valueOf(available_copies.getText());

        BooksDat dat  = new BooksDat();
        dat.insertRecord(tit, aut, is, available);
    }

    public void back(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/BookActionsAdmin.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
