package com.codecool.springbootregister.model;

import com.codecool.springbootregister.util.Car;
import com.codecool.springbootregister.util.ConstructionAddress;
import com.codecool.springbootregister.util.Location;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

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
    private ConstructionAddress constructionAddress;
    private Location location;

    @Temporal(TemporalType.TIMESTAMP)
    private Date hireDate;

    @ManyToOne
    private Salary salary;

    public Employee(String name, boolean availability, Car car, ConstructionAddress constructionAddress, Location location, Date hireDate, Salary salary) {
        this.name = name;
        this.availability = availability;
        this.car = car;
        this.constructionAddress = constructionAddress;
        this.location = location;
        this.hireDate = hireDate;
        this.salary = salary;
    }

    public Employee() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getAvailability() {
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

    public ConstructionAddress getConstructionAddress() {
        return constructionAddress;
    }

    public void setConstructionAddress(ConstructionAddress constructionAddress) {
        this.constructionAddress = constructionAddress;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
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

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", availability=" + availability +
                ", car=" + car +
                ", constructionAddress=" + constructionAddress +
                ", location=" + location +
                ", hireDate=" + hireDate +
                ", salary=" + salary +
                '}';
    }
}
