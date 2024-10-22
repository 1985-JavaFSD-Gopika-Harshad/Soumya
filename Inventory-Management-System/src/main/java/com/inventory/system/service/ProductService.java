package com.inventory.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.system.dto.ProductDTO;
import com.inventory.system.model.Product;
import com.inventory.system.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
 	
	//creating products
	public Product createProduct(Product product) {
		return productRepository.save(product);
	}
	
	
	//get product by product_id
	public Product getProductById(Long product_id) {
		return productRepository.findById(product_id).orElseThrow(() -> new RuntimeException("Product not Found"));
	}

	// get all products
	public List<Product> getAllProducts(){
		return productRepository.findAll();
	}
	
	
	//update product
	public Product updateProduct(Product product, Long product_id) {
		Product existingProduct = getProductById(product_id);
		existingProduct.setName(product.getName());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct.setPrice(product.getPrice());
		return productRepository.save(existingProduct);
	}
	
	//delete product
	public boolean deleteProduct(Long product_id) {
		productRepository.deleteById(product_id);
		return true;
	}
	
	public List<Product> getLowStockProducts(int threshold){
		return productRepository.findAll().stream().filter(p -> p.getQuantity() <= threshold).toList();
	}
}
