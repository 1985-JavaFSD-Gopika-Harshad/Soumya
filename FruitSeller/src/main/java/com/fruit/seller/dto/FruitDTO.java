package com.fruit.seller.dto;

import lombok.Data;

@Data
public class FruitDTO {
	private Integer id;
	private String name;
	private String quantity;  //quantity of fruit by weight
	private Integer price; 

}
