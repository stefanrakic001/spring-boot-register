package com.codecool.springbootregister.service;

import com.codecool.springbootregister.model.Employee;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void Should_Save_Employee(){
        Employee employee = new Employee();
        Employee saved = employeeService.createNewEmployee(employee);
        assertNotNull(saved);
    }

}