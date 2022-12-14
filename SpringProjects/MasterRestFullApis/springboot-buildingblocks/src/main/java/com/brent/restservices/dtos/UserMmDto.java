package com.brent.restservices.dtos;

import java.util.List;

import com.brent.restservices.entities.Order;

public class UserMmDto {

	private Long id;
	private String userName;
	private String firstName;
	private List<Order> orders;
	
	public Long getId() {
		return id;
	}
	public void setId(Long userid) {
		this.id = userid;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
}
