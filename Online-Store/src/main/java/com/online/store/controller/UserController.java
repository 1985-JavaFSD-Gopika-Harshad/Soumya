package com.online.store.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.online.store.dto.UserRequest;
import com.online.store.dto.UserResponse;
import com.online.store.service.UserService;

@RestController
@RequestMapping("/api/user/")
public class UserController {
	
	@Autowired 
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping
	public UserResponse createUser(@RequestBody UserRequest userRequest) {
		return userService.createUser(userRequest);
	}
	
	@GetMapping("{user_id}")
	public UserResponse getUserById(@PathVariable Long user_id) {
		return userService.getUserById(user_id);
	}
	
	@GetMapping("all")
	public List<UserResponse> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@PutMapping("update/{user_id}")
	public UserResponse updateUser(@RequestBody UserRequest userRequest,@PathVariable Long user_id) {
		return userService.updateUser(userRequest, user_id);
	}
	
	@DeleteMapping("{user_id}")
	public boolean deleteUser(@PathVariable Long user_id) {
		return userService.deleteUser(user_id);
	}






}
