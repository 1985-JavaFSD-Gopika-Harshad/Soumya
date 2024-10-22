package com.inventory.system.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse {
	private Long order_id;
	private double totalPrice;
	private LocalDateTime orderDate;
	private List<OrderItemResponse> orderItems;



}
