package com.cg.customermgmt.items.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.customermgmt.items.dto.BuyItemRequest;
import com.cg.customermgmt.items.dto.ItemDetails;
import com.cg.customermgmt.items.entities.Item;
import com.cg.customermgmt.items.service.IItemService;
import com.cg.customermgmt.items.util.ItemUtil;

@RequestMapping("/items")
@RestController
public class ItemRestController {
	
	@Autowired
	IItemService itemService;
	
	@Autowired
	ItemUtil util;
	
	@GetMapping(value = "/byId/{id}")
	public ItemDetails getItemById(@PathVariable("id") String itemId) {
		Item item = itemService.findById(itemId);
		ItemDetails details = util.toDetails(item);
		return details;
	}
	
	@PutMapping("/buyItem")
	public ItemDetails buyItem(@RequestBody BuyItemRequest requestBody) {
		Item item = itemService.buyItem(requestBody.getItemId(), requestBody.getCustomerId());
		ItemDetails details = util.toDetails(item);
		return details;
	}

}
