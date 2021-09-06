package com.employee.spring.boot.crud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.spring.boot.crud.entity.Employee;
import com.employee.spring.boot.crud.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

	private EmployeeService emplService;

	@Autowired
	public EmployeeRestController(EmployeeService emplService) {
		this.emplService = emplService;
	}

	@GetMapping("/employees")
	public List<Employee> findAll() {
		return emplService.findAll();
	}

}
