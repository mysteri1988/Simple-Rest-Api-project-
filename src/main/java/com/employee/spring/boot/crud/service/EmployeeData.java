package com.employee.spring.boot.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.spring.boot.crud.entity.Employee;
import com.employee.spring.boot.crud.repository.EmployeeRepository;

@Service("springDataService")
public class EmployeeData implements EmployeeService {

	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeData(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public List<Employee> findAll() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee findById(int theId) {
		return employeeRepository.findById(theId)
				.orElseThrow(() -> new RuntimeException("The Employee with id " + " isn't present in db"));
	}

	@Override
	public void save(Employee employee) {
		employeeRepository.save(employee);
	}

	@Override
	public void deleteById(int theId) {
		Employee empl = employeeRepository.findById(theId)
				.orElseThrow(() -> new RuntimeException("The Employee with id " + " isn't present in db"));
		employeeRepository.save(empl);
	}

}
