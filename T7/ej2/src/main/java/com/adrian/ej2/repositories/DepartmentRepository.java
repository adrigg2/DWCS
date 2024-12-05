package com.adrian.ej2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adrian.ej2.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    
}
