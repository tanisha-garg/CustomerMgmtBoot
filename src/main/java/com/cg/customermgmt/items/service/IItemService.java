package com.cg.customermgmt.items.service;

import com.cg.customermgmt.items.entities.Item;

public interface IItemService {
	
	Item create(double price, String description);
	
	Item findById(String itemId);
	
	Item buyItem(String itemId, Long customerId);

}
