package com.example.demo;

import com.example.demo.book.GlobalId;
import com.example.demo.user.UsersDat;
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
import java.util.Objects;

public class SceneController {
    private Stage stageA;
    private Scene sceneA;
    private Parent root;

    @FXML
    private Label label;
    @FXML
    private TextField username_textfield;
    @FXML
    private TextField password_textfield;


    String username, password, email;



    public void submit(ActionEvent event) throws IOException, SQLException {
        username = username_textfield.getText();
        password = password_textfield.getText();
        //ValueToPass valueToPass = new ValueToPass();

        UsersDat dat  = new UsersDat();
        if(dat.rightPassword(username, password) == 0){
            int user_id = dat.FindId(username);
            GlobalId.getInstance().setGlobalId(user_id);
            if(dat.findRole(username) == 0){
                GlobalData.getInstance().setGlobalValue("1");
                /*
                valueToPass.setValue("1");

                BrowseController b = new BrowseController(valueToPass);
                */
                SwitchToBookActionsAdmin(event);}
            else{
                //valueToPass.setValue("0");
                GlobalData.getInstance().setGlobalValue("0");
                SwitchToBookActionsUser(event);
            }
        }
        else{
            label.setText("Wrong Username or Wrong Password");
        }
    }


    public void SwitchToBookActionsAdmin(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/BookActionsAdmin.fxml"));
        stageA = (Stage)((Node)event.getSource()).getScene().getWindow();
        sceneA = new Scene(root);
        stageA.setScene(sceneA);
        stageA.show();
    }

    public void SwitchToBookActionsUser(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("/BookActionsUser.fxml"));
        stageA = (Stage)((Node)event.getSource()).getScene().getWindow();
        sceneA = new Scene(root);
        stageA.setScene(sceneA);
        stageA.show();
    }
}
