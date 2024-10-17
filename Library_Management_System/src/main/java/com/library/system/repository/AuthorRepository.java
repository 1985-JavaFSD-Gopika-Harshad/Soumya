package com.library.system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.system.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long>{

}
