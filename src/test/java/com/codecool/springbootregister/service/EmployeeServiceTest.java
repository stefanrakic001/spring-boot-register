package com.codecool.springbootregister.service;

import com.codecool.springbootregister.model.Car;
import com.codecool.springbootregister.model.Employee;
import com.codecool.springbootregister.util.AvailabilityType;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
class EmployeeServiceTest {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void Should_Save_Employee(){
        Employee employee = Employee.builder()
                .address("Laszlo Utca")
                .id((long) 1)
                .car(new Car())
                .name("Peter Smith")
                .construction("Norway Street")
                .hireDate(LocalDate.now())
                .availability(AvailabilityType.SICKLEAVE)
                .build();

        Employee employee1 = employeeService.createNewEmployee(employee);

        assertNotNull(employee1);
    }

    @Test
    public void Should_GetEmployee_ById(){
        Employee employee = Employee.builder()
                .address("Laszlo Utca")
                .id((long) 1)
                .car(new Car())
                .name("Peter Smith")
                .construction("Norway Street")
                .hireDate(LocalDate.now())
                .availability(AvailabilityType.SICKLEAVE)
                .build();

        Employee saved = employeeService.createNewEmployee(employee);
        long id = saved.getId();

        assertEquals(saved, employeeService.findById(id));
    }

    @Test
    public void Should_GetAll_Employee(){

    }

}