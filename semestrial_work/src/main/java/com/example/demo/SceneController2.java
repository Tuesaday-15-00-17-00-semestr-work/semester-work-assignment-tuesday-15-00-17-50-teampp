package com.example.demo;

import com.example.demo.user.UsersDat;
import com.example.demo.user.UsersDat;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.user.User;
import com.example.demo.user.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

@Component
public class SceneController2 {
    private Stage stageA;
    private Scene sceneA;
    private Parent root;

    @FXML
    private Label label;
    @FXML
    private TextField username_textfield;
    @FXML
    private TextField password_textfield;
    @FXML
    private TextField email_textfield;


    String username, password, email;
    int role = 0;

    @Autowired
    private UserService userService;

    @Autowired
    public void SceneController(UserService userService) {
        this.userService = userService;
    }

    public void submit2(ActionEvent event) throws IOException, SQLException {
        username = username_textfield.getText();
        password = password_textfield.getText();
        email = email_textfield.getText();
        //ValueToPass valueToPass = new ValueToPass();



        UsersDat dat = new UsersDat();
        if(dat.findRecord(username) == 1){
            dat.insertRecord(username, password, email);
            //valueToPass.setValue("0");
            SwitchToBookActionsUser(event);
        }
        else{
            label.setText("Username is used");
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

