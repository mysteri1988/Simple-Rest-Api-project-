package com.employee.spring.boot.crud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.spring.boot.crud.entity.Employee;

@Repository("jpaRepository")
public class EmployeeJPAEmpl implements EmployeeDAO {

	private EntityManager entityManager;

	@Autowired
	public EmployeeJPAEmpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Employee> findAll() {
		TypedQuery<Employee> theQuery=entityManager.createQuery("from Employee", Employee.class);
		List<Employee> employees=theQuery.getResultList();
		return employees;
	}

	@Override
	public Employee findById(int theId) {
 		Employee empl=entityManager.find(Employee.class, theId);
		return empl;
	}

	@Override
	public void save(Employee employee) {
		Employee dbEmployee = entityManager.merge(employee);
		employee.setId(dbEmployee.getId());
	}

	@Override
	public void deleteById(int theId) {
		Query theQuery = entityManager.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("employeeId", theId);
		theQuery.executeUpdate();
	}

}
