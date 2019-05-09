package com.codecool.springbootregister.repository;

import com.codecool.springbootregister.model.Employee;
import com.codecool.springbootregister.model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SalaryRepository extends JpaRepository<Salary, Long> {


    List<Salary> findAllByEmployeeId(Long employeeId);

    List<Salary> findSalariesByEmployeeOrderByPaymentDateDesc(Employee employee);

    @Transactional
    void deleteByEmployee(Employee employee);
}
