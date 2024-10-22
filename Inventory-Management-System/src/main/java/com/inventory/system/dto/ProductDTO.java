package com.inventory.system.dto;

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
public class ProductDTO {
	
	private Long product_id;
	private String name;
	private String description;
	private Integer quantity;
	private double price;
	private Long category_id;
	private Long supplier_id;

}
