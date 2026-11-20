package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class DemoApplication {


	// Apenas isso >)
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}

}
