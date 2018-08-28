package com.krasnow.service;

import com.krasnow.dto.OrderResponse;

public interface OrderService {

	public OrderResponse getCutomerOrders(String email);
}
