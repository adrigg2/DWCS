package com.adrian.ej2.services;

import java.util.List;

import com.adrian.ej2.domain.Employee;
import com.adrian.ej2.domain.EmployeeProject;
import com.adrian.ej2.domain.Project;

public interface EmployeeProjectService {
    EmployeeProject getById(Long id) throws RuntimeException;
    EmployeeProject add(EmployeeProject employeeProject);
    void delete(EmployeeProject employeeProject) throws RuntimeException;
    List<EmployeeProject> getByEmployee(Employee employee);
    List<EmployeeProject> getByProject(Project project);
    EmployeeProject getByEmployeeAndProject(Employee e, Project p);
}
