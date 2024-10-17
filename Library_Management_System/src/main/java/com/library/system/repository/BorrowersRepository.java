package com.library.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.system.model.Borrowers;

public interface BorrowersRepository extends JpaRepository<Borrowers, Long>{

}
