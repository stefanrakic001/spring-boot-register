package com.codecool.springbootregister.controller;


import com.codecool.springbootregister.model.Car;
import com.codecool.springbootregister.repository.CarRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("car")
public class CarController {

    @Autowired
    CarRepository carRepository;

    @GetMapping("/list")
    public List<Car> getCars() {
        return carRepository.findAll();
    }
}
