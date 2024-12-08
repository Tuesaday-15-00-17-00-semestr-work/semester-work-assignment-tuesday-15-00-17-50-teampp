package com.example.demo;

import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import javafx.stage.Stage;

@Component
public class StageInitializer implements ApplicationListener<BookstoreApplication.StageReadyEvent> {
    @Override
    public void onApplicationEvent(BookstoreApplication.StageReadyEvent event) {
        Parent parent;
        Stage stage = event.getStage();
        stage.setScene(new Scene(parent, 800,600));
        //Group root = new Group();
        //Scene scene = new Scene(root);
        //stage.setScene(scene);
        stage.show();
    }
}
