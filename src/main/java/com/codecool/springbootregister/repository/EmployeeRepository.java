package com.codecool.springbootregister.repository;

import com.codecool.springbootregister.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    public List<Employee> getAllByAvailabilityTrue();

}