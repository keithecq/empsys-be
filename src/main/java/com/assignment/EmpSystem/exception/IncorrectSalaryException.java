package com.assignment.EmpSystem.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class IncorrectSalaryException extends Exception {
    private HttpStatus responseStatus;
    private String errorMessage;
}
