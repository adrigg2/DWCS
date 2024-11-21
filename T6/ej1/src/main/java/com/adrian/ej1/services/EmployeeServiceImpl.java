package com.adrian.ej1.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.adrian.ej1.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private List<Employee> repository = new ArrayList<>();

    @Override
    public List<Employee> getAll() {
        return repository;
    }

    @Override
    public Employee getById(long id) {
        for (Employee employee : repository) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public Employee add(Employee employee) {
        if (repository.contains(employee)) {
            return null;
        }
        repository.add(employee);
        return employee;
    }

    @Override
    public Employee edit(Employee employee) {
        int pos = repository.indexOf(employee);
        if (pos == -1) {
            return null;
        }
        repository.set(pos, employee);
        return employee;
    }

    @Override
    public void delete(long id) {
        Employee employee = this.getById(id);
        if (employee != null) {
            repository.remove(employee);
        }
    }
    
}
