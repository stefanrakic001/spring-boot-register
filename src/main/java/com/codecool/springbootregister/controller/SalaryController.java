package com.codecool.springbootregister.controller;

import com.codecool.springbootregister.message.response.ResponseMessage;
import com.codecool.springbootregister.model.Salary;
import com.codecool.springbootregister.repository.SalaryRepository;
import com.codecool.springbootregister.service.SalaryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/salary")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @Autowired
    private SalaryRepository salaryRepository;

    @PostMapping("/id={id}")
    public ResponseMessage addToEmployee(@PathVariable("id") Long employeeId, @RequestBody Salary salary) {
        return salaryService.addSalaryToEmployee(employeeId, salary);
    }

    @GetMapping("/id={id}")
    public List<Salary> getSalariesByEmployeeId(@PathVariable("id") Long employeeId) {
        return salaryService.getLatestSalaryBy(employeeId);
    }

    @DeleteMapping("/id={id}")
    public ResponseMessage deleteSalaryById(@PathVariable("id") Long salaryId) {
        try {
            salaryRepository.deleteById(salaryId);
            return new ResponseMessage("SUCCESS!");
        } catch (Exception e) {
            return new ResponseMessage(e.toString());
        }
    }



}
