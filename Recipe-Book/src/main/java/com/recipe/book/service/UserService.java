package com.recipe.book.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.book.model.User;
import com.recipe.book.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
		
	}
	
	//create user
	public User createuser(User user) {
		return userRepository.save(user);
	}
	
	//get user by id
	public Optional<User> getUserById(Long userId) {
		return userRepository.findById(userId);
	}
	
	//get all users
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	//update user
	public User updateUser(User user, Long userId) {
		User existingUser = userRepository.getById(userId);
		existingUser.setUsername(user.getUsername());
		existingUser.setEmail(user.getEmail());
		existingUser.setPassword(user.getPassword());
		
		 return userRepository.save(existingUser);
	}
	
	
	//delete user
	public boolean deleteUser(Long userId) {
		User user = userRepository.getById(userId);
	    	userRepository.delete(user);
	    	return true;
	}
	
	//login 
	public Optional<User> loginUser(String email, String password){
		Optional<User> user = userRepository.findByEmail(email);
		if(user.isPresent() && user.get().getPassword().equals(password))
		{
			return user;
		}
		return Optional.empty();
	}

}
