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
	public Product createProduct(@RequestBody Product product) {
		return productService.createProduct(product);
	}
	
	@GetMapping("{product_id}")
	public Product getProductById(@PathVariable Long product_id) {
		return productService.getProductById(product_id);
	}
	
	@GetMapping("all")
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@PutMapping("update/{product_id}")
	public Product updateProduct(@RequestBody Product product,@PathVariable Long product_id) {
		return productService.updateProduct(product, product_id);
	}
	
	@DeleteMapping("{product_id}")
	public boolean deleteProduct(@PathVariable Long product_id) {
		return productService.deleteProduct(product_id);
	}
	
	@GetMapping("lowStock/")
	public List<Product> getLowStockProducts(@RequestParam int threshold){
		return productService.getLowStockProducts(threshold);
		
	}


	





}
