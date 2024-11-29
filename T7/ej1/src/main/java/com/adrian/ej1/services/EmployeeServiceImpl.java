package com.adrian.ej1.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrian.ej1.domain.Gender;
import com.adrian.ej1.model.Employee;
import com.adrian.ej1.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    @Override
    public List<Employee> getAll() {
        return repository.findAll();
    }

    @Override
    public Employee getById(long id) throws RuntimeException {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("There%20is%20no%20employee%20with%20that%20id"));
    }

    @Override
    public Employee add(Employee employee) {
        return repository.save(employee);
    }

    @Override
    public Employee edit(Employee employee) throws RuntimeException {
        getById(employee.getId()); // Check if employee exists
        return repository.save(employee);
    }

    @Override
    public void delete(long id) throws RuntimeException {
        getById(id); // Check if employee exists
        repository.deleteById(id);
    }

    @Override
    public List<Employee> searchByName(String name) {
        return repository.findByNameOrderByNameAsc(name);
    }

    @Override
    public List<Employee> filterByGender(Gender gender) {
        return repository.findByGenderOrderByNameAsc(gender);
    }
}
