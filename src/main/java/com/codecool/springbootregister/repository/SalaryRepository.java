package com.codecool.springbootregister.repository;

import com.codecool.springbootregister.model.Employee;
import com.codecool.springbootregister.model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalaryRepository extends JpaRepository<Salary, Long> {


    List<Salary> findAllByEmployeeId(Long employeeId);
}
