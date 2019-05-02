package com.codecool.springbootregister.service;

import com.codecool.springbootregister.model.Employee;
import com.codecool.springbootregister.model.Salary;
import com.codecool.springbootregister.repository.EmployeeRepository;
import com.codecool.springbootregister.repository.SalaryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class SalaryService {

    @Autowired
    private SalaryRepository salaryRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    public boolean addSalaryToEmployee(Long employeeId, Salary salary){
        try {
            Employee employee = employeeRepository.findEmployeeById(employeeId);

            salary.setEmployee(employee);
            salaryRepository.save(salary);
            return true;
        } catch (Exception e) {
            log.info(e.toString());
            return false;
        }
    }

    public List<Salary> getSalariesByEmployeeId(Long employeeId) {
        try {
            return salaryRepository.findAllByEmployeeId(employeeId);
        } catch (Exception e) {
            log.info(e.toString());
        }
        return new ArrayList<>();
    }
}
