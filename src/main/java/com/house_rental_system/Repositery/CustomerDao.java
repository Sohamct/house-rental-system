package com.house_rental_system.Repositery;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.house_rental_system.Entity.Customer;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class CustomerDao {
	
private EntityManager entityManager;
	
	@Autowired
	public CustomerDao(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	public List<Customer> getCustomers() {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
				
		// create a query
		TypedQuery<Customer> theQuery =
				currentSession.createQuery("from Customer", Customer.class);
		
		// execute query and get result list
		List<Customer> Customers = theQuery.getResultList();

		currentSession.close();
		return Customers;
	}
	
	@Transactional
	public void addCustomer(final Customer Customer) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		currentSession.persist(Customer);
		currentSession.close();
	}
	public Customer getCustomer(final int id) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		Customer Customer = currentSession.get(Customer.class, id);
		currentSession.close();
		return Customer;
	}
	@Transactional
	public void deleteCustomer(final int customer_id) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		// create a query
//		TypedQuery<Customer> theQuery =
//			currentSession.createQuery("delete from Customer where id=:tid", Customer.class);
//		theQuery.setParameter("tid", id);
//		theQuery.executeUpdate();
		
		Customer Customer = currentSession.get(Customer.class, customer_id);
		currentSession.remove(Customer);
		currentSession.close();
				
	}

}
