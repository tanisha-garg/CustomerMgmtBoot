package com.cg.customermgmt.items.dao;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cg.customermgmt.items.entities.Item;
import com.cg.customermgmt.items.exceptions.ItemNotFoundException;

@Repository
public class ItemDaoImpl implements IItemDao{
	
	@Autowired
	EntityManager entityManager;

	@Transactional
	@Override
	public Item add(Item item) {
		entityManager.persist(item);
		return item;
	}

	@Transactional
	@Override
	public Item update(Item item) {
		item = entityManager.merge(item);
		return item;
	}

	@Override
	public Item findById(String itemId) {
		Item item = entityManager.find(Item.class, itemId);
		if(item == null) {
			throw new ItemNotFoundException("Item with id "+itemId+" not found");
		}
		return item;
	}

}
