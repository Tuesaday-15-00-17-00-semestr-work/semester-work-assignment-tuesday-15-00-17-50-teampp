package com.example.demo;

import com.example.demo.user.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
//@RestController
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(DemoApplication.class, args);
	}
	/*
	@GetMapping
	public List<User> hello() {
		return List.of(
				new User(
						1,
						"patopoco",
						"123",
						1,
						"jbmnt"
				)
		);
	}
	*/
}
