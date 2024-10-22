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
public class ProductResponse {
	private Long product_id;
	private String name;
	private String description;
	private int quantity;
	private double price;
	private String categoryName;
	private String supplierName;

}
