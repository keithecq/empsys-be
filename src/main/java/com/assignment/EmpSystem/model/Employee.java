package com.assignment.EmpSystem.model;

import com.opencsv.bean.CsvBindByName;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Employee {
    @Id
    private String id;
    private String login;
    private String name;
    private Double salary;

    public Employee (String id, String login, String name, Double salary) {
        this.id = id;
        this.login = login;
        this.name = name;
        this.salary = salary;
    }
}
