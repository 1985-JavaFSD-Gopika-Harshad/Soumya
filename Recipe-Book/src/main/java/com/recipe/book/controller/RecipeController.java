package com.recipe.book.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.book.model.Recipe;
import com.recipe.book.service.RecipeService;

@RestController
@RequestMapping("/api/recipe/")
public class RecipeController {
	
	@Autowired
	private RecipeService recipeService;
	
	public RecipeController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}
	

	
	@PostMapping
	public Recipe createRecipe(@RequestBody Recipe recipe) {
		return recipeService.createRecipe(recipe);
	}
	
	@GetMapping("{recipeId}")
	public Optional<Recipe> getRecipeById(@PathVariable Long recipeId) {
		return recipeService.getRecipeById(recipeId);
	}
	
	@GetMapping("all")
	public List<Recipe> getAllRecipes(){
		return recipeService.getAllRecipes();
	}
	
	@GetMapping("cuisine/{cuisine}")
	public List<Recipe> findByCuisine(@PathVariable String cuisine){
		return recipeService.findByCuisine(cuisine);
	}
	
	@GetMapping("meal/{mealType}")
	public List<Recipe> findByMealType(@PathVariable String mealType){
		return recipeService.findByMealType(mealType);
	}
	
	 @DeleteMapping("delete/{recipeId}")
	 public boolean deleteRecipe(@PathVariable Long recipeId) {
		 return recipeService.deleteRecipe(recipeId);
	 }







}
