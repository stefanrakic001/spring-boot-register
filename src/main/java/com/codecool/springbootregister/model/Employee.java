package com.codecool.springbootregister.model;

import com.codecool.springbootregister.util.AvailabilityType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;


@Component
@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private AvailabilityType availability;
    @OneToOne(fetch = FetchType.EAGER, optional = true)
    private Car car;
    private String construction;
    private String address;


    private LocalDate hireDate;

}
