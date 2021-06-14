package com.example.onlineTeaching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin("*")
@SpringBootApplication
public class OnlineTeachingApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineTeachingApplication.class, args);
	}

}
