package com.assignment.EmpSystem.service;

import com.assignment.EmpSystem.dto.response.SubmissionResponse;
import com.assignment.EmpSystem.exception.IncorrectSalaryException;
import com.assignment.EmpSystem.model.Employee;
import com.assignment.EmpSystem.repository.EmployeeRepository;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.web.multipart.MultipartFile;


@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    EmployeeRepository employeeRepository;

    private static final Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);
    private Integer numOfRows;

    private static boolean checkSalaryFormatMoreThanOneDecimal (CSVRecord csvRecord) throws IncorrectSalaryException {

        String decimal;
        String number = csvRecord.get("salary");
        try {
            Float salary = Float.parseFloat(number);
            if (salary < 0) {
                throw new IncorrectSalaryException(HttpStatus.BAD_REQUEST, "Incorrect SalaryFormat (Salary less than 0) Please double check your record at Row : " + csvRecord.getRecordNumber() + csvRecord);
            }

            if (number.contains(".")) {
                decimal = number.split("\\.")[1];
                if (decimal.length() == 1) {
                    return false;
                }
                throw new IncorrectSalaryException(HttpStatus.BAD_REQUEST, "Incorrect SalaryFormat (More than 1 Decimal Point) Please double check your record at Row : " + csvRecord.getRecordNumber() + csvRecord);
            }
            throw new IncorrectSalaryException(HttpStatus.BAD_REQUEST, "Incorrect SalaryFormat (No Decimals) Please double check your record at Row : " + csvRecord.getRecordNumber() + csvRecord);

        } catch (IncorrectSalaryException e) {
            logger.error(
                    "Uploading CSV file ERROR. Error message: [{}]. HTTP Status: [{}].",
                    e.getErrorMessage(), e.getResponseStatus());
            throw e;
        }
    }

    @Override
    public ResponseEntity<SubmissionResponse> submitCSV(MultipartFile multipartFile) {
        ResponseEntity<SubmissionResponse> responseEntity = null;
        try (
                BufferedReader fileReader = new BufferedReader(new InputStreamReader(multipartFile.getInputStream(), "UTF-8"));
                CSVParser csvParser = new CSVParser(fileReader, CSVFormat.DEFAULT.builder()
                                                                                .setHeader()
                                                                                .setSkipHeaderRecord(true)
                                                                                .build()))
            {
                Iterable<CSVRecord> records = csvParser.getRecords();
                List<Employee> empList = new ArrayList<>();
                for (CSVRecord record : records) {
                    Employee emp = new Employee(
                            record.get("id"),
                            record.get("login"),
                            record.get("name"),
                            Double.parseDouble(record.get("salary"))
                    );
                    //Salary validation
                    checkSalaryFormatMoreThanOneDecimal(record);
                    

                    //If validation passes add employee to database
                    empList.add(emp);
                }
                numOfRows = empList.size();
                employeeRepository.saveAll(empList);
            } catch (IOException e) {

            } catch (IncorrectSalaryException e) {
            String errorMessage = e.getErrorMessage();
            responseEntity = ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new SubmissionResponse(errorMessage));
            return responseEntity;
        }


        String message = "Succesfully submitted CSV file. Rows Updated: " + this.numOfRows;
        responseEntity = ResponseEntity.ok().body(new SubmissionResponse(message));
        return responseEntity;
    }
}
