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
public class ProductRequest {
	
 	private String name;
	private String description;
	private Integer quantity;
	private double price;
	private Long category_id;    //to link with category
	private Long supplier_id;   //to link with supplier

}
