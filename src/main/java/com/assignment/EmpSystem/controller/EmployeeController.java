package com.assignment.EmpSystem.controller;

import com.assignment.EmpSystem.dto.request.PostEmployeeRequestBody;
import com.assignment.EmpSystem.model.Employee;
import com.assignment.EmpSystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping(path = "/submitEmployee", consumes = "application/json")
    public ResponseEntity submitEmploye(@RequestBody PostEmployeeRequestBody postEmployeeRequestBody) {
        ResponseEntity responseEntity = employeeService.submitEmployee(postEmployeeRequestBody);
        return responseEntity;
    }
}
