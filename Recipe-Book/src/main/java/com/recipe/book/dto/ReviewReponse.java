package com.recipe.book.dto;

import lombok.Data;

@Data
public class ReviewReponse {
	
	private Long reviewId;
	private Long recipeId;
	private String name;
	private Integer rating;
	private String comment;
	private Long userId;


}
