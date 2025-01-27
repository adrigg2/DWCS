package com.example.empleado.dto;

import com.example.empleado.domain.Genero;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

// Se crea un DTO para la creación de un nuevo empleado
public class EmpleadoNuevoDto {
    private String nombre;
    private String email;
    private Double salario;
    private boolean enActivo;
    private Genero genero;
    private Long departamentoId;
}
