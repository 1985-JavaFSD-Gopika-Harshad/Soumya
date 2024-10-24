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
public class ProductResponse {
	
	private Long product_id;
	private String product_name;
	private String description;
	private Double price;
	private Integer quantity;
	private String categoryname;

}
