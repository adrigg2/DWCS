package com.adrian.ej2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrian.ej2.domain.Department;
import com.adrian.ej2.domain.Employee;
import com.adrian.ej2.domain.Gender;
import com.adrian.ej2.repositories.DepartmentRepository;
import com.adrian.ej2.repositories.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    @Autowired
    private DepartmentRepository departmentRepository;

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
        Double departmentExpenses = repository.getSalarySumByDepartment(employee.getDepartment().getId());
        Department department = departmentRepository.findById(employee.getDepartment().getId()).orElseThrow(() -> new RuntimeException("There%20is%20no%20department%20with%20that%20id"));
        Double departmentBudget = department.getAnnualBudget();
        
        if (departmentExpenses + employee.getSalary() > departmentBudget) {
            throw new RuntimeException("The%20inclusion%20of%20that%20employee%20would%20leave%20the%20department%20in%20red%20numbers");
        }

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
        return repository.findByNameContainingIgnoreCaseOrderByNameAsc(name);
    }

    @Override
    public List<Employee> filterByGender(Gender gender) {
        return repository.findByGenderOrderByNameAsc(gender);
    }

    @Override
    public List<Employee> getEmployeesGreaterSalary(double salary) {
        return repository.findBySalaryGreaterThanEqualOrderBySalary(salary);
    }

    @Override
    public List<Employee> getEmployeesSalaryGreaterAverage() {
        return repository.queryBySalaryOverAverage();    
    }
}
