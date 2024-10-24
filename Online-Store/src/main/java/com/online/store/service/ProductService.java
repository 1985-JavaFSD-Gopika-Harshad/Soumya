package com.online.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

 import com.online.store.dto.ProductRequest;
import com.online.store.dto.ProductResponse;
import com.online.store.model.Category;
import com.online.store.model.Product;
import com.online.store.repository.CategoryRepository;
import com.online.store.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}
	
	public ProductResponse mapToProductResponse(Product product) {
		return ProductResponse.builder()
				.product_id(product.getProduct_id())
				.product_name(product.getProduct_name())
				.description(product.getDescription())
				.price(product.getPrice())
				.quantity(product.getQuantity())
				.categoryname(product.getCategory().getCategoryname())
 				.build();
	}
	
	// create product
	public ProductResponse createProduct(ProductRequest productRequest) {
		Category category = categoryRepository.findById(productRequest.getCategory_id())
				.orElseThrow(() -> new RuntimeException("category not found"));
		
		Product product = Product.builder()
				.product_name(productRequest.getProduct_name())
				.description(productRequest.getDescription())
				.price(productRequest.getPrice())
				.quantity(productRequest.getQuantity())
				.category(category)
				.build();
		
		Product saveProduct = productRepository.save(product);
		return mapToProductResponse(saveProduct);
				
		
	}
	
	//get product by product_id
		public ProductResponse getProductById(Long product_id) {
	        Product product = productRepository.findById(product_id)
	                .orElseThrow(() -> new RuntimeException("Product not found"));
	        return mapToProductResponse(product);
	    }

		// get all products
		public List<ProductResponse> getAllProducts() {
	        List<Product> products = productRepository.findAll();
	        return products.stream()
	                .map(this::mapToProductResponse)
	                .toList();
	    }
		
		
		//update product
		public ProductResponse updateProduct(ProductRequest productRequest, Long product_id) {
	        Product existingProduct = productRepository.findById(product_id)
	                .orElseThrow(() -> new RuntimeException("Product not found"));

	        Category category = categoryRepository.findById(productRequest.getCategory_id())
	                .orElseThrow(() -> new RuntimeException("Category not found"));

	        existingProduct.setProduct_name(productRequest.getProduct_name());
	        existingProduct.setDescription(productRequest.getDescription());
	        existingProduct.setPrice(productRequest.getPrice());
	        existingProduct.setQuantity(productRequest.getQuantity());
 	        existingProduct.setCategory(category);
 
	        Product updatedProduct = productRepository.save(existingProduct);
	        return mapToProductResponse(updatedProduct);
	    }
		
		//delete product
		public boolean deleteProduct(Long product_id) {
			Product product = productRepository.getById(product_id);
			productRepository.delete(product);
			return true;
		}

}
