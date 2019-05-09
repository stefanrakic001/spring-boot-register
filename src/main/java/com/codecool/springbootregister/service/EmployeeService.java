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

    @Autowired
    SalaryService salaryService;

    public Employee createNewEmployee(Employee employee) {
        Car car;
        if(employee.getCar().getId() != null) {
            car = carRepository.findById(employee.getCar().getId())
                    .orElse(null);
        }else {
            car = null;
        }

        employee.setCar(car);
        return employeeRepository.save(employee);
    }

    public void deleteEmployee (Employee employee) {
        salaryService.deleteSalary(employee);
        employeeRepository.delete(employee);
    }

    public List<Employee> getAllAvailableEmployee() {
        return this.employeeRepository.getAllByAvailabilityTrue();
    }

    public List<Employee> getAllEmployee() {
        return this.employeeRepository.getAllEmployeesOrderById();
    }


    public Employee findById(long id) {
        return employeeRepository.findEmployeeById(id);
    }
}
