package com.codecool.springbootregister.config;

import com.codecool.springbootregister.model.*;
import com.codecool.springbootregister.repository.*;
import com.codecool.springbootregister.util.AvailabilityType;
import com.codecool.springbootregister.util.RoleName;
import com.codecool.springbootregister.util.SalaryType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
public class Init implements CommandLineRunner {

    private CarRepository carRepository;

    private PasswordEncoder encoder;

    private EmployeeRepository employeeRepository;

    private UserRepository userRepository;

    private RoleRepository roleRepository;

    private SalaryRepository salaryRepository;

    public Init(CarRepository carRepository, PasswordEncoder encoder, EmployeeRepository employeeRepository, UserRepository userRepository, RoleRepository roleRepository, SalaryRepository salaryRepository) {
        this.carRepository = carRepository;
        this.encoder = encoder;
        this.employeeRepository = employeeRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.salaryRepository = salaryRepository;
    }

    @Override
    public void run(String... args) {
        Set<Role> roles = new HashSet<>();
        Car myCar = Car.builder()
                .carType("BMW")
                .licencePlate("HTM-222").build();


        Employee employee = Employee.builder()
                .address("Ló utca 2")
                .availability(AvailabilityType.AVAILABLE)
                .car(myCar)
                .hireDate(LocalDate.now())
                .construction("Béla utca 23")
                .name("Meszaros Lorinc").build();

        employeeRepository.save(employee);

        Salary salary = Salary.builder()
                .amount(new BigDecimal(1000))
                .type(SalaryType.NORMAL)
                .employee(employee)
                .paymentDate(LocalDate.now())
                .build();

        Salary salary2 = Salary.builder()
                .amount(new BigDecimal(500))
                .type(SalaryType.NORMAL)
                .employee(employee)
                .paymentDate(LocalDate.of(2000,2,4))
                .build();

        Salary salary3 = Salary.builder()
                .amount(new BigDecimal(500))
                .type(SalaryType.NORMAL)
                .employee(employee)
                .paymentDate(LocalDate.of(2000,2,2))
                .build();

        salaryRepository.save(salary);
        salaryRepository.save(salary2);
        salaryRepository.save(salary3);

        User user = new User("admin", encoder.encode("admin"), roles);

        roleRepository.save(new Role(RoleName.ROLE_USER));

        Role role = roleRepository.findByName(RoleName.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));

        roles.add(role);

        user.setRoles(roles);

        userRepository.save(user);


    }
}
