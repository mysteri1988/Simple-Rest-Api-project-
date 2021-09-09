package com.employee.spring.boot.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.employee.spring.boot.crud.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
