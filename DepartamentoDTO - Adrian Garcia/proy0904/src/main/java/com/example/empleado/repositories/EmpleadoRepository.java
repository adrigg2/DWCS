package com.example.empleado.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.empleado.domain.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
    @Query("SELECT count(e) FROM Empleado e WHERE e.departamento.id = ?1")
    Integer countEmpleadosByIdDepartamento(Long id);
}
