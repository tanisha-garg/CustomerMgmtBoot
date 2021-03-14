package com.cg.customermgmt.items.entities;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.cg.customermgmt.customer.entities.Customer;

@Entity
public class Item {
	
	@Id
	private String item;
	private double price;
	private String description;
	private LocalDateTime addedDate;
	
	@ManyToOne
	private Customer boughtBy;
	
	public Item() {
		
	}
	
	public Item(double price, String description) {
		this.price = price;
		this.description = description;
		this.boughtBy = null;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(LocalDateTime addedDate) {
		this.addedDate = addedDate;
	}

	public Customer getBoughtBy() {
		return boughtBy;
	}

	public void setBoughtBy(Customer boughtBy) {
		this.boughtBy = boughtBy;
	}
	
	

}
