package com.online.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.online.store.model.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
