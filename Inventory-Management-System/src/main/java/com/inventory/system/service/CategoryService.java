package com.inventory.system.service;

 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.system.dto.CategoryRequest;
import com.inventory.system.dto.CategoryResponse;
import com.inventory.system.dto.ProductResponse;
import com.inventory.system.model.Category;
import com.inventory.system.model.Product;
import com.inventory.system.repository.CategoryRepository;
import com.inventory.system.repository.ProductRepository;

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
		return CategoryResponse.builder()
				.category_id(category.getCategory_id())
				.name(category.getName())
 				.build();

	}
	
	//mapping product entity to productResponse
//	public ProductResponse mapToProductResponse(Product product) {
//        return ProductResponse.builder()
//                .product_id(product.getProduct_id())
//                .name(product.getName())
//                .description(product.getDescription())
//                .quantity(product.getQuantity())
//                .price(product.getPrice())
//                .categoryName(product.getCategory().getName())  // Get Category Name
//                .supplierName(product.getSupplier().getName())  // Get Supplier Name
//                .build();
//	}
	
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
	
//	//get all products by category id
//	public List<ProductResponse> getProductsBycategory_id(Long category_id){
//		
//		Category category = categoryRepository.findById(category_id)
//				.orElseThrow(() -> new RuntimeException("Category not found"));
//		
//		List<Product> products = productRepository.findBycategory_category_id(category_id);
//		return products.stream()
//				.map(this::mapToProductResponse)
//				.toList();
//	}
	
	
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
