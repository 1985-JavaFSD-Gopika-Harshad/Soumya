package com.library.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.system.model.Books;

public interface BooksRepository extends JpaRepository<Books, Long> {

}
