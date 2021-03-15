package com.cg.customermgmt.items.util;

import org.springframework.stereotype.Component;

import com.cg.customermgmt.items.dto.ItemDetails;
import com.cg.customermgmt.items.entities.Item;

@Component
public class ItemUtil {
	
	public ItemDetails toDetails(Item item) {
		ItemDetails details = new ItemDetails(item.getItem(), item.getPrice(), item.getDescription()
				, item.getBoughtBy().getId(), item.getBoughtBy().getName());
		return details;
	}

}
