package com.online.store.dto;

import java.util.List;

import com.online.store.model.Cart;
import com.online.store.model.CartItem;
import com.online.store.model.User;

import jakarta.persistence.Entity;
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
public class ProductRequest {
	private String product_name;
	private String description;
	private Double price;
	private Integer quantity;
	private Long category_id;

}
