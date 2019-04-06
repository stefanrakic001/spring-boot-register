package com.codecool.springbootregister.controller;

import com.codecool.springbootregister.model.Employee;
import com.codecool.springbootregister.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeService employeeService;
    private Employee employee;

    @Autowired
    public EmployeeController(EmployeeService employeeService, Employee employee) {
        this.employeeService = employeeService;
        this.employee = employee;
    }


    @PostMapping(value = "/createEmployee")
    public void createEmployee(@RequestBody Employee employeeInfo) {
        employeeService.createNewEmployee(employeeInfo);
    }


    @GetMapping(value = "/employees")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }


}
