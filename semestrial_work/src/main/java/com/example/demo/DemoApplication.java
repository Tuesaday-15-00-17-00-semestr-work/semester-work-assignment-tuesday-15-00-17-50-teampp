package com.example.demo;

import com.example.demo.user.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import javafx.stage.Stage;
import javafx.application.Application;

@SpringBootApplication
//@RestController
public class DemoApplication {

	public static void main(String[] args) {

		//SpringApplication.run(DemoApplication.class, args);
		Application.launch(BookstoreApplication.class, args);
	}
}
