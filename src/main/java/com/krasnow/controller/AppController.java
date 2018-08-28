package com.krasnow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.krasnow.constants.StatusCodes;
import com.krasnow.dto.OrderResponse;
import com.krasnow.service.OrderService;

@RestController(value = "/customer")
public class AppController {
	
	@Autowired
	private OrderService orderService;
	
	@CrossOrigin
	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public @ResponseBody OrderResponse getResponse( @RequestParam(value = "email", required = false) String emailId) {
			
		if(emailId!=null) {
			return orderService.getCutomerOrders(emailId);
		}
		
		OrderResponse errorResponse = new OrderResponse();
		errorResponse.setStatusCode(StatusCodes.STATUS_OK);
		return errorResponse;
	}

}
