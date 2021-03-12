package com.cg.customermgmt.customer.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Customer {
	
	@GeneratedValue
	@Id
	private Long id;
	private String name;
	
	@OneToOne
	private Account account;
	
	public Customer() {
		
	}
	
	public Customer(String name, Account account) {
		this.name = name;
		this.account = account;
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
	
	

}
