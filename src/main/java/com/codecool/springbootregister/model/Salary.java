package com.codecool.springbootregister.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Salary {

    @Id
    @Column(name = "salary_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long salaryId;

    private long normalSalary;

    private long salarayInAdvance;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "payment_date")
    private Date paymentDate;

    public long getNormalSalary() {
        return normalSalary;
    }

    public void setNormalSalary(long normalSalary) {
        this.normalSalary = normalSalary;
    }

    public long getSalarayInAdvance() {
        return salarayInAdvance;
    }

    public void setSalarayInAdvance(long salarayInAdvance) {
        this.salarayInAdvance = salarayInAdvance;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }
}
