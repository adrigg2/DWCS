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

import com.example.empleado.domain.Departamento;
import com.example.empleado.dto.DepartamentoDto;
import com.example.empleado.dto.DepartamentoNuevoDto;
import com.example.empleado.services.DepartamentoDtoConverter;
import com.example.empleado.services.DepartamentoService;


@RestController
public class DepartamentoController {

    @Autowired
    public DepartamentoService departamentoService;

    @Autowired
    public DepartamentoDtoConverter departamentoDtoConverter;

    @GetMapping("/depto")
    public ResponseEntity<?> getList() {
        List<Departamento> listaDepartamento = departamentoService.findAll();
        if (listaDepartamento.isEmpty())
        {
            return ResponseEntity.notFound().build(); // cod 404
        }

        List<DepartamentoDto> listaDepartamentoDtos = new ArrayList<>();
        for (Departamento departamento : listaDepartamento) {
            listaDepartamentoDtos.add(departamentoDtoConverter.convertDepartamentoToDto(departamento));
        }
        return ResponseEntity.ok(listaDepartamentoDtos); // cod 200
    }

    @GetMapping("/depto/{id}")
    public ResponseEntity<?> getOneElement(@PathVariable Long id) {
        Departamento departamento = departamentoService.findById(id);
        if (departamento == null)
            return ResponseEntity.notFound().build(); // cod 404
        else
            return ResponseEntity.ok(departamento); // cod 200
    }

    @PostMapping("/depto")
    public ResponseEntity<?> newElement(@RequestBody DepartamentoNuevoDto departamentoNuevoDto) {
        Departamento departamento = departamentoDtoConverter.convertDtoToDepartamento(departamentoNuevoDto);
        Departamento departamentoSaved = departamentoService.add(departamento);
        return ResponseEntity.status(HttpStatus.CREATED).body(departamentoSaved); // cod 201
    }

    @PutMapping("/depto/{id}")
    public ResponseEntity<?> editElement(@RequestBody DepartamentoNuevoDto editDepartamento,
            @PathVariable Long id) {

        Departamento departamento = departamentoService.findById(id);
        if (departamento == null)
            return ResponseEntity.notFound().build(); // cod 404
        else {
            departamento = departamentoDtoConverter.convertDtoToDepartamento(editDepartamento, id);
            Departamento departamentoSaved = departamentoService.edit(departamento);
            return ResponseEntity.ok(departamentoSaved); // cod 200
        }
    }

    @DeleteMapping("/depto/{id}")
    public ResponseEntity<?> borrarProducto(@PathVariable Long id) {
        departamentoService.delete(id);
        return ResponseEntity.noContent().build(); // cod 204
    }

    @GetMapping("/depto/{id}/empleados")
    public ResponseEntity<?> getMethodName(@PathVariable Long id) {
        Departamento departamento = departamentoService.findById(id);
        if (departamento == null) {
            return ResponseEntity.notFound().build(); // cod 404
        }

        return ResponseEntity.ok(departamento.getEmpleados());
    }
    

}
