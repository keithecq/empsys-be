package com.assignment.EmpSystem.controller;

import com.assignment.EmpSystem.dto.response.SubmissionResponse;
import com.assignment.EmpSystem.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @PostMapping(path = "/submitCSV", produces = "application/json")
    public ResponseEntity<SubmissionResponse> submitCSV(@RequestParam("file") MultipartFile multipartFile) {
        ResponseEntity<SubmissionResponse> responseEntity = employeeService.submitCSV(multipartFile);
        return responseEntity;
    }
}
