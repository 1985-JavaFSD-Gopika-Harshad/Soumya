package com.library.system.dto;

  
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
public class BorrowersResponse {
	private Long borrowerId;
	private String name;
	private String email;
	 

}
