package com.cg.customermgmt.customer.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.customermgmt.customer.entities.Account;
import com.cg.customermgmt.customer.entities.Customer;
import com.cg.customermgmt.customer.service.ICustomerService;
import com.cg.customermgmt.items.entities.Item;
import com.cg.customermgmt.items.service.IItemService;

@Component
public class CustomerUI {
	
	@Autowired
	ICustomerService service;
	
	@Autowired
	IItemService itemService;
	
	public void start() {
		
		Customer tanisha = service.createCustomer("Tanisha");
		display(tanisha);
		
		Customer pallavi = service.createCustomer("Palllavi");
		display(pallavi);
		
		System.out.println("Customer with id 4");
		Customer findCustomer = service.findById(4L);
		display(findCustomer);
		
		System.out.println("After adding amount in Tanisha's Account");
		Long tanishaId = tanisha.getId();
		Customer tanishaAmount = service.addAmount(tanishaId, 1000.0);
		display(tanishaAmount);
		
		Item chocolate = itemService.create(100.0, "Chocolate");
		displayItem(chocolate);
		
		Item rice = itemService.create(200.0, "Rice");
		displayItem(rice);
		
		System.out.println("Finding an item with id");
		String itemId = chocolate.getItem();
		Item findItem = itemService.findById(itemId);
		displayItem(findItem);
		
		System.out.println("Buy an item");
		Item buyChocolate = itemService.buyItem(itemId, tanishaId);
		displayItem(buyChocolate);
		
	}
	
	void display(Customer customer) {
		Account account = customer.getAccount();
		System.out.println("Customer "+customer.getId()+" "+customer.getName()+" "+account.getAccountId()+" "
		+account.getBalance()+" "+account.getCreated());
	}
	
	void displayItem(Item item) {
		System.out.println("Item "+item.getItem()+" "+item.getDescription()+" "+item.getPrice()+" "
				+item.getAddedDate());
	}

}
