package com.cg.customermgmt.customer.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {
	
	@GeneratedValue
	@Id
	private long accountId;
	private double balance;
	private LocalDateTime created;
	
	public Account() {
		this(0,null);
	}
	
	public Account(double balance, LocalDateTime created) {
		this.balance = balance;
		this.created = created;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}
	
	

}
