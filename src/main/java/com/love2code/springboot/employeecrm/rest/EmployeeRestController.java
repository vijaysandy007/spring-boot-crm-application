package com.love2code.springboot.employeecrm.rest;

import com.love2code.springboot.employeecrm.dao.EmployeeDAO;
import com.love2code.springboot.employeecrm.entity.Employee;
import com.love2code.springboot.employeecrm.restresponse.RestPojoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1", produces = "application/json")
public class EmployeeRestController {

    private EmployeeDAO employeeDAO;

    public EmployeeRestController(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @PostMapping(value = "/employee")
    public Employee createEmployee(@RequestBody Employee requestBody){
        Employee employee = new Employee(requestBody.getFirstName(), requestBody.getLastName(),
                requestBody.getEmail());
      employeeDAO.createEmployee(employee);

      return  employee;
    }

    @GetMapping(value = "/employee/{userId}")
    public ResponseEntity<RestPojoResponse> findEmployeeById(@PathVariable("userId") int userId){
        Employee employee = employeeDAO.findEmployee(userId);
        RestPojoResponse restPojoResponse = new RestPojoResponse("Successfully fetched the employee list",
                true, 200, employee);
        return new ResponseEntity<>(restPojoResponse, HttpStatus.CREATED);
    }

    @GetMapping(value = "/employee")
    public ResponseEntity<RestPojoResponse>  findAllEmployee(){
        List<Employee> employees = employeeDAO.findAll();
        RestPojoResponse responsePojo = new RestPojoResponse("Successfully fetched the employee list",
                true, 200, employees);

        return new ResponseEntity<>(responsePojo, HttpStatus.CREATED);
    }

    @PatchMapping(value = "/employee/{userId}")
    public Employee updateEmployee(@PathVariable("userId") int userId, @RequestBody Employee requestBody){
        Employee updateObj = new Employee();
        updateObj.setId(userId);
        updateObj.setFirstName(requestBody.getFirstName());
        updateObj.setLastName(requestBody.getLastName());
        updateObj.setEmail(requestBody.getEmail());
        employeeDAO.updateEmployee(updateObj);
        Employee findEmployee = employeeDAO.findEmployee(userId);

        return findEmployee;
    }

    @DeleteMapping(value = "/employee/{userId}")
    public String deleteEmployee(@PathVariable("userId") int userId){
        Employee findEmployee = employeeDAO.findEmployee(userId);
        employeeDAO.deleteEmployee(findEmployee);
        return "Successfully deleted the employee";
    }
}
