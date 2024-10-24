package com.recipe.book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.book.model.Recipe;
import com.recipe.book.repository.RecipeRepository;

@Service
public class RecipeService {
	
	@Autowired
	private RecipeRepository recipeRepository;
	
	public RecipeService(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}
	
	//create recipe
	public Recipe createRecipe(Recipe recipe) {
		return recipeRepository.save(recipe);
	}
	
	//get recipe by id
	public Optional<Recipe> getRecipeById(Long recipeId) {
		return recipeRepository.findById(recipeId);
	}
	
	//get all recipe's
	public List<Recipe> getAllRecipes(){
		return recipeRepository.findAll()
				.stream()
				.toList();
	}
	
	//get recipes by cuisine
	public List<Recipe> findByCuisine(String cuisine){
		return recipeRepository.findByCuisine(cuisine);
	}
	
	
	//get recipes by mealType
	public List<Recipe> findByMealType(String mealType){
		return recipeRepository.findByMealType(mealType);
	}
	
	//delete recipe
	 public boolean deleteRecipe(Long recipeId) {
		 Recipe recipe = recipeRepository.getById(recipeId);
		 recipeRepository.delete(recipe);
		 return true;
		
	}
	

}
