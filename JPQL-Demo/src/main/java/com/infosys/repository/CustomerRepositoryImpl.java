package com.infosys.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.infosys.domain.Customers;
import com.infosys.dto.Customersdto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class CustomerRepositoryImpl implements CustomerRepository{
	
	@PersistenceContext
	private EntityManager entityManager;


	// Direct way 
//	@Override
//	public List<Customers> getCustomerdetails() {
//		// TODO Auto-generated method stub
//		
//		String queryString = "select c from Customers c";
//		Query query = entityManager.createQuery(queryString);
//		List<Customers> customers = query.getResultList();
//		return customers;
//	}
	
	
	@Override
	public List<Customersdto> getCustomerdetails() {
		// TODO Auto-generated method stub
		List<Customersdto> custdto = null;
		String queryString = "select c from Customers c";
		Query query = entityManager.createQuery(queryString);
		List<Customers> customers = query.getResultList();
		custdto = new ArrayList<>();
		for(Customers cEntity:customers) {
			Customersdto customersdto = new Customersdto();
			customersdto.setCustomerid(cEntity.getCustomerid());
			customersdto.setActive(cEntity.getActive());
			customersdto.setCreditpoints(cEntity.getCreditpoints());
			customersdto.setFirstname(cEntity.getFirstname());
			customersdto.setLastname(cEntity.getLastname());
			customersdto.setEmail(cEntity.getEmail());
			customersdto.setContactnumber(cEntity.getContactnumber());
			custdto.add(customersdto);
		}
		return custdto;
	}
	

}
