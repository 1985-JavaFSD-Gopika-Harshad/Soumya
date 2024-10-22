package com.inventory.system.service;

 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.system.dto.CategoryRequest;
import com.inventory.system.dto.CategoryResponse;
import com.inventory.system.model.Category;
import com.inventory.system.repository.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private final CategoryRepository categoryRepository;
	
	public CategoryService(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}
	
	public CategoryResponse mapToCategoryResponse(Category category) {
		return CategoryResponse.builder()
				.category_id(category.getCategory_id())
				.name(category.getName())
				.build();

	}
	
	//create category
	public CategoryResponse createCategory(CategoryRequest categoryRequest) {
		Category category = Category.builder()
				.name(categoryRequest.getName())
				.build();
		Category cat= categoryRepository.save(category);
		return mapToCategoryResponse(cat);
	}
	
	//get category by id
	public CategoryResponse getCategoryById(Long category_id) {
		Category category =categoryRepository.getById(category_id);
		return mapToCategoryResponse(category);
	}
	
	//get all categories
	public List<CategoryResponse> getAllCategories() {
		List<Category> categories = categoryRepository.findAll();
		return categories.stream()
				.map(this::mapToCategoryResponse)
				.toList();
	}
	
	
	//update category
	public CategoryResponse updateCategory(CategoryRequest categoryRequest, Long category_id) {
		Category category = categoryRepository.getById(category_id);
		category.setName(categoryRequest.getName());
		Category cat = categoryRepository.save(category);
		return mapToCategoryResponse(cat);
	}
	
	//delete category
	public boolean deleteCategory(Long category_id) {
		Category category = categoryRepository.getById(category_id);
		categoryRepository.delete(category);
		return true;	
	}

}
