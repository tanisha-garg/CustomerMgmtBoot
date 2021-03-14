package com.cg.customermgmt.customer.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.cg.customermgmt.items.entities.Item;

import java.util.*;
@Entity
public class Customer {
	
	@GeneratedValue
	@Id
	private Long id;
	private String name;
	
	@OneToOne
	private Account account;
	
	@OneToMany(fetch = FetchType.EAGER)
	private Set<Item> boughtItems;
	
	public Customer() {
		
	}
	
	public Customer(String name, Account account, Set<Item>boughtItems) {
		this.name = name;
		this.account = account;
		this.boughtItems = boughtItems;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Set<Item> getBoughtItems() {
		return boughtItems;
	}

	public void setBoughtItems(Set<Item> boughtItems) {
		this.boughtItems = boughtItems;
	}
	
	

}
