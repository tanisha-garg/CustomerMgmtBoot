package com.cg.customermgmt.customer.ui;

import java.util.Set;

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
		Customer pallavi = service.createCustomer("Pallavi");
		
		Item chocolate = itemService.create(100.0, "Chocolate");		
		Item rice = itemService.create(200.0, "Rice");
		Item maggi = itemService.create(100, "Maggi");
		
		System.out.println("Customer with id 4");
		Customer findCustomer = service.findById(4L);
		display(findCustomer);
		
		System.out.println("*************************");
		System.out.println("After adding amount in Tanisha's Account");
		Long tanishaId = tanisha.getId();
		Customer tanishaAmount = service.addAmount(tanishaId, 1000.0);
		display(tanishaAmount);
		
		System.out.println("*************************");
		System.out.println("Finding an item with id");
		String itemId = chocolate.getItem();
		Item findItem = itemService.findById(itemId);
		displayItem(findItem);
		
		System.out.println("*************************");
		System.out.println("Buy an item");
		Item buyChocolate = itemService.buyItem(itemId, tanishaId);
		tanisha = service.findById(tanishaId);
		displayItem(buyChocolate);
		display(tanisha);
		
		System.out.println("*************************");
		Item buyRice = itemService.buyItem(rice.getItem(), pallavi.getId());
		pallavi = service.findById(pallavi.getId());
		displayItem(buyRice);
		display(pallavi);
		
		System.out.println("*************************");
		Item buyMaggi = itemService.buyItem(maggi.getItem(), tanishaId);
		tanisha = service.findById(tanishaId);
		displayItem(buyMaggi);
		display(tanisha);
		
	}
	
	void display(Customer customer) {
		Account account = customer.getAccount();
		System.out.println("Customer "+customer.getId()+":\nName: "+customer.getName()
		+"\nAccountId: "+account.getAccountId()+"\nBalance: "
		+account.getBalance()+"\nCreated: "+account.getCreated());
		Set<Item> itemSet = customer.getBoughtItems();
		for(Item item:itemSet) {
			System.out.println("Item Details: "+item.getItem()+" "+item.getDescription());	
		}
	}
	
	void displayItem(Item item) {
		if(item.getBoughtBy() == null) {
			System.out.println("Item "+item.getItem()+":\nName: "+item.getDescription()+"\nPrice: "
		+item.getPrice()+"\nAdded on: "+item.getAddedDate());
		}
		else {
			System.out.println("Item "+item.getItem()+":\nName: "+item.getDescription()+"\nPrice "
		+item.getPrice()+"\nAdded on: "+item.getAddedDate()+"\nBought by: "+item.getBoughtBy().getName());
		}
		
	}

}
