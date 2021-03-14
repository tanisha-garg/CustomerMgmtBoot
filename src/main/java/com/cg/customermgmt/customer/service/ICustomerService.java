package com.cg.customermgmt.customer.service;

import java.util.Set;

import com.cg.customermgmt.customer.entities.Customer;
import com.cg.customermgmt.items.entities.Item;

public interface ICustomerService {
	
	Customer findById(Long customerId);
	
	Customer createCustomer(String name);	
	
	Customer addAmount(Long customerId, double amount);
	
	Set<Item> itemsBoughtByCustomer(Long customerId);

}
