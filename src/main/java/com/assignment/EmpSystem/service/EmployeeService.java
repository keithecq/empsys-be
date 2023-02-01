package com.assignment.EmpSystem.service;

import com.assignment.EmpSystem.dto.request.PostEmployeeRequestBody;
import com.assignment.EmpSystem.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {
    ResponseEntity submitEmployee(PostEmployeeRequestBody postEmployeeRequestBody);
}
