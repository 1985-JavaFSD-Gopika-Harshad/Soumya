package com.library.system.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Entity
@Table(name ="borrowers")
public class Borrowers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long borrowerId;
	private String name;
	private String email;
	

}
