package com.codecool.springbootregister.model;

import com.codecool.springbootregister.util.SalaryType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Salary {

    @Id
    @Column(name = "salary_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long salaryId;
    private long salary;

    @ManyToOne(fetch = FetchType.EAGER, optional = true)
    private Employee employee;

    private SalaryType salaryType;
    private LocalDate paymentDate;

}
