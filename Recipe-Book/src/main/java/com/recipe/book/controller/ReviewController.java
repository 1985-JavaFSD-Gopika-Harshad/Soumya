package com.recipe.book.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.book.model.Review;
import com.recipe.book.service.ReviewService;

@RestController
@RequestMapping("/api/reviews/")
public class ReviewController {
	

	@Autowired
	private ReviewService reviewService;
	
	public ReviewController(ReviewService reviewService) {
		this.reviewService = reviewService;
	}
	
	@PostMapping("{recipeId}")
	public Review addReview(@RequestBody Review review,@PathVariable Long recipeId) {
		return reviewService.addReview(review, recipeId);
	}
	
	@GetMapping("all/{recipeId}")
	public List<Review> getAllReviewsByRecipe(@PathVariable Long recipeId){
		return reviewService.getAllReviewsByRecipe(recipeId);
	}



}
