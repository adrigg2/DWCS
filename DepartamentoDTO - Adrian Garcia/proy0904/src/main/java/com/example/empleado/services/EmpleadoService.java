package com.example.empleado.services;

import java.util.List;

import com.example.empleado.domain.Empleado;

public interface EmpleadoService {
    Empleado add(Empleado e);

    List<Empleado> findAll();

    Empleado findById(long id);

    Empleado edit(Empleado e);

    int delete(Long id);

    int empleadosInDepartamento(Long id);
}
