package com.recipe.book.dto;

import lombok.Data;

@Data
public class ReviewRequest {
	
	private Long recipeId;
 	private Integer rating;
	private String comment;

}
