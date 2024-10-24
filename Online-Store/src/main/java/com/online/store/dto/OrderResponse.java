package com.online.store.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderResponse {
     
	private Long order_id;	
	private LocalDateTime orderDate;
	private Double totalPrice;
	private Long user_id;
	
	private List<OrderItemResponse> orderitems;
	

}
