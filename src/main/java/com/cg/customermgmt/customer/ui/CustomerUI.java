package com.cg.customermgmt.customer.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.customermgmt.customer.entities.Account;
import com.cg.customermgmt.customer.entities.Customer;
import com.cg.customermgmt.customer.service.ICustomerService;

@Component
public class CustomerUI {
	
	@Autowired
	ICustomerService service;
	
	public void start() {
		
		Customer tanisha = service.createCustomer("Tanisha");
		display(tanisha);
		
		Customer pallavi = service.createCustomer("Palllavi");
		display(pallavi);
		
		Customer findCustomer = service.findById(4L);
		display(findCustomer);
		
		service.addAmount(2L, 1000.0);
		display(tanisha);
		
	}
	
	void display(Customer customer) {
		Account account = customer.getAccount();
		System.out.println("Customer "+customer.getId()+" "+customer.getName()+" "+account.getAccountId()+" "
		+account.getBalance()+" "+account.getCreated());
	}

}
