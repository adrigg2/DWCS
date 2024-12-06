package com.adrian.ej2.repositories;

import java.util.List;

import com.adrian.ej2.domain.Department;
import com.adrian.ej2.domain.Employee;
import com.adrian.ej2.domain.Gender;

public interface EmployeeRepositoryCustom {
    List<Employee> filterEmployees(String name, Gender gender, Department department);
}
