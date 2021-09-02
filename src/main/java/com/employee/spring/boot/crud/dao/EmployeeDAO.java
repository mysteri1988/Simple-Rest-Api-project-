package com.employee.spring.boot.crud.dao;

import java.util.List;

import com.employee.spring.boot.crud.entity.Employee;

public interface EmployeeDAO {

	public List<Employee> findAll();
}
