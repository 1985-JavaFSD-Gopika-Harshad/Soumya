package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.dto.StudentDetailsRequest;
import com.student.dto.StudentDetailsResponse;
import com.student.service.StudentDetailsService;

@RestController
@RequestMapping("/details")
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
	
	@GetMapping("/id/{studentId}")
	public StudentDetailsResponse getStudentByStudentId(@PathVariable Long studentId) {
		return studentDetailsService.getStudentByStudentId(studentId);
	}
	
	@GetMapping("/all")
	public List<StudentDetailsResponse> getAllStudents(){
		return studentDetailsService.getAllStudents();
	}
	
	@PutMapping("/update/{studentId}")
	public StudentDetailsResponse updateStudentDetails(@RequestBody StudentDetailsRequest studentDetailsRequest, @PathVariable Long studentId) {
		return studentDetailsService.updateStudentDetails(studentDetailsRequest, studentId);
	}
	
	@DeleteMapping("/delete/{studentId}")
	public boolean deleteStudentDeails(@PathVariable Long studentId) {
		return studentDetailsService.deleteStudentDeails(studentId);
	}





}
