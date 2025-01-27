package com.example.empleado.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.empleado.domain.Empleado;
import com.example.empleado.dto.EmpleadoDto;
import com.example.empleado.dto.EmpleadoNuevoDto;
import com.example.empleado.services.DepartamentoService;
import com.example.empleado.services.EmpleadoDtoConverter;
import com.example.empleado.services.EmpleadoService;

@RestController
public class EmpleadoController {
    @Autowired
    public EmpleadoService empleadoService;
    @Autowired
    public DepartamentoService departamentoService;

    //Inyectamos el componente EmpleadoDtoConverter para poder usarlo en los métodos
    @Autowired
    public EmpleadoDtoConverter empleadoDtoConverter;
//Visualización de todos los empleados
    @GetMapping("/empleado")
    public ResponseEntity<?> getList() {
        List<Empleado> listaEmpleados = empleadoService.findAll();
        if (listaEmpleados.isEmpty())
            return ResponseEntity.notFound().build(); // cod 404
        else {
            List<EmpleadoDto> listaEmpleadoDto = new ArrayList<>();
            for (Empleado empleado : listaEmpleados)
                listaEmpleadoDto.add(empleadoDtoConverter.convertEmpleadoToDto(empleado));
            return ResponseEntity.ok(listaEmpleadoDto); // cod 200
        }
    }
//Visualización de un solo empleado
    @GetMapping("/empleado/{id}")
    public ResponseEntity<?> getOneElement(@PathVariable Long id) {
        Empleado empleado = empleadoService.findById(id);
        if (empleado == null)
            return ResponseEntity.notFound().build(); // cod 404
        else
            return ResponseEntity.ok(empleado); // cod 200
    }
//Creación de un nuevo empleado
    @PostMapping("/empleado")
    public ResponseEntity<?> newElement(@RequestBody EmpleadoNuevoDto empleadoNuevoDto) {
        //Al inyectar el componente EmpleadoDtoConverter, podemos usarlo para convertir el DTO en un objeto Empleado
        //y no necesitamos hacerlo manualmente con las siguientes líneas comentadas

        // Empleado empleado = new Empleado(
        // empleadoNuevoDTO.getNombre(),
        // empleadoNuevoDTO.getEmail(),
        // empleadoNuevoDTO.getSalario(),
        // empleadoNuevoDTO.isEnActivo(),
        // empleadoNuevoDTO.getGenero(),
        // departamentoService.findById(empleadoNuevoDTO.getDepartamentoId()));

        Empleado empleado = empleadoDtoConverter.convertDtoToEmpleado(empleadoNuevoDto);
        Empleado empleadoSaved = empleadoService.add(empleado);
        return ResponseEntity.status(HttpStatus.CREATED).body(empleadoSaved); // cod 201
    }
//Edición de un empleado
    @PutMapping("/empleado/{id}")
    public ResponseEntity<?> editElement(@RequestBody EmpleadoNuevoDto editEmpleado,
            @PathVariable Long id) {

        Empleado empleado = empleadoService.findById(id);
        if (empleado == null)
            return ResponseEntity.notFound().build(); // cod 404
        else {
        //Al inyectar el componente EmpleadoDtoConverter, podemos usarlo para convertir el DTO en un objeto Empleado
        //y no necesitamos hacerlo manualmente con las siguientes líneas comentadas

            // empleado = new Empleado(
            // id,
            // editEmpleado.getNombre(),
            // editEmpleado.getEmail(),
            // editEmpleado.getSalario(),
            // editEmpleado.isEnActivo(),
            // editEmpleado.getGenero(),
            // departamentoService.findById(editEmpleado.getDepartamentoId()));

            empleado = empleadoDtoConverter.convertDtoToEmpleado(editEmpleado, id);
            Empleado empleadoSaved = empleadoService.edit(empleado);
            return ResponseEntity.ok(empleadoSaved); // cod 200
            //Va a devolver más datos de los que introducimos (nombre del departamento)
        }
    }
//Borrado de un empleado
    @DeleteMapping("/empleado/{id}")
    public ResponseEntity<?> borrarEmpleado(@PathVariable Long id) {
        empleadoService.delete(id);
        return ResponseEntity.noContent().build(); // cod 204
    }

}
