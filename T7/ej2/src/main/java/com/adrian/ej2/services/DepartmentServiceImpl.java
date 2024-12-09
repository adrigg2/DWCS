package com.adrian.ej2.services;

<<<<<<< HEAD
import java.util.List;

=======
>>>>>>> casa
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrian.ej2.domain.Department;
import com.adrian.ej2.repositories.DepartmentRepository;
<<<<<<< HEAD
=======
import com.adrian.ej2.repositories.EmployeeRepository;
>>>>>>> casa

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
        return departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("There%20is%20no%20department%20with%20that%20id"));
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
            throw new RuntimeException("You%20can%27delete%20a%20Department%20with%20employees");
        }
    }
    
}
