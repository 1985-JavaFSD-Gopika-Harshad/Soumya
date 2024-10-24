package com.online.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.store.dto.CategoryRequest;
import com.online.store.dto.CategoryResponse;
import com.online.store.model.Category;
import com.online.store.repository.CategoryRepository;
import com.online.store.repository.ProductRepository;

 
@Service
public class CategoryService {
	
	@Autowired
	private final CategoryRepository categoryRepository;
	
	@Autowired
	private final ProductRepository productRepository;
	
	public CategoryService(CategoryRepository categoryRepository,ProductRepository productRepository ) {
		this.categoryRepository = categoryRepository;
		this.productRepository = productRepository;
    }
	
	//mapping category entity to categoryResponse
		public CategoryResponse mapToCategoryResponse(Category category) {
			return  CategoryResponse.builder()
					.category_id(category.getCategory_id())
					.categoryname(category.getCategoryname())
	 				.build();
		}
		
		//create category
		public CategoryResponse createCategory(CategoryRequest categoryRequest) {
			Category category = Category.builder()
					.categoryname(categoryRequest.getCategoryname())
					.build();
			Category savecategory= categoryRepository.save(category);
			return mapToCategoryResponse(savecategory);
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
			Category existingcategory = categoryRepository.getById(category_id);
			existingcategory.setCategoryname(categoryRequest.getCategoryname());
			Category category = categoryRepository.save(existingcategory);
			return mapToCategoryResponse(category);
		}
		
		//delete category
		public boolean deleteCategory(Long category_id) {
			Category category = categoryRepository.getById(category_id);
			categoryRepository.delete(category);
			return true;	
		}
	
		 
	  
	
	
}
