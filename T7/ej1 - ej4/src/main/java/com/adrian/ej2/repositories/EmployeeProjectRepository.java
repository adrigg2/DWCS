package com.adrian.ej2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adrian.ej2.domain.Employee;
import com.adrian.ej2.domain.EmployeeProject;
import com.adrian.ej2.domain.Project;

public interface EmployeeProjectRepository extends JpaRepository<EmployeeProject, Long> {
    List<EmployeeProject> findByEmployee(Employee employee);
    List<EmployeeProject> findByProject(Project project);
    EmployeeProject findByEmployeeAndProject(Employee emp, Project proj);
}
