package com.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.dto.StudentDetailsRequest;
import com.student.dto.StudentDetailsResponse;
import com.student.service.StudentDetailsService;

@RestController
@RequestMapping("/studentDetails")
public class StudentDetailsController {
	
	private final StudentDetailsService studentDetailsService;
	
	@Autowired
	public StudentDetailsController(StudentDetailsService studentDetailsService) {
		this.studentDetailsService = studentDetailsService;
	}
	
	@PostMapping
	public StudentDetailsResponse createStudentDetails(@RequestBody StudentDetailsRequest studentDetailsRequest) {
		return studentDetailsService.createStudentDetails(studentDetailsRequest);
	}

}
