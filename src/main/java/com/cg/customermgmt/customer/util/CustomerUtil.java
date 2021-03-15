package com.cg.customermgmt.customer.util;

import org.springframework.stereotype.Component;
import com.cg.customermgmt.customer.dto.CustomerDetails;
import com.cg.customermgmt.customer.dto.ItemBoughtByCustomer;
import com.cg.customermgmt.customer.entities.Customer;
import com.cg.customermgmt.items.entities.Item;
import java.util.*;

@Component
public class CustomerUtil {
	
	public CustomerDetails toDetails(Customer customer) {
		CustomerDetails customerDetails = new CustomerDetails(customer.getId(), customer.getName(), customer.getAccount().getAccountId(), customer.getAccount().getBalance());
		return customerDetails;
	}
	
	public List<ItemBoughtByCustomer> toItemDetails(Set<Item> itemSet) {
		List<ItemBoughtByCustomer> itemList = new ArrayList<>();
		for(Item item:itemSet) {
			ItemBoughtByCustomer itemDetails = new ItemBoughtByCustomer(item.getItem(), item.getDescription());
			itemList.add(itemDetails);
		}
		return itemList;
	}

}
