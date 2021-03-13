package com.cg.customermgmt.items.service;

import java.time.LocalDateTime;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.customermgmt.items.dao.IItemDao;
import com.cg.customermgmt.items.entities.Item;

@Service
public class ItemServiceImpl implements IItemService{
	
	@Autowired
	IItemDao itemDao;
	
	@Autowired
	EntityManager entityManager;
	
	public String generateItemId() {
		Random random = new Random();
		Integer n = 1000000000 + random.nextInt(900000000);
		String itemId = n.toString();
		return itemId;
	}

	@Transactional
	@Override
	public Item create(double price, String description) {
		String itemId = generateItemId();
		LocalDateTime now = LocalDateTime.now();
		Item item = new Item(itemId, price, description, now);
		itemDao.add(item);
		return item;
	}

	@Override
	public Item findById(String itemId) {
		Item item = itemDao.findById(itemId);
		return item;
	}

	@Override
	public Item buyItem(String itemId, Long customerId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
