package com.cg.customermgmt.customer.util;

import org.springframework.stereotype.Component;

import com.cg.customermgmt.customer.dto.CustomerDetails;
import com.cg.customermgmt.customer.entities.Customer;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class CustomerUtil {
	
	public CustomerDetails toDetails(Customer customer) {
		CustomerDetails customerDetails = new CustomerDetails(customer.getId(), customer.getName());
		return customerDetails;
	}
	
	public List<CustomerDetails> toDetailsList(Collection<Customer> customers){
		List<CustomerDetails> resultList = customers.stream().map(cust -> toDetails(cust)).collect(Collectors.toList());
		return resultList;
	}

}
