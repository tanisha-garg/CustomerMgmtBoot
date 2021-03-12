package com.cg.customermgmt.customer.service;

import com.cg.customermgmt.customer.entities.Customer;

public interface ICustomerService {
	
	Customer findById(Long customerId);
	
	Customer createCustomer(String name);	
	
	Customer addAmount(Long customerId, double amount);

}
