package com.infosys.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.infosys.entity.Employee;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;
import jakarta.persistence.Query;

@Repository("EmployeeRepository")
public class EmployeeDAOImpl implements EmployeeDAO{
	private EntityManagerFactory entityManagerFactory;
	
	@PersistenceUnit
	public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
		this.entityManagerFactory = entityManagerFactory;
	}
	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		Query query = entityManager.createQuery("select c from Employee c");
		
		return (List<Employee>)query.getResultList();
	}
	@Override
	public void insertEmp(Employee emp) {
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(emp);
		entityManager.getTransaction().commit();
	}
	@Override
	public Employee searchEmp(int id) {
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Employee emp = entityManager.find(Employee.class, id);
		return emp;
	}
	@Override
	public void updateEmp(int id, String name) {
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		Employee emp = entityManager.find(Employee.class, id);
		emp.setEmp_name(name);
		entityManager.getTransaction().commit();
	}
	@Override
	public void removeEmp(int id) {
		EntityManager entityManager = this.entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		 
		try {
			Employee emp = entityManager.find(Employee.class, id);
			entityManager.remove(emp);
			entityManager.getTransaction().commit();
		}
		catch(Exception exp) {
			System.out.println("Id not found");
			entityManager.getTransaction().rollback();
		}
	}

}
