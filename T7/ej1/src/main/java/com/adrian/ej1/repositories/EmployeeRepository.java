package com.adrian.ej1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adrian.ej1.model.Employee;
import com.adrian.ej1.domain.Gender;


public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByNameOrderByNameAsc(String name);
    List<Employee> findByGenderOrderByNameAsc(Gender gender);
}
