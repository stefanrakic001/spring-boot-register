package com.codecool.springbootregister.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String city;
    private String address;
    private String zipCode;
    @OneToOne(mappedBy = "location")
    private Employee employee;
    @OneToOne(mappedBy = "location")
    private Construction construction;

}
