package com.example.demo;

import com.example.demo.user.UsersDat;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AdministrationController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField username;

    public void delete(){
        UsersDat user = new UsersDat();
        user.deleteUser(username.getText());
    }

    public void upgrade(){
        UsersDat user = new UsersDat();
        user.changeRole(username.getText());
    }

    public void back(ActionEvent event) throws IOException {
        if(GlobalData.getInstance().getGlobalValue() == "1"){
            back_admin(event);
        }
        else{
            back_user(event);
        }

    }

    public void back_admin(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/BookActionsAdmin.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void back_user(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/BookActionsUser.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
