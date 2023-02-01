package com.assignment.EmpSystem.service;

import com.assignment.EmpSystem.dto.request.PostEmployeeRequestBody;
import com.assignment.EmpSystem.model.Employee;
import com.assignment.EmpSystem.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public ResponseEntity submitEmployee(PostEmployeeRequestBody postEmployeeRequestBody) {
        Employee employee = new Employee(postEmployeeRequestBody.getId(), postEmployeeRequestBody.getLogin(), postEmployeeRequestBody.getName(), postEmployeeRequestBody.getSalary());
        employeeRepository.save(employee);
        ResponseEntity responseEntity;
        String message = "Succesfully submitted Employee";
        responseEntity = ResponseEntity.ok().body(message);
        return responseEntity;
    }
}
