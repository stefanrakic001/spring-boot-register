package com.codecool.springbootregister.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Construction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(cascade = {CascadeType.ALL})
    private Address location;
    @OneToMany(mappedBy = "construction")
    private Set<Employee> employees = new HashSet<>();

    public Construction(Address location, Set<Employee> employees) {
        this.location = location;
        this.employees = employees;
    }

    public Construction(Address location) {
        this.location = location;
    }

    public Construction() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Address getLocation() {
        return location;
    }

    public void setLocation(Address location) {
        this.location = location;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}
