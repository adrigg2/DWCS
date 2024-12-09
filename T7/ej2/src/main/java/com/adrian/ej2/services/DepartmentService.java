package com.adrian.ej2.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.adrian.ej2.domain.Department;

@Service
public interface DepartmentService {
    Department add(Department department);
    List<Department> getAll();
    Department getById(long id);
    Department edit(Department department);
    void delete(long id);
    Department getByName(String name);
}
