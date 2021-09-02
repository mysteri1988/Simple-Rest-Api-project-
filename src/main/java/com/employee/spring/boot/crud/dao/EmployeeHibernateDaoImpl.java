package com.employee.spring.boot.crud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.employee.spring.boot.crud.entity.Employee;

@Repository
public class EmployeeHibernateDaoImpl implements EmployeeDAO {

	private EntityManager entityManager;

	@Autowired
	public EmployeeHibernateDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public List<Employee> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> queryEmployees = currentSession.createQuery("from Employee", Employee.class);
		List<Employee> employees = queryEmployees.list();
		return employees;
	}

}
