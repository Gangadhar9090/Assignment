package com.restapi.dto;

import java.util.ArrayList;
import java.util.List;

import com.restapi.entities.Item;

public class OrderDto {
	private int orderId;
	private String orderDate;
	private String orderStatus;
	List<Item> item = new ArrayList<Item>();
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public List<Item> getItem() {
		return item;
	}
	public void setItem(List<Item> item) {
		this.item = item;
	}
	
}
