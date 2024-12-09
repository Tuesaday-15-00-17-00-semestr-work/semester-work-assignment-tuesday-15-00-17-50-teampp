package com.example.demo;

/*
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import com.example.demo.BookstoreApplication.StageReadyEvent;

import javafx.stage.Stage;


import java.io.IOException;

@Component
public class StageInitializer implements ApplicationListener<StageReadyEvent> {
    @Value("classpath:/chart.fxml")
    private Resource chartResource;

    private String applicationTitle;

    public StageInitializer(@Value("Demo Title") String applicationTitle) {
        this.applicationTitle = applicationTitle;
    }

    @Override
    public void onApplicationEvent(StageReadyEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(chartResource.getURL());
            Parent parent = fxmlLoader.load();


            Stage stage = event.getStage();
            stage.setScene(new Scene(parent, 800,600));
            stage.setTitle(applicationTitle);
            stage.centerOnScreen();
            stage.setAlwaysOnTop(true);
            stage.show();
        }catch (IOException e){
            throw new RuntimeException();
        }
    }
}
*/