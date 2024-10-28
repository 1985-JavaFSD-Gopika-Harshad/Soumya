package com.recipe.book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.recipe.book.service.RecipeService;

@Controller
public class ViewController {
	
	@Autowired
	private RecipeService recipeService;
	
	public ViewController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}
	
	@GetMapping("/home")
	public String home(Model model) {
		model.addAttribute("recipes", recipeService.getAllRecipes());
	//	System.out.println("home page");
		
		return "home";
	}
	


	
	@GetMapping("/recipes")
	public String recipeJsp() {
		System.out.println("recipes");
		return "recipes";
	}
 
	@GetMapping("/login")
	public String Login() {
		return "Login";
	}
	
	@GetMapping("/register")
	public String Register() {
		return "Register";
	}
	
	
}
