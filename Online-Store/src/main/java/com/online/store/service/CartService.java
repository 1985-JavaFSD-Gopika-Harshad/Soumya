package com.online.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.store.dto.CartItemRequest;
import com.online.store.dto.CartItemResponse;
import com.online.store.dto.CartResponse;
import com.online.store.model.Cart;
import com.online.store.model.CartItem;
import com.online.store.model.Product;
import com.online.store.model.User;
import com.online.store.repository.CartItemRepository;
import com.online.store.repository.CartRepository;
import com.online.store.repository.ProductRepository;
import com.online.store.repository.UserRepository;

@Service
public class CartService {
	
	@Autowired
	private CartRepository cartRepository;
	
	@Autowired
	private CartItemRepository cartItemRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public CartService(CartRepository cartRepository, CartItemRepository cartItemRepository, ProductRepository productRepository, UserRepository userRepository) {
		this.cartRepository = cartRepository;
		this.cartItemRepository = cartItemRepository;
		this.productRepository = productRepository;
		this.userRepository = userRepository;
	}
	
	public CartItemResponse mapToCartItemResponse(CartItem cartItem) {
		  CartItemResponse cartitemResponse = new CartItemResponse();
		  
		 cartitemResponse.setCartitems_id(cartItem.getCartitems_id());
		 cartitemResponse.setProduct_name(cartItem.getProduct().getProduct_name());
		 cartitemResponse.setQuantity(cartItem.getQuantity());
		 cartitemResponse.setProductPrice(cartItem.getProduct().getPrice());
		 cartitemResponse.setTotalPrice(cartItem.getQuantity() * cartItem.getProduct().getPrice());
		 return cartitemResponse;
				 
	}
	
	public CartResponse mapToCartResponse(Cart cart) {
		List<CartItemResponse> cartItemResponse = cart.getCartItems()
				                                      .stream()
				                                      .map(this::mapToCartItemResponse)
				                                      .toList();
		double totalPrice = cartItemResponse.stream()
				                            .mapToDouble(CartItemResponse::getTotalPrice).sum();
		
		CartResponse cartResponse = new CartResponse();
		cartResponse.setCart_id(cart.getCart_id());
		cartResponse.setCartitems(cartItemResponse);
		
		 return cartResponse;
	}
	
	public CartResponse addToCart(Long user_id, CartItemRequest cartItemRequest) {
		User user =userRepository.findById(user_id).orElseThrow();
		
		Cart cart = cartRepository.findByUser(user);
		
		if(cart == null) {
			cart = new Cart();
			cart.setUser(user);
			cartRepository.save(cart);
		}
		
		Product product
		
	}
	
	
	

}
