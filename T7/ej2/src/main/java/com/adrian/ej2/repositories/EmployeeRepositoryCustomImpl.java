package com.adrian.ej2.repositories;

import java.util.ArrayList;
import java.util.List;

import com.adrian.ej2.domain.Gender;
import com.adrian.ej2.model.Department;
import com.adrian.ej2.model.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

public class EmployeeRepositoryCustomImpl implements EmployeeRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Employee> filterEmployees(String name, Gender gender, Department department) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> query = cb.createQuery(Employee.class);
        Root<Employee> employee = query.from(Employee.class);

        Path<String> namePath = employee.get("name");
        Path<Gender> genderPath = employee.get("gender");
        Path<Department> departmentPath = employee.get("department");

        List<Predicate> predicates = new ArrayList<>();
        
        if (name != null) {
            predicates.add(cb.like(cb.lower(namePath), "%" + name.toLowerCase() + "%")); // LowerCase for case unsensitive query
        }

        if (gender != null) {
            predicates.add(cb.equal(genderPath, gender));
        }

        if (department != null) {
            predicates.add(cb.equal(departmentPath, department));
        }

        query.select(employee).where(cb.and(predicates.toArray(new Predicate[predicates.size()])));

        return entityManager.createQuery(query).getResultList();
    }
    
}
