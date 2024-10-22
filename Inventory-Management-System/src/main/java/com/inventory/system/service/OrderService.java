package com.inventory.system.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.system.dto.OrderItemRequest;
import com.inventory.system.dto.OrderItemResponse;
import com.inventory.system.dto.OrderRequest;
import com.inventory.system.dto.OrderResponse;
import com.inventory.system.model.Order;
import com.inventory.system.model.OrderItem;
import com.inventory.system.model.Product;
import com.inventory.system.repository.OrderRepository;
import com.inventory.system.repository.ProductRepository;

 
@Service
public class OrderService {
	
	@Autowired
	private final OrderRepository orderRepository;
	
	@Autowired
	private final ProductRepository productRepository;
	
	public OrderService(OrderRepository orderRepository, ProductRepository productRepository) {
		this.orderRepository = orderRepository;
		this.productRepository = productRepository;
	}
	
	//create order
 	public OrderResponse createOrder(OrderRequest orderRequest) {
		Order order = Order.builder()
				.totalPrice(0.0)
				.orderDate(LocalDateTime.now())
				.build();
		
		List<OrderItem> orderItems = orderRequest.getOrderItems().stream()
				.map(orderitemRequest -> createOrderItem(orderitemRequest, order))
				.toList();
		order.setOrderItems(orderItems);
		double totalPrice = orderItems.stream().mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity()).sum();
		order.setTotalPrice(totalPrice);
		
		Order saveOrder = orderRepository.save(order);
		return mapToOrderResponse(saveOrder);
	}
	
	public OrderItem createOrderItem(OrderItemRequest orderitemRequest, Order order) {
		Product product = productRepository.findById(orderitemRequest.getProduct_id())
				.orElseThrow(() -> new RuntimeException("Product not Found"));
		
		return OrderItem.builder()
				.order(order)
				.product(product)
				.quantity(orderitemRequest.getQuantity())
				.build();
				
	}
	
	public OrderResponse mapToOrderResponse(Order order) {
		return OrderResponse.builder()
				.order_id(order.getOrder_id())
				.orderDate(order.getOrderDate())
				.totalPrice(order.getTotalPrice())
				.orderItems(order.getOrderItems().stream()
						.map(item -> OrderItemResponse.builder()
								.name(item.getProduct().getName())
								.quantity(item.getQuantity())
								.build())
						.collect(Collectors.toList()))
				.build();
	}

}
