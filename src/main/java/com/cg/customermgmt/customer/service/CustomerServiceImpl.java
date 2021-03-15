package com.cg.customermgmt.customer.service;

import java.time.LocalDateTime;

import java.util.*;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.customermgmt.customer.dao.IAccountRepository;
import com.cg.customermgmt.customer.dao.ICustomerRepository;
import com.cg.customermgmt.customer.entities.Account;
import com.cg.customermgmt.customer.entities.Customer;
import com.cg.customermgmt.customer.exceptions.*;
import com.cg.customermgmt.items.entities.Item;

@Service
public class CustomerServiceImpl implements ICustomerService{
	
//	@Autowired
//	ICustomerDao dao;
	
	@Autowired
	ICustomerRepository customerRepository;
	
	@Autowired
	IAccountRepository accountRepository;

	@Transactional
	@Override
	public Customer createCustomer(String name) {
//		validateName(name);
//		Account account = new Account();
//		Set<Item> set = new HashSet<>();
//		Customer customer = new Customer(name, account, set);
//		dao.add(customer);
		
		validateName(name);
		LocalDateTime now = LocalDateTime.now();
		Account account = new Account();
		account.setCreated(now);
		accountRepository.save(account);
		Set<Item> set = new HashSet<>();
		Customer customer = new Customer(name, account, set);
		customerRepository.save(customer);
		return customer;
	}

	@Override
	public Customer findById(Long customerId) {
//		Customer customer = dao.findById(customerId);
		
		Optional<Customer> optional = customerRepository.findById(customerId);
		if(!optional.isPresent()) {
			throw new CustomerNotFoundException("Customer with id "+customerId+" not found");
		}
		return optional.get();
	}

	@Transactional
	@Override
	public Customer addAmount(Long customerId, double amount) {
//		validateAmount(amount);
//		Customer customer = dao.findById(customerId);
//		customer.getAccount().setBalance(amount);
//		customer = dao.update(customer);
		
		validateAmount(amount);
		Customer customer = findById(customerId);
		customer.getAccount().setBalance(amount);
		customerRepository.save(customer);
		return customer;
	}

	@Override
	public Set<Item> itemsBoughtByCustomer(Long customerId) {
//		Customer customer = dao.findById(customerId);
//		Set<Item> itemSet = customer.getBoughtItems();
		Optional<Customer> optional = customerRepository.findById(customerId);
		if(!optional.isPresent()) {
			throw new CustomerNotFoundException("Customer with id "+customerId+" not found");
		}
		Customer customer = optional.get();
		Set<Item> itemSet = customer.getBoughtItems();
		return itemSet;
	}	
	
	public void validateName(String name) {
		if(name == null || name.isEmpty()) {
			throw new InvalidCustomerNameException("Name cannot be null or empty");
		}
	}
	
	public void validateAmount(double amount) {
		if(amount < 0) {
			throw new InvalidAmountException("Amount cannot be less than 0");
		}
	}


}
