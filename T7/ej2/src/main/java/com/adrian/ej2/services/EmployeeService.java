package com.adrian.ej2.services;

import java.util.List;

import com.adrian.ej2.domain.Department;
import com.adrian.ej2.domain.Employee;
import com.adrian.ej2.domain.Gender;

public interface EmployeeService {
    List<Employee> getAll();
    Employee getById(long id);
    Employee add(Employee employee);
    Employee edit(Employee employee);
    void delete(long id);
    List<Employee> getEmployeesGreaterSalary(double salary);
    List<Employee> getEmployeesSalaryGreaterAverage();
    List<Employee> filterEmployees(String name, Gender gender, Department department);
}
