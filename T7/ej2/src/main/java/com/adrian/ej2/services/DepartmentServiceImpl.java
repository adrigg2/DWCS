package com.adrian.ej2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrian.ej2.model.Department;
import com.adrian.ej2.repositories.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentRepository repository;


    @Override
    public Department add(Department department) {
        return repository.save(department);
    }
    
}
