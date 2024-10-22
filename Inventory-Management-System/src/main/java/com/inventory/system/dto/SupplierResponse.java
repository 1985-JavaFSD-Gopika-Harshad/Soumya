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
public class SupplierResponse {
	
	private Long supplier_id;
	private String name;
	private String email;
	
	private List<Product> products;

}
