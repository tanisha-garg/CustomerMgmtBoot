package com.cg.customermgmt.customer.dao;

import java.time.LocalDateTime;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.customermgmt.customer.entities.Account;
import com.cg.customermgmt.customer.entities.Customer;
import com.cg.customermgmt.customer.exceptions.CustomerNotFoundException;

@Repository
public class CustomerDaoImpl implements ICustomerDao{
	
	@Autowired
	private EntityManager entityManager;

	@Transactional
	@Override
	public Customer add(Customer customer) {
		LocalDateTime now = LocalDateTime.now();
		Account account = customer.getAccount();
		account.setCreated(now);
		entityManager.persist(account);
		entityManager.persist(customer);
		return customer;
	}

	@Override
	public Customer findById(Long customerId) {
		Customer customer = entityManager.find(Customer.class, customerId);
		if(customer == null) {
			throw new CustomerNotFoundException("Customer with id "+customerId+" doesn't exist");
		}
		return customer;
	}

	@Transactional
	@Override
	public Customer update(Customer customer) {
		customer = entityManager.merge(customer);
		return customer;
	}

}
