package com.adrian.ej2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrian.ej2.domain.Employee;
import com.adrian.ej2.domain.EmployeeProject;
import com.adrian.ej2.domain.Project;
import com.adrian.ej2.repositories.EmployeeProjectRepository;

@Service
public class EmployeeProjectServiceImpl implements EmployeeProjectService {
    @Autowired
    private EmployeeProjectRepository employeeProjectRepository;

    @Override
    public EmployeeProject getById(Long id) throws RuntimeException {
        return employeeProjectRepository.findById(id).orElseThrow(() -> new RuntimeException("There is no employee project with that id"));
    }

    @Override
    public EmployeeProject add(EmployeeProject employeeProject) {
        return employeeProjectRepository.save(employeeProject);
    }

    @Override
    public void delete(EmployeeProject employeeProject) throws RuntimeException {
        getById(employeeProject.getId()); // Check if exists
        employeeProjectRepository.delete(employeeProject);
    }

    @Override
    public List<EmployeeProject> getByEmployee(Employee employee) {
        return employeeProjectRepository.findByEmployee(employee);
    }

    @Override
    public List<EmployeeProject> getByProject(Project project) {
        return employeeProjectRepository.findByProject(project);
    }

    @Override
    public EmployeeProject getByEmployeeAndProject(Employee e, Project p) {
        return employeeProjectRepository.findByEmployeeAndProject(e, p);
    }
    
}
