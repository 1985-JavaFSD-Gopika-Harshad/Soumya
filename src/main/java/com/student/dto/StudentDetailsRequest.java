package com.student.dto;

import java.util.Date;

import com.student.model.Gender;

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
public class StudentDetailsRequest {
	private String firstName;
	private String lastName;
	private Date dateOfBirth;
 	private Gender gender;
	private String Email;
	private String phoneNumber;
	private String Address;

}
