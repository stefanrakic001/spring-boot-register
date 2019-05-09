package com.codecool.springbootregister.service;

import com.codecool.springbootregister.message.response.ResponseMessage;
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

    public ResponseMessage addSalaryToEmployee(Long employeeId, Salary salary){
        try {
            Employee employee = employeeRepository.findEmployeeById(employeeId);

            salary.setEmployee(employee);
            salaryRepository.save(salary);
            return new ResponseMessage("SUCCESS!");
        } catch (Exception e) {

            return new ResponseMessage(e.toString());
        }
    }


    public List<Salary> getLatestSalaryBy(Long employeeId) {
        Employee employee = employeeRepository.findEmployeeById(employeeId);
        try {
            return salaryRepository.findSalariesByEmployeeOrderByPaymentDateDesc(employee);

        } catch (Exception e) {
            log.info(e.toString());
            return new ArrayList<>();
        }
    }

    public void deleteSalary(Employee emloyee) {
        salaryRepository.deleteByEmployee(emloyee);
    }
}
