package com.blog.system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.system.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
	List<Post> findByTitleContainingOrContentContaining(String title, String content);

}
