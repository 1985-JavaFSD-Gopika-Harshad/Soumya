package com.recipe.book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.book.model.Recipe;
import com.recipe.book.model.Review;
import com.recipe.book.repository.RecipeRepository;
import com.recipe.book.repository.ReviewRepository;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private RecipeRepository recipeRepository;
	
	public ReviewService(ReviewRepository reviewRepository, RecipeRepository recipeRepository) {
		this.reviewRepository = reviewRepository;
		this.recipeRepository = recipeRepository;
	}
	
	//add review
	public Review addReview(Review review, Long recipeId) {
		Optional<Recipe> existingrecipe = recipeRepository.findById(recipeId);
		
		if(existingrecipe.isPresent()) {
			Recipe recipe = existingrecipe.get();
			review.setRecipe(recipe);
		return reviewRepository.save(review);
		}
		else {
			System.out.println("Recipe not found with id :" +recipeId);
		}
		return review;
 	}
	
	//get all reviews for a recipe
	public List<Review> getAllReviewsByRecipe(Long recipeId){
		return reviewRepository.findByRecipeRecipeId(recipeId);
		
	}

}
