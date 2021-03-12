package com.cg.customermgmt.customer.service;

import java.time.LocalDateTime;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.customermgmt.customer.dao.ICustomerDao;
import com.cg.customermgmt.customer.entities.Account;
import com.cg.customermgmt.customer.entities.Customer;

@Service
public class CustomerServiceImpl implements ICustomerService{
	
	@Autowired
	ICustomerDao dao;

	@Override
	public Customer createCustomer(String name) {
		LocalDateTime now = LocalDateTime.now();
		Account account = new Account(0, now);
		Customer customer = new Customer(name, account);
		dao.add(customer);
		return customer;
	}
	
	

}
