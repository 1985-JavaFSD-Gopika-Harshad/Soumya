package com.recipe.book.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.recipe.book.model.User;
import com.recipe.book.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/api/user/")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping
	public User createuser(@RequestBody User user) {
		return userService.createuser(user);
		
	}
	
	@GetMapping("{userId}")
	public Optional<User> getUserById(@PathVariable Long userId) {
		return userService.getUserById(userId);
	}
	
	@GetMapping("all")
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	@PutMapping("{userId}")
	public User updateUser(@RequestBody User user,@PathVariable Long userId) {
		return userService.updateUser(user, userId);
	}
	
	@DeleteMapping("{userId}")
	public boolean deleteUser(@PathVariable Long userId) {
		return userService.deleteUser(userId);
	}

	
	@PostMapping("/login")
	public String loginUser(@RequestParam String email,@RequestParam String password, HttpSession session, Model model){
		
	Optional<User> user = userService.loginUser(email, password);
	if(user.isPresent())
	{
		session.setAttribute("LoggedInUser", user.get());
		return "redirect:recipes";
	}
	else {
		model.addAttribute("error", "Invalid email or password");
		return "Login";
		}
		
	}
	
	@PostMapping("/register")
	public String createUser(@ModelAttribute User user, Model model) {
 		userService.createuser(user);
		return "redirect:Login";
	}

  
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:Login";
	}




}
