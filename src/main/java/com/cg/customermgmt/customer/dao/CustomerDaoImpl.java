package com.cg.customermgmt.customer.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.customermgmt.customer.entities.Customer;

@Repository
public class CustomerDaoImpl implements ICustomerDao{
	
	@Autowired
	private EntityManager entityManager;

	@Transactional
	@Override
	public Customer add(Customer customer) {
		entityManager.persist(customer);
		return customer;
	}

	@Override
	public Customer findById(Long customerId) {
		
		return null;
	}

	@Override
	public Customer update(Customer customer) {
		
		return null;
	}

}
