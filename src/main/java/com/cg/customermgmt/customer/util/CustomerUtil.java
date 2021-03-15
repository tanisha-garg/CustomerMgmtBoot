package com.cg.customermgmt.customer.util;

import org.springframework.stereotype.Component;
import com.cg.customermgmt.customer.dto.CustomerDetails;
import com.cg.customermgmt.customer.entities.Customer;

@Component
public class CustomerUtil {
	
	public CustomerDetails toDetails(Customer customer) {
		CustomerDetails customerDetails = new CustomerDetails(customer.getId(), customer.getName(), customer.getAccount().getAccountId(), customer.getAccount().getBalance());
		return customerDetails;
	}

}
