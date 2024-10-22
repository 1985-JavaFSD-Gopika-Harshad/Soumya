package com.inventory.system.controller;

import java.util.Locale.Category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.system.service.CategoryService;

@RestController
@RequestMapping("/category/")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	public CategoryController(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@PostMapping
	public Category createCategory(@RequestBody Category category) {
		return categoryService.createCategory(category);
	}


}
