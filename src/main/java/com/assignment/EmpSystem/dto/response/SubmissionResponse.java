package com.assignment.EmpSystem.dto.response;

import com.assignment.EmpSystem.model.Employee;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SubmissionResponse {

    private String ResponseMessage;

    public SubmissionResponse (String ResponseMessage) {
        this.ResponseMessage = ResponseMessage;
    }

}
