package com.example.empleado.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartamentoDto {
    private Long id;
    private String nombre;
    private Double presupuesto;
    private Integer numEmpleados;
}
