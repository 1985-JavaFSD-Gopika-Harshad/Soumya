package com.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.student.model.StudentDetails;

public interface StudentDetailsRepository  extends JpaRepository<StudentDetails, Long>{

}
