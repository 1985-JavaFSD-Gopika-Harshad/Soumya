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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inventory.system.dto.ProductRequest;
import com.inventory.system.dto.ProductResponse;
import com.inventory.system.model.Product;
import com.inventory.system.service.ProductService;

@RestController
@RequestMapping("/product/")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}
	
	
	@PostMapping
	public ProductResponse createProduct(@RequestBody ProductRequest productRequest) {
		return productService.createProduct(productRequest);
	}

	
	@GetMapping("{product_id}")
	public ProductResponse getProductById(@PathVariable Long productId) {
		return productService.getProductById(productId);
	}

	
	@GetMapping("all")
	public List<ProductResponse> getAllProducts() {
		return productService.getAllProducts();
	}

	
	@PutMapping("update/{product_id}")
	public ProductResponse updateProduct(@RequestBody ProductRequest productRequest,@PathVariable Long product_id) {
		return productService.updateProduct(productRequest, product_id);
	}

	
	@DeleteMapping("{product_id}")
	public boolean deleteProduct(@PathVariable Long product_id) {
		return productService.deleteProduct(product_id);
	}

	
	@GetMapping("lowStock/")
	public List<ProductResponse> getLowStockProducts(@RequestParam int threshold){
		return productService.getLowStockProducts(threshold);
	}



	





}
