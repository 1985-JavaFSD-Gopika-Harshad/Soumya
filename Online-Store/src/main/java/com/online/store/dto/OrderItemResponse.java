package com.online.store.dto;

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
public class OrderItemResponse {
	
    private Long orderItem_id;
    private Long order_id;
    private Long product_id;
    private String product_name;
    private Integer quantity;
    private Double price;
     

	

}
