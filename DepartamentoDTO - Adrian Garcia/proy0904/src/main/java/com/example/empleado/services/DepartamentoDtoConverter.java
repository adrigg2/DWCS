package com.example.empleado.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.empleado.domain.Departamento;
import com.example.empleado.dto.DepartamentoDto;
import com.example.empleado.dto.DepartamentoNuevoDto;

@Component
public class DepartamentoDtoConverter {
    @Autowired
    public ModelMapper modelMapper;

    @Autowired
    public DepartamentoService departamentoService;

    // Para el caso de la creación (con PostMapping)
    public Departamento convertDtoToDepartamento(DepartamentoNuevoDto departamentoNuevoDto) {
        return new Departamento(null, departamentoNuevoDto.getNombre(), departamentoNuevoDto.getPresupuesto(), null, null);
    }
// Para el caso de la edición (con PutMapping)
    public Departamento convertDtoToDepartamento(DepartamentoNuevoDto departamentoEditDto, Long id) {
        Departamento departamento = convertDtoToDepartamento(departamentoEditDto);
        departamento.setId(id);
        departamento.setNumEmpleados(departamentoService.findById(id).getNumEmpleados());
        return departamento;
    }
// Para el caso de la lectura (con GetMapping)
    public DepartamentoDto convertDepartamentoToDto(Departamento departamento) {
        return modelMapper.map(departamento, DepartamentoDto.class);
    }
}
