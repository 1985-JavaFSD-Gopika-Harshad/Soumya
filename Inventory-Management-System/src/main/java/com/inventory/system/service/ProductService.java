package com.inventory.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inventory.system.dto.ProductRequest;
import com.inventory.system.dto.ProductResponse;
import com.inventory.system.model.Category;
import com.inventory.system.model.Product;
import com.inventory.system.model.Supplier;
import com.inventory.system.repository.CategoryRepository;
import com.inventory.system.repository.ProductRepository;
import com.inventory.system.repository.SupplierRepository;

@Service
public class ProductService {
	
	@Autowired
	private final ProductRepository productRepository;
	
	@Autowired
    private final CategoryRepository categoryRepository;

    @Autowired
    private final SupplierRepository supplierRepository;
	
	public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository, SupplierRepository supplierRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
        this.supplierRepository = supplierRepository;
	}
	
	//mapping to productResponse
	public ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .product_id(product.getProduct_id())
                .name(product.getName())
                .description(product.getDescription())
                .quantity(product.getQuantity())
                .price(product.getPrice())
                .categoryName(product.getCategory().getName())  // Get Category Name
                .supplierName(product.getSupplier().getName())  // Get Supplier Name
                .build();
	}
	
 	
	//creating products
	public ProductResponse createProduct(ProductRequest productRequest) {
        Category category = categoryRepository.findById(productRequest.getCategory_id())
                .orElseThrow(() -> new RuntimeException("Category not found"));

        Supplier supplier = supplierRepository.findById(productRequest.getSupplier_id())
                .orElseThrow(() -> new RuntimeException("Supplier not found"));

        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .quantity(productRequest.getQuantity())
                .price(productRequest.getPrice())
                .category(category)
                .supplier(supplier)
                .build();

        Product savedProduct = productRepository.save(product);
        return mapToProductResponse(savedProduct);
    }
	
	
	//get product by product_id
	public ProductResponse getProductById(Long productId) {
        Product product = productRepository.findById(productId)
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

        Supplier supplier = supplierRepository.findById(productRequest.getSupplier_id())
                .orElseThrow(() -> new RuntimeException("Supplier not found"));

        existingProduct.setName(productRequest.getName());
        existingProduct.setDescription(productRequest.getDescription());
        existingProduct.setQuantity(productRequest.getQuantity());
        existingProduct.setPrice(productRequest.getPrice());
        existingProduct.setCategory(category);
        existingProduct.setSupplier(supplier);

        Product updatedProduct = productRepository.save(existingProduct);
        return mapToProductResponse(updatedProduct);
    }
	
	//delete product
	public boolean deleteProduct(Long product_id) {
		Product product = productRepository.getById(product_id);
		productRepository.delete(product);
		return true;
	}
	
	public List<ProductResponse> getLowStockProducts(int threshold){
		List<Product> products = productRepository.findAll();
		return products.stream()
				.filter(product -> product.getQuantity() <= threshold)
				.map(this::mapToProductResponse)
				.toList();
	}
}
