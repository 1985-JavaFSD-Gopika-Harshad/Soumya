package com.recipe.book.dto;

import java.util.List;

import lombok.Data;

@Data

public class RecipeRequest {
	
	private String name;
	private String description;
	private String cuisine;
	private String mealType;
	
	private List<String> ingredients;
	private String instructions;
	
	private String imageUrl;

}
