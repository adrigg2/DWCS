package com.adrian.ej1.services;

import java.util.List;

import com.adrian.ej1.model.Employee;
import com.adrian.ej1.domain.Gender;

public interface EmployeeService {
    List<Employee> getAll();
    Employee getById(long id);
    Employee add(Employee employee);
    Employee edit(Employee employee);
    void delete(long id);
    List<Employee> searchByName(String name);
    List<Employee> filterByGender(Gender gender);
}
