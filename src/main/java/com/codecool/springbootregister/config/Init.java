package com.codecool.springbootregister.config;

import com.codecool.springbootregister.model.Car;
import com.codecool.springbootregister.model.Employee;
import com.codecool.springbootregister.model.Role;
import com.codecool.springbootregister.model.User;
import com.codecool.springbootregister.repository.CarRepository;
import com.codecool.springbootregister.repository.EmployeeRepository;
import com.codecool.springbootregister.repository.RoleRepository;
import com.codecool.springbootregister.repository.UserRepository;
import com.codecool.springbootregister.util.AvailabilityType;
import com.codecool.springbootregister.util.RoleName;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

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

    public Init(CarRepository carRepository, PasswordEncoder encoder, EmployeeRepository employeeRepository, UserRepository userRepository, RoleRepository roleRepository) {
        this.carRepository = carRepository;
        this.encoder = encoder;
        this.employeeRepository = employeeRepository;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
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
                .name("István Péter").build();

        employeeRepository.save(employee);

        User user = new User("admin", encoder.encode("12345678"), roles);

        roleRepository.save(new Role(RoleName.ROLE_USER));

        Role role = roleRepository.findByName(RoleName.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));

        roles.add(role);

        user.setRoles(roles);

        userRepository.save(user);


    }
}
