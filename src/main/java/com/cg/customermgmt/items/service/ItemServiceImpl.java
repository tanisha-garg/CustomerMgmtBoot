package com.cg.customermgmt.items.service;

import java.time.LocalDateTime;
import java.util.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.customermgmt.customer.dao.ICustomerRepository;
import com.cg.customermgmt.customer.entities.Customer;
import com.cg.customermgmt.customer.exceptions.CustomerNotFoundException;
import com.cg.customermgmt.items.dao.IItemRepository;
import com.cg.customermgmt.items.entities.Item;
import com.cg.customermgmt.items.exceptions.InvalidPriceException;
import com.cg.customermgmt.items.exceptions.ItemNotFoundException;

@Service
public class ItemServiceImpl implements IItemService{
	
//	@Autowired
//	IItemDao itemDao;
	
//	@Autowired
//	ICustomerDao dao;
	
	@Autowired
	IItemRepository itemRepository;
	
	@Autowired
	ICustomerRepository customerRepository;
	
	public String generateItemId() {
		Random random = new Random();
		Integer n = 1000000000 + random.nextInt(900000000);
		String itemId = n.toString();
		return itemId;
	}

	@Transactional
	@Override
	public Item create(double price, String description) {
//		validatePrice(price);
//		String itemId = generateItemId();
//		LocalDateTime now = LocalDateTime.now();
//		Item item = new Item(price, description);
//		item.setItem(itemId);
//		item.setAddedDate(now);
//		itemDao.add(item);
		
		validatePrice(price);
		String itemId = generateItemId();
		LocalDateTime now = LocalDateTime.now();
		Item item = new Item(price, description);
		item.setItem(itemId);
		item.setAddedDate(now);
		itemRepository.save(item);
		
		return item;
	}

	@Override
	public Item findById(String itemId) {
//		Item item = itemDao.findById(itemId);
		Optional<Item> optional = itemRepository.findById(itemId);
		if(!optional.isPresent()) {
			throw new ItemNotFoundException("Cannot find item with id "+itemId);
		}
		return optional.get();
	}

	@Transactional
	@Override
	public Item buyItem(String itemId, Long customerId) {
//		Customer customer = dao.findById(customerId);
//		Item item = itemDao.findById(itemId);
//		item.setBoughtBy(customer);
//		Item updatedItem = itemDao.update(item);
//		Set<Item> itemSet = customer.getBoughtItems();
//		itemSet.add(item);
//		customer.setBoughtItems(itemSet);
//		dao.update(customer);
		
		Optional<Customer> custOp = customerRepository.findById(customerId);
		if(!custOp.isPresent()) {
			throw new CustomerNotFoundException("Customer with id "+ customerId+" not found");
		}
		Customer customer = custOp.get();
		
		Optional<Item> itemOp = itemRepository.findById(itemId);
		if(!itemOp.isPresent()) {
			throw new ItemNotFoundException("Cannot find item with id "+itemId);
		}
		Item item = itemOp.get();
		
		item.setBoughtBy(customer);
		item = itemRepository.save(item);
		
		Set<Item> itemSet = customer.getBoughtItems();
		itemSet.add(item);
		customer.setBoughtItems(itemSet);
		customer = customerRepository.save(customer);
		
		return item;
	}
	
	public void validatePrice(double price) {
		if(price < 0) {
			throw new InvalidPriceException("Price cannot be less than 0");
		}
	}

}

