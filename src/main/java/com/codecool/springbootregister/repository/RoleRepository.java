package com.codecool.springbootregister.repository;

import com.codecool.springbootregister.model.Role;
import com.codecool.springbootregister.util.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
