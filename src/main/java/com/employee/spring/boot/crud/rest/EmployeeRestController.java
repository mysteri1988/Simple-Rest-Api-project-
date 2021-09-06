package com.employee.spring.boot.crud.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@GetMapping("/employees/{employeeId}")
	public Employee getEmployeeById(@PathVariable int employeeId) {
		Employee empl = emplService.findById(employeeId);
		if (empl == null) {
			throw new RuntimeException("Employee with id " + employeeId + " isn't present");
		}
		return empl;
	}

	@PostMapping("/employees")
	public Employee addEmployee(@RequestBody Employee empl) {
		empl.setId(0);
		emplService.save(empl);
		return empl;
	}

	@PutMapping("/employees")
	public void updateEmployee(@RequestBody Employee empl) {
		emplService.save(empl);
	}

	@DeleteMapping("/employees/{employeeId}")
	public void deleteEmployee(@PathVariable int employeeId) {
		Employee empl=emplService.findById(employeeId);
		if(empl==null) {
			throw new RuntimeException("Employee with id " + employeeId + " isn't present");
		}
		emplService.deleteById(employeeId);
	}

}
