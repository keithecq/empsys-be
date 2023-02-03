package com.assignment.EmpSystem.model;

import com.opencsv.bean.CsvBindByName;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Employee {
    @Id
    @Column(unique = true)
    private String id;
    @Column(unique = true)
    private String login;
    private String name;
    private String salary;

    public Employee (String id, String login, String name, String salary) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.salary = salary;
    }
}
