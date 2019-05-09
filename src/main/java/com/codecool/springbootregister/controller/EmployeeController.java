package com.codecool.springbootregister.controller;

import com.codecool.springbootregister.message.response.ResponseMessage;
import com.codecool.springbootregister.model.Employee;
import com.codecool.springbootregister.repository.EmployeeRepository;
import com.codecool.springbootregister.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostMapping(value = "/createEmployee")
    public ResponseMessage createEmployee(@RequestBody Employee employeeInfo) {
        try {
            employeeService.createNewEmployee(employeeInfo);
            return new ResponseMessage("SUCCESS!");
        } catch (Exception e) {
            return new ResponseMessage(e.toString());
        }
    }


    @GetMapping(value = "/employees")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @PutMapping("/updateEmp/{id}")
    public ResponseMessage updateEmployee(@PathVariable(value = "id") Long id, @RequestBody Employee employeeDetails) {
       try {
        if(employeeDetails.getCar() == null){
            employeeDetails.setCar(null);
        }
        employeeRepository.save(employeeDetails);
        return new ResponseMessage("SUCCESS!");
       } catch (Exception e) {
           return new ResponseMessage(e.toString());
       }
    }

    @DeleteMapping("/{id}")
    public ResponseMessage deleteEmployee(@PathVariable(value = "id") Long id) {
        try {

            //employeeRepository.delete(employeeRepository.findEmployeeById(id));
            employeeService.deleteEmployee(employeeRepository.findEmployeeById(id));
            return new ResponseMessage("SUCCESS!");
        } catch (Exception e) {
            log.info(e.toString());
            return new ResponseMessage(e.toString());
        }
    }

}
