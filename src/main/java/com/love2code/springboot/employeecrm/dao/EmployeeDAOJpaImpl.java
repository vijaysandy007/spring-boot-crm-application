package com.love2code.springboot.employeecrm.dao;

import com.love2code.springboot.employeecrm.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO{

    private EntityManager entityManager;

    public EmployeeDAOJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void createEmployee(Employee employee) {
         entityManager.persist(employee);;
    }
    @Override
    public Employee findEmployee(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> employees = entityManager.createQuery("FROM Employee", Employee.class);
        return employees.getResultList();
    }
    @Override
    @Transactional
    public void updateEmployee(Employee employee) {
        entityManager.merge(employee);
    }

    @Override
    @Transactional
    public void deleteEmployee(Employee employee) {
      entityManager.remove(employee);
    }
}
