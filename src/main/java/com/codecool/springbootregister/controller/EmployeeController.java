package com.codecool.springbootregister.controller;

import com.codecool.springbootregister.model.Employee;
import com.codecool.springbootregister.repository.EmployeeRepository;
import com.codecool.springbootregister.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    private EmployeeService employeeService;
    private Employee employee;
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeController(EmployeeService employeeService, Employee employee, EmployeeRepository employeeRepository) {
        this.employeeService = employeeService;
        this.employee = employee;
        this.employeeRepository = employeeRepository;
    }


    @RequestMapping(value = "/createEmployee", method = RequestMethod.POST)
    public void createEmployee(@RequestBody Employee employeeInfo) {
        employeeService.createNewEmployee(employeeInfo);
    }


    @GetMapping(value = "/employees")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }


    @PutMapping("/updateEmp/{id}")
    public Employee updateEmployee(@PathVariable(value = "id") Long id, @RequestBody Employee employeeDetails) {
        Employee employee = employeeRepository.findEmployeeById(id);

        employee.setAvailability(employeeDetails.getAvailability());
        employee.setCar(employeeDetails.getCar());
        employee.setConstructionAddress(employeeDetails.getConstructionAddress());
        employee.setLocation(employeeDetails.getLocation());
        employee.setName(employeeDetails.getName());

        Employee updatedEmployee = employeeRepository.save(employee);
        return updatedEmployee;
    }

    @DeleteMapping("delete/{id}")
    public void deleteEmployee(@PathVariable(value = "id") Long id) {
        employeeRepository.delete(employeeRepository.findEmployeeById(id));
    }



}
