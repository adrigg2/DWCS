package com.adrian.ej1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.adrian.ej1.domain.Gender;
import com.adrian.ej1.model.Employee;
import com.adrian.ej1.services.EmployeeService;

@SpringBootApplication
public class Ej1Application {

	public static void main(String[] args) {
		SpringApplication.run(Ej1Application.class, args);
	}

	@Bean
	CommandLineRunner initData(EmployeeService employeeService) {
		return args -> {
			employeeService.add(new Employee(1L, "pepe", "pepe@gmail.com", 250000.0, true, Gender.MALE));
			employeeService.add(new Employee(2L, "ana", "ana@gmail.com", 28000.0, true, Gender.FEMALE));
		};
	}
}
