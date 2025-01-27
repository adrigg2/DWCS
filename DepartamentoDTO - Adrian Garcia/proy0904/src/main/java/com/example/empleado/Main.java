package com.example.empleado;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.empleado.domain.Departamento;
import com.example.empleado.domain.Empleado;
import com.example.empleado.domain.Genero;
import com.example.empleado.services.DepartamentoService;
import com.example.empleado.services.EmpleadoService;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

	@Bean
	CommandLineRunner initData(EmpleadoService empleadoService, DepartamentoService departamentoService) {
		return args -> {
			departamentoService.add(new Departamento(0L, "Informática", 180000.0, 0, null));
			departamentoService.add(new Departamento(0L, "Comercial", 180000.0, 0, null));
			departamentoService.add(new Departamento(0L, "RRHH", 180000.0, 0, null));
			empleadoService.add(new Empleado(0L, "pepe", "pepe@gmail.com", 800d, true,
					Genero.MASCULINO,
					departamentoService.findByNombre("Informática")));
			empleadoService.add(new Empleado(0L, "ana", "ana@gmail.com", 900d, true,
					Genero.FEMENINO,
					departamentoService.findByNombre("Comercial")));
			empleadoService.add(new Empleado(0L, "luis", "luis@gmail.com", 2000d, true,
					Genero.FEMENINO, departamentoService.findByNombre("RRHH")));
			empleadoService.add(new Empleado(0L, "eva", "eva@gmail.com", 4000d, false,
					Genero.FEMENINO,
					departamentoService.findByNombre("Informática")));
		};
	}

}
