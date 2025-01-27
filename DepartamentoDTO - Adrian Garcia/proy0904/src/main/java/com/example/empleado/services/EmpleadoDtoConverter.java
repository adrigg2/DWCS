package com.example.empleado.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.empleado.domain.Empleado;
import com.example.empleado.dto.EmpleadoDto;
import com.example.empleado.dto.EmpleadoNuevoDto;

@Component
public class EmpleadoDtoConverter {

    @Autowired
    DepartamentoService departamentoService;

    @Autowired
    public ModelMapper modelMapper;

    // Para el caso de la creación (con PostMapping)
    public Empleado convertDtoToEmpleado(EmpleadoNuevoDto empleadoNuevoDto) {
        return new Empleado(null,
                empleadoNuevoDto.getNombre(),
                empleadoNuevoDto.getEmail(),
                empleadoNuevoDto.getSalario(),
                empleadoNuevoDto.isEnActivo(),
                empleadoNuevoDto.getGenero(),
                departamentoService.findById(empleadoNuevoDto.getDepartamentoId()));
    }
// Para el caso de la edición (con PutMapping)
    public Empleado convertDtoToEmpleado(EmpleadoNuevoDto empleadoEditDto, Long id) {
        Empleado empleado = convertDtoToEmpleado(empleadoEditDto);
        empleado.setId(id);
        return empleado;
    }
// Para el caso de la lectura (con GetMapping)
    public EmpleadoDto convertEmpleadoToDto(Empleado empleado) {
        return modelMapper.map(empleado, EmpleadoDto.class);
    }

}