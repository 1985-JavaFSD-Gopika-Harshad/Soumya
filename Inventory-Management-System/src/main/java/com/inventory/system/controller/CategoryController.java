package com.inventory.system.controller;

import java.util.List;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.system.dto.CategoryRequest;
import com.inventory.system.dto.CategoryResponse;
import com.inventory.system.dto.ProductResponse;
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
	public CategoryResponse createCategory(@RequestBody CategoryRequest categoryRequest) {
     return categoryService.createCategory(categoryRequest);
  	}
	
	@GetMapping("{category_id}")
	public CategoryResponse getCategoryById(@PathVariable Long category_id) {
		return categoryService.getCategoryById(category_id);
	}
	
	@GetMapping("all")
	public List<CategoryResponse> getAllCategories() {
		return categoryService.getAllCategories();
	}
//	@GetMapping("products/{category_id}")
//	public List<ProductResponse> getProductsBycategory_id(@PathVariable Long category_id){
//		return categoryService.getProductsBycategory_id(category_id);
//	}


	@PutMapping("update/{category_id}")
	public CategoryResponse updateCategory(@RequestBody CategoryRequest categoryRequest,@PathVariable Long category_id) {
		return categoryService.updateCategory(categoryRequest, category_id);
	}

	@DeleteMapping("{category_id}")
	public boolean deleteCategory(@PathVariable Long category_id) {
		return categoryService.deleteCategory(category_id);
	}



}
