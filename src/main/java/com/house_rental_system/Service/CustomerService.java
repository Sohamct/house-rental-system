package com.house_rental_system.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.house_rental_system.Entity.Customer;
import com.house_rental_system.Repositery.CustomerDao;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerDao CustomerDao;

	public Customer getCustomer(final int customer_id) {
		return CustomerDao.getCustomer(customer_id);
	}

	public List<Customer> getCustomers() {
		return CustomerDao.getCustomers();
	}

	public void addCustomer(final Customer Customer) {
		CustomerDao.addCustomer(Customer);
	}
	public void deleteCustomer(final int id) {
		CustomerDao.deleteCustomer(id);
	}
}
