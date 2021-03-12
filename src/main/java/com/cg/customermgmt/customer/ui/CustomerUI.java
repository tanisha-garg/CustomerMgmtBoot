package com.cg.customermgmt.customer.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.customermgmt.customer.service.ICustomerService;

@Component
public class CustomerUI {
	
	@Autowired
	ICustomerService service;
	
	public void start() {
		
		service.createCustomer("Tanisha");
		
	}

}
