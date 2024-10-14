package com.student.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dto.StudentDetailsRequest;
import com.student.dto.StudentDetailsResponse;
import com.student.model.StudentDetails;
import com.student.repository.StudentDetailsRepository;

@Service
public class StudentDetailsService {
	
		private final StudentDetailsRepository studentDetailsRepository;
	
	@Autowired
	public StudentDetailsService(StudentDetailsRepository studentDetailsRepository) {
		this.studentDetailsRepository = studentDetailsRepository;
	}
	
	public StudentDetails mapToStudentDetails(StudentDetailsRequest studentdetailsRequest) {
		return StudentDetails.builder()
				.firstName(studentdetailsRequest.getFirstName())
				.lastName(studentdetailsRequest.getLastName())
				.dateOfBirth(studentdetailsRequest.getDateOfBirth())
				.gender(studentdetailsRequest.getGender())
				.Email(studentdetailsRequest.getEmail())
				.phoneNumber(studentdetailsRequest.getPhoneNumber())
				.Address(studentdetailsRequest.getAddress())
				.build();
	}
	
	public StudentDetailsResponse mapToStudentDetailsResponse(StudentDetails studentDetails) {
		return StudentDetailsResponse.builder()
				.studentId(studentDetails.getStudentId())
				.firstName(studentDetails.getFirstName())
				.lastName(studentDetails.getLastName())
				.dateOfBirth(studentDetails.getDateOfBirth())
				.gender(studentDetails.getGender())
				.Email(studentDetails.getEmail())
				.phoneNumber(studentDetails.getPhoneNumber())
				.Address(studentDetails.getAddress())
				.build();
	}
	
	// creating student details
	public StudentDetailsResponse createStudentDetails(StudentDetailsRequest studentDetailsRequest) {
		try {
			StudentDetails studentDetails =studentDetailsRepository.save(mapToStudentDetails(studentDetailsRequest));
			return mapToStudentDetailsResponse(studentDetails);
		}
		catch (Exception e) {
			throw new RuntimeException("failed to create student details");
		}
	}

}
