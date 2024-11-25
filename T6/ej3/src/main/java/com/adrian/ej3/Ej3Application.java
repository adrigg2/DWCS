package com.adrian.ej3;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.adrian.ej3.services.QuestionsService;

@SpringBootApplication
public class Ej3Application {

	public static void main(String[] args) {
		SpringApplication.run(Ej3Application.class, args);
	}

	@Bean
	CommandLineRunner initData(QuestionsService questionsService) {
		return args -> {
			questionsService.loadQuestions();
		};
	}
}
