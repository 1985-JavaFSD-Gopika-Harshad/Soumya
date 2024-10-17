package com.library.system.dto;

import java.time.LocalDateTime;

 import com.library.system.model.Books;
import com.library.system.model.Borrowers;

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
public class CheckDatesResponse {
	private Long id;
	private Books book;
	private Borrowers borrower;
	private LocalDateTime borrowDate;
	private LocalDateTime returnDate;

}
