package com.adrian.ej2.services;

import java.util.List;

import com.adrian.ej2.domain.Employee;

public interface EmployeeService {
    List<Employee> getAll();
    Employee getById(long id) throws RuntimeException;
    Employee add(Employee employee) throws RuntimeException;
    Employee edit(Employee employee) throws RuntimeException;
    void delete(long id) throws RuntimeException;
    List<Employee> getEmployeesGreaterSalary(double salary);
    List<Employee> getEmployeesSalaryGreaterAverage();
    List<Employee> filterEmployees(String name, String gender, String department);
}
