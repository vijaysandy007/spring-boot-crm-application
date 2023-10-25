package com.love2code.springboot.employeecrm.dao;

import com.love2code.springboot.employeecrm.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    void createEmployee(Employee employee);

    Employee findEmployee(int id);

    void updateEmployee(Employee employee);

    void deleteEmployee(Employee employee);
}
