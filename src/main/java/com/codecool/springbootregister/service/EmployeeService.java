package com.codecool.springbootregister.service;

import com.codecool.springbootregister.model.Car;
import com.codecool.springbootregister.model.Employee;
import com.codecool.springbootregister.repository.CarRepository;
import com.codecool.springbootregister.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    CarRepository carRepository;


    public Employee createNewEmployee(Employee employee) {
        // TODO if car null, don't set it
        Car car = carRepository.getOne(employee.getCar().getId());
        employee.setCar(car);
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllAvailableEmployee() {
        return this.employeeRepository.getAllByAvailabilityTrue();
    }

    public List<Employee> getAllEmployee() {
        return this.employeeRepository.findAll();
    }


    public Employee findById(long id) {
        return employeeRepository.findEmployeeById(id);
    }
}
