package com.adrian.ej2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.adrian.ej2.domain.Department;
import com.adrian.ej2.domain.Employee;
import com.adrian.ej2.domain.Gender;
import com.adrian.ej2.services.DepartmentService;
import com.adrian.ej2.services.EmployeeService;

@SpringBootApplication
public class ej2Application {

	public static void main(String[] args) {
		SpringApplication.run(ej2Application.class, args);
	}

	@Bean
	CommandLineRunner initData(EmployeeService employeeService, DepartmentService departmentService) {
		return _ -> {
			Department it = departmentService.add(new Department(null, "IT", 1e6));
			Department sales = departmentService.add(new Department(null, "Sales", 1e6));
			Department hr = departmentService.add(new Department(null, "Human Resources", 1e6));

			employeeService.add(new Employee(null, "pepe", "pepe@gmail.com", 250000.0, true, Gender.MALE, it, null));
			employeeService.add(new Employee(null, "ana", "ana@gmail.com", 28000.0, true, Gender.FEMALE, hr, null));
			employeeService.add(new Employee(null, "Ana Gómez", "ana.gomez@email.com", 25000.0, true, Gender.FEMALE, hr, null));
			employeeService.add(new Employee(null, "Juan Pérez", "juan.perez@email.com", 30000.0, true, Gender.MALE, sales, null));
			employeeService.add(new Employee(null, "Marta Sánchez", "marta.sanchez@email.com", 22000.0, false, Gender.FEMALE, sales, null));
			employeeService.add(new Employee(null, "Carlos Ruiz", "carlos.ruiz@email.com", 28500.0, true, Gender.MALE, it, null));
			employeeService.add(new Employee(null, "Beatriz López", "beatriz.lopez@email.com", 35000.0, true, Gender.FEMALE, it, null));
			employeeService.add(new Employee(null, "José Martínez", "jose.martinez@email.com", 27000.0, false, Gender.MALE, it, null));
			employeeService.add(new Employee(null, "Laura Fernández", "laura.fernandez@email.com", 24500.0, true, Gender.FEMALE, sales, null));
			employeeService.add(new Employee(null, "Enrique García", "enrique.garcia@email.com", 40000.0, true, Gender.MALE, sales, null));
			employeeService.add(new Employee(null, "Sofía Rodríguez", "sofia.rodriguez@email.com", 33000.0, true, Gender.FEMALE, hr, null));
			employeeService.add(new Employee(null, "Alex Navarro", "alex.navarro@email.com", 26000.0, false, Gender.OTHER, hr, null));
		};
	}
}
