package com.library.system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.system.dto.BooksRequest;
import com.library.system.dto.BooksResponse;
import com.library.system.service.BookService;

@RestController
@RequestMapping("/books")
public class BooksController {
	  
	 private final BookService bookService;
	 @Autowired
	 public BooksController(BookService bookService) {
		 this.bookService = bookService;
	 }

	@PostMapping
	public BooksResponse createBooks(@RequestBody BooksRequest booksRequest) {
		return bookService.createBooks(booksRequest);
	}
	
	@GetMapping("/{bookId}")
	public BooksResponse getBookById(@PathVariable Long bookId) {
		return bookService.getBookById(bookId);
	}
	
	@GetMapping("/allbooks")
	public List<BooksResponse> getAllBooks(){
		return bookService.getAllBooks();
	}
	
	@PutMapping("/{bookId}")
	public BooksResponse updateBooks(@RequestBody BooksRequest booksRequest,@PathVariable Long bookId) {
		return bookService.updateBooks(booksRequest, bookId);
	}
	
	@DeleteMapping("/{bookId}")
	public boolean deleteBooks(@PathVariable Long bookId) {
		return bookService.deleteBooks(bookId);
	}






}
