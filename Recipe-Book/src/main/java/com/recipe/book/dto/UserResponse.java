package com.recipe.book.dto;

import lombok.Data;

@Data

public class UserResponse {
	
    private Long userId;
	private String username;
	private String email;
 	private String password;

}
