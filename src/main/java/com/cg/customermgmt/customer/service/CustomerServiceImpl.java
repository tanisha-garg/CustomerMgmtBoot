package com.cg.customermgmt.customer.service;

import java.time.LocalDateTime;
import java.util.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.customermgmt.customer.dao.ICustomerDao;
import com.cg.customermgmt.customer.entities.Account;
import com.cg.customermgmt.customer.entities.Customer;
import com.cg.customermgmt.items.entities.Item;

@Service
public class CustomerServiceImpl implements ICustomerService{
	
	@Autowired
	ICustomerDao dao;
	
	@Autowired
	EntityManager entityManager;

	@Transactional
	@Override
	public Customer createCustomer(String name) {
		LocalDateTime now = LocalDateTime.now();
		Account account = new Account(0, now);
		entityManager.persist(account);
		Customer customer = new Customer(name, account);
		dao.add(customer);
		return customer;
	}

	@Override
	public Customer findById(Long customerId) {
		Customer customer = dao.findById(customerId);
		return customer;
	}

	@Transactional
	@Override
	public Customer addAmount(Long customerId, double amount) {
		Customer customer = dao.findById(customerId);
		customer.getAccount().setBalance(amount);
		customer = dao.update(customer);
		return customer;
	}

//	@Override
//	public Set<Item> itemsBoughtByCustomer(Long customerId) {
//		Customer customer = entityManager.find(Customer.class, customerId);
//		Set<Item> itemSet = customer.getBoughtItems();
//		return itemSet;
//	}
	
	
	

}
