package com.library.system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.system.dto.AuthorRequest;
import com.library.system.dto.AuthorResponse;
import com.library.system.service.AuthorService;

@RestController
@RequestMapping("/author/")
public class AuthorController {
	private final AuthorService authorService;
	
	@Autowired
	public AuthorController(AuthorService authorService) {
		this.authorService= authorService;
	}
	
	@PostMapping
	public AuthorResponse createAuthor(@RequestBody AuthorRequest authorRequest) {
		return authorService.createAuthor(authorRequest);
	}


}
