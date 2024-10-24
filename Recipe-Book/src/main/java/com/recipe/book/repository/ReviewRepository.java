package com.recipe.book.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recipe.book.model.Review;
import com.recipe.book.model.Recipe;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
   List<Review> findByRecipeRecipeId(Long recipeId);
}
