
package com.example.demo;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import org.apache.coyote.RequestInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;

import static org.apache.tomcat.util.file.ConfigFileLoader.getSource;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.util.Objects;

public class BookstoreApplication extends Application {

    private ConfigurableApplicationContext applicationContext;

    @Override
    public void init() {
        applicationContext = new SpringApplicationBuilder(BookstoreApplication.class).run();
    }

    @Override
    public void start(Stage primaryStage) {
        // Directly create a scene without using FXML

        try {
            //FXMLLoader fxmlLoader = new FXMLLoader(chartResource.getURL());
            //Parent parent = FXMLLoader.load(getClass().getResource("/chart.fxml"));
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/chart.fxml"));
            Parent root = fxmlLoader.load();
            primaryStage.setScene(new Scene(root));
            //primaryStage.setScene(new Scene(parent, 800,600));
            //primaryStage.setTitle("BookStore");
            //primaryStage.centerOnScreen();
            //primaryStage.setAlwaysOnTop(true);
            primaryStage.show();

        }catch (IOException e){
            throw new RuntimeException();
        }
    }

        /*
        StackPane root = new StackPane();
        root.getChildren().add(new Label("Hello from Spring Boot + JavaFX!"));
        Scene scene = new Scene(root, 800, 600);

        primaryStage.setTitle("JavaFX Window");
        primaryStage.setScene(scene);
        primaryStage.show();

        */


    @Override
    public void stop() {
        applicationContext.close();
    }

    public static void main(String[] args) {
        launch(args);
    }
}







/*
public class BookstoreApplication extends Application {

    private ConfigurableApplicationContext applicationContext;

    @Override
    public void init() {
        applicationContext = new SpringApplicationBuilder(BookstoreApplication.class).run();
    }

    @Override
    public void start(Stage primaryStage) {
        applicationContext.publishEvent(new StageReadyEvent(primaryStage));
    }

    @Override
    public void stop() {
        applicationContext.close();
        Platform.exit();
    }

    static class StageReadyEvent extends ApplicationEvent {
        public StageReadyEvent(Stage stage) {
            super(stage);
        }
        public Stage getStage() {
            return ((Stage) getSource());
        }
    }

    public static void main(String[] args) {
        // Launch the JavaFX application
        launch(args);
    }

}
*/