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
                .name("István Imre").build();

        employeeRepository.save(employee);

        Employee employee4 = Employee.builder()
                .address("Ló utca 2")
                .availability(AvailabilityType.AVAILABLE)
                .hireDate(LocalDate.now())
                .construction("Béla utca 23")
                .name("István Péter").build();
        employeeRepository.save(employee4);

        Employee employee1 = Employee.builder()
                .address("Ló utca 2")
                .availability(AvailabilityType.NOTAVAILABLE)

                .hireDate(LocalDate.now())
                .construction("Béla utca 23")
                .name("Imre Ádám").build();

        employeeRepository.save(employee1);

        Employee employee2 = Employee.builder()
                .address("Pillangó utca 2")
                .availability(AvailabilityType.SICKLEAVE)
                .hireDate(LocalDate.now())
                .construction("Ó utca 1")
                .name("Jó Pál").build();

        employeeRepository.save(employee2);

        Employee employee3 = Employee.builder()
                .address("Pillangó utca 2")
                .availability(AvailabilityType.HOLIDAY)
                .hireDate(LocalDate.now())
                .construction("Ó utca 1")
                .name("Kovács Zsolt").build();

        employeeRepository.save(employee3);

        Salary salary = Salary.builder()
                .amount(new BigDecimal(1000))
                .type(SalaryType.NORMAL)
                .employee(employee)
                .paymentDate(LocalDate.now())
                .build();

        Salary salary2 = Salary.builder()
                .amount(new BigDecimal(50))
                .type(SalaryType.INADVANCE)
                .employee(employee)
                .paymentDate(LocalDate.of(2001,2,4))
                .build();

        Salary salary3 = Salary.builder()
                .amount(new BigDecimal(1000))
                .type(SalaryType.NORMAL)
                .employee(employee)
                .paymentDate(LocalDate.of(2002,2,4))
                .build();

        Salary salary4 = Salary.builder()
                .amount(new BigDecimal(50))
                .type(SalaryType.INADVANCE)
                .employee(employee)
                .paymentDate(LocalDate.of(2003,2,4))
                .build();

        Salary salary5 = Salary.builder()
                .amount(new BigDecimal(1000))
                .type(SalaryType.NORMAL)
                .employee(employee)
                .paymentDate(LocalDate.of(2004,2,4))
                .build();

        Salary salary6 = Salary.builder()
                .amount(new BigDecimal(50))
                .type(SalaryType.INADVANCE)
                .employee(employee)
                .paymentDate(LocalDate.of(2005,2,4))
                .build();

        Salary salary7 = Salary.builder()
                .amount(new BigDecimal(1000))
                .type(SalaryType.NORMAL)
                .employee(employee)
                .paymentDate(LocalDate.of(2006,2,4))
                .build();

        Salary salary8 = Salary.builder()
                .amount(new BigDecimal(500))
                .type(SalaryType.NORMAL)
                .employee(employee)
                .paymentDate(LocalDate.of(2007,2,4))
                .build();

        Salary salary9 = Salary.builder()
                .amount(new BigDecimal(500))
                .type(SalaryType.NORMAL)
                .employee(employee)
                .paymentDate(LocalDate.of(2008,2,4))
                .build();

        Salary salary10 = Salary.builder()
                .amount(new BigDecimal(500))
                .type(SalaryType.NORMAL)
                .employee(employee)
                .paymentDate(LocalDate.of(2009,2,4))
                .build();


        Salary salary11 = Salary.builder()
                .amount(new BigDecimal(50))
                .type(SalaryType.INADVANCE)
                .employee(employee)
                .paymentDate(LocalDate.of(2010,2,2))
                .build();

        Salary salary12 = Salary.builder()
                .amount(new BigDecimal(500))
                .type(SalaryType.NORMAL)
                .employee(employee)
                .paymentDate(LocalDate.of(2011,2,2))
                .build();

        Salary salary13 = Salary.builder()
                .amount(new BigDecimal(50))
                .type(SalaryType.INADVANCE)
                .employee(employee)
                .paymentDate(LocalDate.of(2012,2,2))
                .build();

        Salary salary14 = Salary.builder()
                .amount(new BigDecimal(500))
                .type(SalaryType.NORMAL)
                .employee(employee)
                .paymentDate(LocalDate.of(2013,2,2))
                .build();

        salaryRepository.save(salary);
        salaryRepository.save(salary2);
        salaryRepository.save(salary3);
        salaryRepository.save(salary4);
        salaryRepository.save(salary5);
        salaryRepository.save(salary6);
        salaryRepository.save(salary7);
        salaryRepository.save(salary8);
        salaryRepository.save(salary9);
        salaryRepository.save(salary10);
        salaryRepository.save(salary11);
        salaryRepository.save(salary12);
        salaryRepository.save(salary13);
        salaryRepository.save(salary14);

        User user = new User("admin", encoder.encode("admin"), roles);

        roleRepository.save(new Role(RoleName.ROLE_USER));

        Role role = roleRepository.findByName(RoleName.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));

        roles.add(role);

        user.setRoles(roles);

        userRepository.save(user);


    }
}
