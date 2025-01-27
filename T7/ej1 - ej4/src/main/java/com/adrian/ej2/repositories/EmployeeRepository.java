package com.adrian.ej2.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.adrian.ej2.domain.Employee;
import com.adrian.ej2.domain.Gender;
import com.adrian.ej2.domain.Department;


public interface EmployeeRepository extends JpaRepository<Employee, Long>, EmployeeRepositoryCustom {
    List<Employee> findByNameContainingIgnoreCaseOrderByNameAsc(String name);
    List<Employee> findByGenderOrderByNameAsc(Gender gender);
    List<Employee> findBySalaryGreaterThanEqualOrderBySalary(double salary);
    List<Employee> findByDepartment(Department department);

    @Query("select e from Employee e where e.salary > (select avg(e2.salary) from Employee e2)")
    List<Employee> queryBySalaryOverAverage();

    @Query("select count(e) from Employee e where e.department.id = ?1")
    Long employeeAmountInDepartment(Long departmentId);

    @Query("select sum(e.salary) from Employee e where e.department.id = ?1")
    Double getSalarySumByDepartment(Long departmentId);
}
