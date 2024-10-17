package com.library.system.dto;

import java.util.List;

 import com.library.system.model.Books;

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
public class AuthorRequest {
 	private String name;
 	private List<Books> books;


}
