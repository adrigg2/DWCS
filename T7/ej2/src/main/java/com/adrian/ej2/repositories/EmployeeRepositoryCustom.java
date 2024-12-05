package com.adrian.ej2.repositories;

import java.util.List;

import com.adrian.ej2.domain.Gender;
import com.adrian.ej2.model.Department;
import com.adrian.ej2.model.Employee;

public interface EmployeeRepositoryCustom {
    List<Employee> filterEmployees(String name, Gender gender, Department department);
}
