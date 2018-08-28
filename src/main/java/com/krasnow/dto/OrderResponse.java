package com.krasnow.dto;

import java.util.List;

public class OrderResponse {
	
	private Integer statusCode;
	
	private List<IndividualOrder> orders;
	
	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	

	public List<IndividualOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<IndividualOrder> orders) {
		this.orders = orders;
	}

	

}
