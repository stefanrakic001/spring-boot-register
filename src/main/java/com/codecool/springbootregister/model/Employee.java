package com.codecool.springbootregister.model;

import com.codecool.springbootregister.util.Car;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Component
@Entity
public class Employee {

    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;
    private boolean availability;
    private Car car;
    private String construction;

    @OneToOne(cascade=CascadeType.ALL)
    private Address location;

    @Temporal(TemporalType.TIMESTAMP)
    private Date hireDate;

    @ManyToOne(cascade=CascadeType.ALL)
    private Salary salary;

    public Employee() {
    }

    public Employee(String name, boolean availability, Car car, String construction, Address location, Date hireDate, Salary salary) {
        this.name = name;
        this.availability = availability;
        this.car = car;
        this.construction = construction;
        this.location = location;
        this.hireDate = hireDate;
        this.salary = salary;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getConstruction() {
        return construction;
    }

    public void setConstruction(String construction) {
        this.construction = construction;
    }

    public Address getLocation() {
        return location;
    }

    public void setLocation(Address location) {
        this.location = location;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public Salary getSalary() {
        return salary;
    }

    public void setSalary(Salary salary) {
        this.salary = salary;
    }
}
