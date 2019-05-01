package com.codecool.springbootregister.config;

import com.codecool.springbootregister.model.Employee;
import com.codecool.springbootregister.model.Role;
import com.codecool.springbootregister.model.User;
import com.codecool.springbootregister.repository.RoleRepository;
import com.codecool.springbootregister.repository.UserRepository;
import com.codecool.springbootregister.util.RoleName;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class Init implements CommandLineRunner {

    private PasswordEncoder encoder;

    private UserRepository userRepository;

    private RoleRepository roleRepository;

    public Init(PasswordEncoder encoder, UserRepository userRepository, RoleRepository roleRepository) {
        this.encoder = encoder;
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void run(String... args) {
        Set<Role> roles = new HashSet<>();
        User user = new User("admin", encoder.encode("12345678"), roles);

        roleRepository.save(new Role(RoleName.ROLE_USER));

        Role role = roleRepository.findByName(RoleName.ROLE_USER)
                .orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));

        roles.add(role);

        user.setRoles(roles);

        userRepository.save(user);


    }
}
