package com.cg.customermgmt.items.service;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.customermgmt.customer.dao.ICustomerDao;
import com.cg.customermgmt.customer.entities.Customer;
import com.cg.customermgmt.items.dao.IItemDao;
import com.cg.customermgmt.items.entities.Item;
import com.cg.customermgmt.items.exceptions.InvalidPriceException;

@Service
public class ItemServiceImpl implements IItemService{
	
	@Autowired
	IItemDao itemDao;
	
	@Autowired
	ICustomerDao dao;
	
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
		validatePrice(price);
		String itemId = generateItemId();
		LocalDateTime now = LocalDateTime.now();
		Item item = new Item(price, description);
		item.setItem(itemId);
		item.setAddedDate(now);
		itemDao.add(item);
		return item;
	}

	@Override
	public Item findById(String itemId) {
		Item item = itemDao.findById(itemId);
		return item;
	}

	@Transactional
	@Override
	public Item buyItem(String itemId, Long customerId) {
		Customer customer = dao.findById(customerId);
		Item item = itemDao.findById(itemId);
		item.setBoughtBy(customer);
		Item updatedItem = itemDao.update(item);
		Set<Item> itemSet = customer.getBoughtItems();
		itemSet.add(item);
		customer.setBoughtItems(itemSet);
		dao.update(customer);
		return updatedItem;
	}
	
	public void validatePrice(double price) {
		if(price < 0) {
			throw new InvalidPriceException("Price cannot be less than 0");
		}
	}

}
