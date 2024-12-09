module com.example.demo {
    // JavaFX modules required for the UI components
    requires javafx.controls;
    requires javafx.fxml;


    // Spring Boot modules
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;
    requires spring.web;
    requires spring.beans;
    requires spring.data.jpa;
    requires org.apache.tomcat.embed.core;
    requires jakarta.persistence;
    requires spring.core;

    opens com.example.demo to javafx.fxml;

    // Expose your main package to be accessible by other modules
    exports com.example.demo;
}

