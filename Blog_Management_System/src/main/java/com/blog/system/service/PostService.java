package com.blog.system.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.system.dto.postRequest;
import com.blog.system.dto.postResponse;
import com.blog.system.model.Post;
import com.blog.system.repository.CommentRepository;
import com.blog.system.repository.PostRepository;

@Service
public class PostService {
	
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private CommentRepository commentRepository;
	
	public PostService(PostRepository postRepository, CommentRepository commentRepository ) {
		this.postRepository = postRepository;
		this.commentRepository = commentRepository;
	}
	
	
	public Post mapToPost(postRequest postrequest) {
		return Post.builder()
				.title(postrequest.getTitle())
				.content(postrequest.getContent())
				.createdAt(LocalDateTime.now())
				.build();
	}	
	public postResponse mapTopostResponse(Post post) {
		return postResponse.builder()
				.post_id(post.getPost_id())
				.title(post.getTitle())
				.content(post.getContent())
				.createdAt(post.getCreatedAt())
				.build();
	}
	
	//create a blog post	
	public postResponse createPost(postRequest postrequest) {
		Post post = postRepository.save(mapToPost(postrequest));
		return mapTopostResponse(post);
	}
	
	//get a particular post by post_id
	public postResponse getPostById(Long post_id) {
		Post post = postRepository.getById(post_id);
		return mapTopostResponse(post);
	}
	
	//get all posts
    public List<postResponse> getAllPosts(){
    	List<Post> post = postRepository.findAll();
    	return post.stream()
    			.map(this::mapTopostResponse)
    			.toList();
    }
    
    //update post
    public postResponse updatePost(postRequest postrequest, Long post_id) {
    	Post post = postRepository.getById(post_id);
    	
    	post.setTitle(postrequest.getTitle());
    	post.setContent(postrequest.getContent());
    	post.setCreatedAt(LocalDateTime.now());
    	
    	Post update = postRepository.save(post);
    	return mapTopostResponse(update);
    	
    }

	
	//delete a post
	public boolean deletePost(Long post_id) {
		Post post = postRepository.getById(post_id);
		postRepository.delete(post);
		return true;
	}

}
