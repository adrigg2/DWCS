package com.adrian.ej2.services;

import com.adrian.ej2.domain.Department;

public interface DepartmentService {
    Department add(Department department);
    void delete(Long id);
}
