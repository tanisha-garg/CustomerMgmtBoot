package com.cg.customermgmt.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.customermgmt.customer.dto.*;
import com.cg.customermgmt.customer.entities.Customer;
import com.cg.customermgmt.customer.service.ICustomerService;
import com.cg.customermgmt.customer.util.CustomerUtil;
import com.cg.customermgmt.items.entities.Item;
import java.util.*;

@RequestMapping("/customers")
@RestController
public class CustomerRestController {
	
	@Autowired
	private ICustomerService service;
	
	@Autowired
	private CustomerUtil util;
	
	@GetMapping(value = "/findById/{id}")
	public CustomerDetails getDetailsById(@PathVariable("id") Long customerId) {
		Customer customer = service.findById(customerId);
		CustomerDetails details = util.toDetails(customer);
		return details;
	}
	
	@GetMapping(value = "/getItems/{id}")
	public List<ItemBoughtByCustomer> getItemDetailsById(@PathVariable("id") Long customerId){
		Set<Item> setItem = service.itemsBoughtByCustomer(customerId);
		List<ItemBoughtByCustomer> itemList = util.toItemDetails(setItem);
		return itemList;
	}
	
	@PutMapping("/addAmount")
	public CustomerDetails addAmount(@RequestBody AddBalanceRequest requestData) {
		Customer customer = service.addAmount(requestData.getCustomerId(), requestData.getBalance());
		CustomerDetails details = util.toDetails(customer);
		return details;
	}

}
