package com.cg.customermgmt.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.customermgmt.customer.dto.AddBalanceRequest;
import com.cg.customermgmt.customer.dto.CustomerDetails;
import com.cg.customermgmt.customer.entities.Customer;
import com.cg.customermgmt.customer.service.ICustomerService;
import com.cg.customermgmt.customer.util.CustomerUtil;

@RequestMapping("/customers")
@RestController
public class CustomerRestController {
	
	@Autowired
	private ICustomerService service;
	
	@Autowired
	private CustomerUtil util;
	
	@GetMapping(value = "/byId/{id}")
	public CustomerDetails getDetailsById(@PathVariable("id") Long customerId) {
		Customer customer = service.findById(customerId);
		CustomerDetails details = util.toDetails(customer);
		return details;
	}
	
	@PutMapping("/addAmount")
	public CustomerDetails addAmount(@RequestBody AddBalanceRequest requestData) {
		Customer customer = service.addAmount(requestData.getCustomerId(), requestData.getBalance());
		CustomerDetails details = util.toDetails(customer);
		return details;
	}

}
