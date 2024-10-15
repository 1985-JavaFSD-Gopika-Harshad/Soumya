package com.student.service;

import java.util.List;

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
	
	//get student details by studentId
	public StudentDetailsResponse getStudentByStudentId(Long studentId) {
		StudentDetails studentDetails = studentDetailsRepository.getStudentDetailsBystudentId(studentId);
		return mapToStudentDetailsResponse(studentDetails);
	}
	
	//get all student details 
	public List<StudentDetailsResponse> getAllStudents(){
		List<StudentDetails> studentDetails = studentDetailsRepository.findAll();
		return studentDetails.stream()
				.map(this::mapToStudentDetailsResponse)
				.toList();
	}
	
	// to update student details
	public StudentDetailsResponse updateStudentDetails(StudentDetailsRequest studentDetailsRequest, Long studentId) {
		StudentDetails studentDetails = studentDetailsRepository.getStudentDetailsBystudentId(studentId);
		
		studentDetails.setFirstName(studentDetailsRequest.getFirstName());
		studentDetails.setLastName(studentDetailsRequest.getLastName());
		studentDetails.setDateOfBirth(studentDetailsRequest.getDateOfBirth());
		studentDetails.setGender(studentDetailsRequest.getGender());
		studentDetails.setEmail(studentDetailsRequest.getEmail());
		studentDetails.setPhoneNumber(studentDetailsRequest.getPhoneNumber());
		studentDetails.setAddress(studentDetailsRequest.getAddress());

		StudentDetails update = studentDetailsRepository.save(studentDetails);
		return mapToStudentDetailsResponse(update);

	}
	
	// to delete student details 
	public boolean deleteStudentDeails(Long studentId) {
		StudentDetails studentDetails = studentDetailsRepository.getStudentDetailsBystudentId(studentId);
		studentDetailsRepository.delete(studentDetails);
		return true;

	}

}
