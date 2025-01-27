package com.example.empleado.services;

import java.util.List;

import com.example.empleado.domain.Departamento;

public interface DepartamentoService {
    Departamento add(Departamento d);

    List<Departamento> findAll();

    Departamento findById(long id);

    Departamento edit(Departamento e);

    void delete(Long id);

    Departamento findByNombre(String nombre);

}
