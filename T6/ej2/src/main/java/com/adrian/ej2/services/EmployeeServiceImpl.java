package com.adrian.ej2.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.adrian.ej2.domain.Gender;
import com.adrian.ej2.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private List<Employee> repository = new ArrayList<>();

    @Override
    public List<Employee> getAll() {
        return sortByName(repository);
    }

    @Override
    public Employee getById(long id) throws RuntimeException {
        for (Employee employee : repository) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        throw new RuntimeException("There%20is%20no%20employee%20with%20that%20id");
    }

    @Override
    public Employee add(Employee employee) throws RuntimeException {
        if (repository.contains(employee)) {
            throw new RuntimeException("The%20employee%20already%20exists");
        }
        repository.add(employee);
        return employee;
    }

    @Override
    public Employee edit(Employee employee) throws RuntimeException {
        int pos = repository.indexOf(employee);
        if (pos == -1) {
            throw new RuntimeException("The%20employee%20does%20not%20exist");
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

    @Override
    public List<Employee> searchByName(String name) {
        name = name.toLowerCase();
        List<Employee> employeesByName = new ArrayList<Employee>();
        for (Employee employee : repository) {
            if (employee.getName().toLowerCase().contains(name)) {
                employeesByName.add(employee);
            }
        }
        return sortByName(employeesByName);
    }

    @Override
    public List<Employee> filterByGender(Gender gender) {
        List<Employee> employeesByGender = new ArrayList<Employee>();
        for (Employee employee : repository) {
            if (employee.getGender() == gender) {
                employeesByGender.add(employee);
            }
        }
        return sortByName(employeesByGender);
    }

    private static List<Employee> sortByName(List<Employee> employees) {
        employees.sort(Comparator.comparing(Employee::getName));
        return employees;
    }
}
