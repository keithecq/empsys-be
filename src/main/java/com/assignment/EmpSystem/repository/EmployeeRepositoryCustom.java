package com.assignment.EmpSystem.repository;

import com.assignment.EmpSystem.model.Employee;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
public interface EmployeeRepositoryCustom {

    Employee findBylogin(String login);
    @Modifying
    @Query ("UPDATE Employee e SET e.login = ?2, e.name = ?3, e.salary = ?4 WHERE e.id = ?1")
    void setNewUserInfo(String id, String login, String name, Double salary);

    Employee findById (String id);
}
