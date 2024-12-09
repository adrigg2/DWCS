package com.adrian.ej2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrian.ej2.domain.Department;
import com.adrian.ej2.repositories.DepartmentRepository;
import com.adrian.ej2.repositories.EmployeeRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired 
    private EmployeeRepository employeeRepository;

    @Override
    public Department add(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    public List<Department> getAll() {
        return departmentRepository.findAll();
    }

    @Override
    public Department getById(long id) {
        return departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("There is no department with that id"));
    }

    @Override
    public Department edit(Department department) {
        getById(department.getId()); // Check if department exists
        return departmentRepository.save(department);
    }

    @Override
    public Department getByName(String name) {
        return departmentRepository.findByName(name);
    }

    @Override
    public void delete(long id) {
        getById(id);
        Long employeeQuantity = employeeRepository.employeeAmountInDepartment(id);
        if (employeeQuantity == 0) {
            departmentRepository.deleteById(id);
        } else {
            throw new RuntimeException("You can't delete a Department with employees");
        }
    }
    
}
