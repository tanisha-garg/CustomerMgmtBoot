package com.cg.customermgmt.items.dao;

import com.cg.customermgmt.items.entities.Item;

public interface IItemDao {
	
	Item add(Item item);
	
	Item update(Item item);
	
	Item findById(String itemId);

}
