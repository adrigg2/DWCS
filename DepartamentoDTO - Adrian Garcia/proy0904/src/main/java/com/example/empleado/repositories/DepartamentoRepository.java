package com.example.empleado.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.empleado.domain.Departamento;

public interface DepartamentoRepository extends JpaRepository<Departamento, Long> {
    Departamento findByNombre(String nombre);
}
