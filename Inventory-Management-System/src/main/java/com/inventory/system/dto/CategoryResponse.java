package com.inventory.system.dto;

import java.util.List;

import com.inventory.system.model.Product;

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
public class CategoryResponse {
	
	private Long category_id;
	private String name;
	
	private List<Product> products;
}
