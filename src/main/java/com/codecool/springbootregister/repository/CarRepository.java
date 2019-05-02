package com.codecool.springbootregister.repository;

import com.codecool.springbootregister.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Long> {
}
