package com.library.system.dto;

import com.library.system.model.Author;
 
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BooksResponse {
	
	private Long bookId;
	private String title;
	private boolean isAvailable;
	private Author author;


}
