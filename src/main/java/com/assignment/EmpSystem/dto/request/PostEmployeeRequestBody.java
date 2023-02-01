package com.assignment.EmpSystem.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PostEmployeeRequestBody {

    private String id;
    private String login;
    private String name;
    private Float salary;

}
