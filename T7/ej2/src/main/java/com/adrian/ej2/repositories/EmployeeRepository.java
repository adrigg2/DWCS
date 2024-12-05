package com.adrian.ej2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.adrian.ej2.domain.Gender;
import com.adrian.ej2.model.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Long>, EmployeeRepositoryCustom {
    List<Employee> findByNameContainingIgnoreCaseOrderByNameAsc(String name);
    List<Employee> findByGenderOrderByNameAsc(Gender gender);
    List<Employee> findBySalaryGreaterThanEqualOrderBySalary(double salary);

    @Query("select e from Employee e where e.salary > (select avg(e2.salary) from Employee e2)")
    List<Employee> queryBySalaryOverAverage();
}
