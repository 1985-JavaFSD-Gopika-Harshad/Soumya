package com.inventory.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.system.dto.OrderRequest;
import com.inventory.system.dto.OrderResponse;
import com.inventory.system.service.OrderService;

@RestController
@RequestMapping("/orders/")
public class OrderController {
	
	@Autowired
	private final OrderService orderService;
	
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}
	
	@PostMapping
 	public OrderResponse createOrder(@RequestBody OrderRequest orderRequest) {
 		return orderService.createOrder(orderRequest);
 	}


}
