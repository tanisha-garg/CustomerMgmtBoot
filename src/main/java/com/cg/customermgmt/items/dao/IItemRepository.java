package com.cg.customermgmt.items.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.customermgmt.items.entities.Item;

public interface IItemRepository extends JpaRepository<Item, String>{

}
