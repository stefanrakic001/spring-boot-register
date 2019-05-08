package com.codecool.springbootregister.controller;

import com.codecool.springbootregister.model.Salary;
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

    @PostMapping("/add/id={id}")
    public boolean addToEmployee(@PathVariable("id") Long employeeId, @RequestBody Salary salary) {
        return salaryService.addSalaryToEmployee(employeeId, salary);
    }

    @GetMapping("/get/id={id}")
    public List<Salary> getSalariesByEmployeeId(@PathVariable("id") Long employeeId) {
        return salaryService.getSalariesByEmployeeId(employeeId);
    }

    @GetMapping("/latest/{employeeId}")
    public Salary getLatestSalaryBy(@PathVariable("employeeId") long employeeId){
        return salaryService.getLatestSalaryBy(employeeId);
    }
}
