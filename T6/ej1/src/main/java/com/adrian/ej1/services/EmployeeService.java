package com.adrian.ej1.services;

import java.util.List;

import com.adrian.ej1.model.Employee;

public interface EmployeeService {
    List<Employee> getAll();
    Employee getById(long id);
    Employee add(Employee employee);
    Employee edit(Employee employee);
    void delete(long id);
}
