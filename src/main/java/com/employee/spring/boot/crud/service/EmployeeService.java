package com.employee.spring.boot.crud.service;

import java.util.List;

import com.employee.spring.boot.crud.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();

	public Employee findById(int theId);

	public void save(Employee employee);

	public void deleteById(int theId);

}
