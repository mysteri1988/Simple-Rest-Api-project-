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
	public List<Employee> findAll() {
		Session currentSession = entityManager.unwrap(Session.class);
		Query<Employee> queryEmployees = currentSession.createQuery("from Employee", Employee.class);
		List<Employee> employees = queryEmployees.list();
		return employees;
	}

	@Override
	public Employee findById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Employee theEmployee = currentSession.get(Employee.class, theId);
		return theEmployee;
	}

	@Override
	public void save(Employee employee) {
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(employee);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public void deleteById(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		Query theQuery = currentSession.createQuery("delete from Employee where id=:employeeId");
		theQuery.setParameter("emploeeId", theId);
		theQuery.executeUpdate();
	}

}
