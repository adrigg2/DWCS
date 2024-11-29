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
		return _ -> {
			employeeService.add(new Employee(null, "pepe", "pepe@gmail.com", 250000.0, true, Gender.MALE));
			employeeService.add(new Employee(null, "ana", "ana@gmail.com", 28000.0, true, Gender.FEMALE));
			employeeService.add(new Employee(null, "af", "ana@gmail.com", 28012312300.0, true, Gender.FEMALE));
			employeeService.add(new Employee(null, "afgana", "ana@gmail.com", 28123000.0, true, Gender.MALE));
			employeeService.add(new Employee(null, "asdf", "ana@gmail.com", 2801231300.0, true, Gender.MALE));
			employeeService.add(new Employee(null, "asagasgna", "ana@gmail.com", 28012300.0, true, Gender.FEMALE));
			employeeService.add(new Employee(null, "sdf", "ana@gmail.com", 280012310.0, true, Gender.MALE));
			employeeService.add(new Employee(null, "asdfsfna", "ana@gmail.com", 2812313000.0, true, Gender.FEMALE));
			employeeService.add(new Employee(null, "asf", "ana@gmail.com", 2802300.0, true, Gender.FEMALE));
			employeeService.add(new Employee(null, "sdf", "ana@gmail.com", 21238000.0, true, Gender.FEMALE));
			employeeService.add(new Employee(null, "sdf", "ana@gmail.com", 2802300.0, true, Gender.MALE));
			employeeService.add(new Employee(null, "sdfsf", "ana@gmail.com", 28032423400.0, true, Gender.MALE));
		};
	}
}
