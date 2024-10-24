package com.online.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.online.store.dto.UserRequest;
import com.online.store.dto.UserResponse;
import com.online.store.model.User;
import com.online.store.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public UserResponse mapToUserResponse(User user) {
		return UserResponse.builder()
				.user_id(user.getUser_id())
				.username(user.getUsername())
				.email(user.getEmail())
				.password(user.getPassword())
 				.build();
	}
	
	//create user
	public UserResponse createUser(UserRequest userRequest) {
		User user = User.builder()
				.username(userRequest.getUsername())
				.email(userRequest.getEmail())
				.password(userRequest.getPassword())
				.build();
		User saveUser=	userRepository.save(user);
		return  mapToUserResponse(saveUser);
	}
	
	//get user by id
	public UserResponse getUserById(Long user_id) {
		User user = userRepository.getById(user_id);
		return mapToUserResponse(user);
	}
	
	//get all users
	public List<UserResponse> getAllUsers(){
		List<User> users = userRepository.findAll();
		return users.stream()
				.map(this::mapToUserResponse)
				.toList();
	}
	
	//update user
	public UserResponse updateUser(UserRequest userRequest, Long user_id) {
		User existingUser = userRepository.getById(user_id);
		
		existingUser.setUsername(userRequest.getUsername());
		existingUser.setEmail(userRequest.getEmail());
		existingUser.setPassword(userRequest.getPassword());
		
		User userUpdated = userRepository.save(existingUser);
		return mapToUserResponse(userUpdated);
	}
	
	//delete user
	public boolean deleteUser(Long user_id) {
		User user =userRepository.getById(user_id);
		userRepository.delete(user);
		return true;
		
	}

}
