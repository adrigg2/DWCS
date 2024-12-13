package com.adrian.ej2.services;

import java.util.List;

import com.adrian.ej2.domain.Department;

public interface DepartmentService {
    Department add(Department department);
    List<Department> getAll();
    Department getById(long id) throws RuntimeException;
    Department edit(Department department) throws RuntimeException;
    void delete(long id) throws RuntimeException;
    Department getByName(String name);
}
