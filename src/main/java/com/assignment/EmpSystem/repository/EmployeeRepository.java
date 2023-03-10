package com.assignment.EmpSystem.repository;

import com.assignment.EmpSystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface EmployeeRepository extends  JpaRepository<Employee, Integer>, EmployeeRepositoryCustom{

}
