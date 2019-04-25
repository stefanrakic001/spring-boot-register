package com.codecool.springbootregister.service;

import com.codecool.springbootregister.model.Employee;
import com.codecool.springbootregister.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;


    public Employee createNewEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllAvailableEmployee() {
        return this.employeeRepository.getAllByAvailabilityTrue();
    }

    public List<Employee> getAllEmployee() {
        return this.employeeRepository.findAll();
    }


}
