package com.codecool.springbootregister.controller;

import com.codecool.springbootregister.model.Employee;
import com.codecool.springbootregister.model.Salary;
import com.codecool.springbootregister.repository.EmployeeRepository;
import com.codecool.springbootregister.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
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

    @PostMapping(value = "/createEmployee")
    public Employee createEmployee(@RequestBody Employee employeeInfo) {
        return employeeService.createNewEmployee(employeeInfo);
    }

    @PostMapping("/{employeeId}/addSalary")
    public Employee addSalaryToEmployee(@PathVariable("employeeId") long id, @RequestBody Salary salary){
        Employee employee = employeeService.findById(id);
        employee.setSalary(salary);
        return employee;
    }

    @GetMapping(value = "/employees")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @PutMapping("/updateEmp/{id}")
    public Employee updateEmployee(@PathVariable(value = "id") Long id, @RequestBody Employee employeeDetails) {
        Employee employee = employeeRepository.findEmployeeById(id);

        employee.setAvailability(employeeDetails.isAvailability());
        employee.setCar(employeeDetails.getCar());
        employee.setConstruction(employeeDetails.getConstruction());
        employee.setLocation(employeeDetails.getLocation());
        employee.setName(employeeDetails.getName());

        return employeeRepository.save(employee);
    }

    @DeleteMapping("delete/{id}")
    public void deleteEmployee(@PathVariable(value = "id") Long id) {
        employeeRepository.delete(employeeRepository.findEmployeeById(id));
    }

}
