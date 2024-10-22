package com.adrian.ej4;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.adrian.ej4.services.CountryService;

@SpringBootApplication
public class Ej4Application {

	public static void main(String[] args) {
		SpringApplication.run(Ej4Application.class, args);
	}

	@Bean
	CommandLineRunner initData(CountryService countryService) {
		return args -> {
			countryService.loadCountriesFromFile();
		};
	}
}
