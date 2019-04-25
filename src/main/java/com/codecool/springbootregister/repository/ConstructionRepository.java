package com.codecool.springbootregister.repository;

import com.codecool.springbootregister.model.Construction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConstructionRepository extends JpaRepository<Construction, Long> {
}
