package com.assignment.EmpSystem.service;

import com.assignment.EmpSystem.dto.response.GetEmployeeListResponse;
import com.assignment.EmpSystem.dto.response.SubmissionResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface EmployeeService {
    ResponseEntity<SubmissionResponse> submitCSV(MultipartFile multipartFile);

    ResponseEntity<GetEmployeeListResponse> getEmployeeList();
}
