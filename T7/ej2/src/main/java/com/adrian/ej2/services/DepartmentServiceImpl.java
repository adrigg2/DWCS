package com.adrian.ej2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrian.ej2.domain.Department;
import com.adrian.ej2.repositories.DepartmentRepository;
import com.adrian.ej2.repositories.EmployeeRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository repository;

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public Department add(Department department) {
        return repository.save(department);
    }


    @Override
    public void delete(Long id) {
        Long employeeQuantity = employeeRepository.employeeAmountInDepartment(id);
        if (employeeQuantity == 0) {
            repository.deleteById(id);
        } else {
            throw new RuntimeException("You%20can%27delete%20a%20Department%20with%20employees");
        }
    }
    
}
