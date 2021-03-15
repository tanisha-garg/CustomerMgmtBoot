package com.cg.customermgmt.customer.dto;

public class AddBalanceRequest {
	
	private Long customerId;
	private double balance;
	
	public AddBalanceRequest() {
		
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	
	

}
