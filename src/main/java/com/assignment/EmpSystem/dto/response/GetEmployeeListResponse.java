package com.assignment.EmpSystem.dto.response;

import com.assignment.EmpSystem.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class GetEmployeeListResponse {
    private List<Employee> employeeList;
}
