package com.online.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.store.model.Order;
import com.online.store.repository.OrderRepository;

@Service
public class OrderService {
	@Autowired
	private OrderRepository orderRepository;
	
	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}
	
	//create order
	public Order createOrder(Order order) {
		return orderRepository.save(order);
	}
	
	//get order by id
	public Order getOrderById(Long order_id) {
		return orderRepository.getById(order_id);
	}
	
	//get all orders
	public List<Order> getAllOrders(){
		return orderRepository.findAll();
	}
	

}
