package com.krasnow.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.krasnow.constants.StatusCodes;
import com.krasnow.dao.Orders;
import com.krasnow.dto.IndividualOrder;
import com.krasnow.dto.OrderResponse;
import com.krasnow.repo.OrderRepository;
import com.krasnow.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderRepository orderRepo;

	public OrderResponse getCutomerOrders(String email) {

		OrderResponse response = new OrderResponse();
		List<Orders> orderList = orderRepo.findByEmail(email);
		
		if(orderList!=null && orderList.size()>0) {
			List<IndividualOrder> individualOrder = new ArrayList<>();
			for(Orders o : orderList) {
				IndividualOrder io = new IndividualOrder();
				io.setDateOfOrder(String.valueOf(o.getOrder_date()));
				io.setOrderId(o.getId());
				io.setProductName(o.getProduct_name());
				individualOrder.add(io);
			}
			response.setOrders(individualOrder);
			response.setStatusCode(StatusCodes.STATUS_OK);
		}else {
			
			response.setStatusCode(StatusCodes.CUSTOMER_NOT_FOUND);
		}

		
		

		return response;
	}


}
