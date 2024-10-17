package com.library.system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.system.dto.BooksRequest;
import com.library.system.dto.BooksResponse;
import com.library.system.model.Books;
import com.library.system.repository.BooksRepository;

@Service
public class BookService {
	
	private final BooksRepository booksRepository;
	
	@Autowired
	public BookService(BooksRepository booksRepository) {
		this.booksRepository = booksRepository;
	}
	
	public Books mapToBooks(BooksRequest booksRequest) {
		return Books.builder()
				.title(booksRequest.getTitle())
				.isAvailable(booksRequest.isAvailable())
				.author(booksRequest.getAuthor())
				.build();
	}
	
	public BooksResponse mapBooksResponse(Books books) {
		return BooksResponse.builder()
				.bookId(books.getBookId())
				.title(books.getTitle())
				.isAvailable(books.isAvailable())
				.author(books.getAuthor())
				.build();
	}
	
	
	// adding books
	public BooksResponse createBooks(BooksRequest booksRequest) {
		Books books = booksRepository.save(mapToBooks(booksRequest));
		return mapBooksResponse(books);
	}
	
	//get book by id
	public BooksResponse getBookById(Long bookId) {
		Books books= booksRepository.getById(bookId);
		return mapBooksResponse(books);
	}
	
	//get all books
	public List<BooksResponse> getAllBooks(){
		List<Books> books = booksRepository.findAll();
		return books.stream()
				.map(this::mapBooksResponse)
				.toList();
	}
	
	//update books
	public BooksResponse updateBooks(BooksRequest booksRequest, Long bookId) {
		Books books= booksRepository.getById(bookId);
		
		books.setTitle(booksRequest.getTitle());
		books.setAvailable(booksRequest.isAvailable());
		books.setAuthor(booksRequest.getAuthor());
		
		Books updatebooks = booksRepository.save(books);
		return mapBooksResponse(updatebooks);

	}
	
	//delete a book
	public boolean deleteBooks(Long bookId) {
		Books books = booksRepository.getById(bookId);
		booksRepository.delete(books);
		return true;
	}
	

}
