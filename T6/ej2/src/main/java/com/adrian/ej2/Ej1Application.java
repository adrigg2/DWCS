package com.adrian.ej2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.adrian.ej2.domain.Gender;
import com.adrian.ej2.model.Employee;
import com.adrian.ej2.services.EmployeeService;

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
			employeeService.add(new Employee(3L, "af", "ana@gmail.com", 28012312300.0, true, Gender.FEMALE));
			employeeService.add(new Employee(4L, "afgana", "ana@gmail.com", 28123000.0, true, Gender.MALE));
			employeeService.add(new Employee(5L, "asdf", "ana@gmail.com", 2801231300.0, true, Gender.MALE));
			employeeService.add(new Employee(6L, "asagasgna", "ana@gmail.com", 28012300.0, true, Gender.FEMALE));
			employeeService.add(new Employee(7L, "sdf", "ana@gmail.com", 280012310.0, true, Gender.MALE));
			employeeService.add(new Employee(8L, "asdfsfna", "ana@gmail.com", 2812313000.0, true, Gender.FEMALE));
			employeeService.add(new Employee(9L, "asf", "ana@gmail.com", 2802300.0, true, Gender.FEMALE));
			employeeService.add(new Employee(10L, "sdf", "ana@gmail.com", 21238000.0, true, Gender.FEMALE));
			employeeService.add(new Employee(11L, "sdf", "ana@gmail.com", 2802300.0, true, Gender.MALE));
			employeeService.add(new Employee(12L, "sdfsf", "ana@gmail.com", 28032423400.0, true, Gender.MALE));
		};
	}
}
