package com.cg.customermgmt.customer.service;

import java.time.LocalDateTime;

import java.util.*;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.customermgmt.customer.dao.ICustomerDao;
import com.cg.customermgmt.customer.entities.Account;
import com.cg.customermgmt.customer.entities.Customer;
import com.cg.customermgmt.customer.exceptions.InvalidCustomerNameException;
import com.cg.customermgmt.items.entities.Item;

@Service
public class CustomerServiceImpl implements ICustomerService{
	
	@Autowired
	ICustomerDao dao;

	@Transactional
	@Override
	public Customer createCustomer(String name) {
		validateName(name);
		Account account = new Account();
		Set<Item> set = new HashSet<>();
		Customer customer = new Customer(name, account, set);
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

	@Override
	public Set<Item> itemsBoughtByCustomer(Long customerId) {
		Customer customer = dao.findById(customerId);
		Set<Item> itemSet = customer.getBoughtItems();
		return itemSet;
	}
	
	public void validateName(String name) {
		if(name == null || name.isEmpty()) {
			throw new InvalidCustomerNameException("Name cannot be null or empty");
		}
	}
	

}
