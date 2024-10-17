package com.library.system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.system.dto.AuthorRequest;
import com.library.system.dto.AuthorResponse;
import com.library.system.model.Author;
import com.library.system.repository.AuthorRepository;

@Service
public class AuthorService {
	private AuthorRepository authorRepository;
	
	@Autowired
	public AuthorService(AuthorRepository authorRepository) {
		this.authorRepository =authorRepository;
	}
	
	public Author mapToAuthor(AuthorRequest authorRequest) {
		return Author.builder()
				.name(authorRequest.getName())
				.build();
	}
	
	public AuthorResponse mapToAuthorResponse(Author author) {
		return AuthorResponse.builder()
				.authorId(author.getAuthorId())
				.name(author.getName())
				.build();
	}
	
	public AuthorResponse createAuthor(AuthorRequest authorRequest) {
		Author author = authorRepository.save(mapToAuthor(authorRequest));
		return mapToAuthorResponse(author);
	}

}
