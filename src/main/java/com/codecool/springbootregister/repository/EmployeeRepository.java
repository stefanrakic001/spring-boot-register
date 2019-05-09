package com.codecool.springbootregister.repository;

import com.codecool.springbootregister.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> getAllByAvailabilityTrue();

    Employee findEmployeeById(Long l);

    @Query(value =
            "SELECT * FROM employee ORDER BY id ; ",
            nativeQuery = true)
    List<Employee> getAllEmployeesOrderById();
}
