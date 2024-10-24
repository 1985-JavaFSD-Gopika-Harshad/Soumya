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
public class CartItemResponse {
	
    private Long cartitems_id;
	private Integer quantity;
	private Long cart_id;
	private String product_name;
	private Double productPrice;
	private Double totalPrice;

}
