package com.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.student.model.StudentDetails;

@Repository
public interface StudentDetailsRepository  extends JpaRepository<StudentDetails, Long>{
	StudentDetails getStudentDetailsBystudentId(Long studentId);
}
