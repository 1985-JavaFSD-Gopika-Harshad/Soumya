package com.blog.system.controller;

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

import com.blog.system.dto.postRequest;
import com.blog.system.dto.postResponse;
import com.blog.system.service.PostService;

@RestController
@RequestMapping("/post/")
public class PostController {
	
    @Autowired
    private PostService postService;
    
    public PostController(PostService postService) {
    	this.postService = postService;
    }
    
    @PostMapping
	public postResponse createPost(@RequestBody postRequest postrequest) {
		return postService.createPost(postrequest);
	}
    
    @GetMapping("{post_id}")
	public postResponse getPostById(@PathVariable Long post_id) {
    	return postService.getPostById(post_id);
    }
    
    @GetMapping("allPosts")
    public List<postResponse> getAllPosts(){
    	return postService.getAllPosts();
     }
    
    @PutMapping("{post_id}")
    public postResponse updatePost(@RequestBody postRequest postrequest,@PathVariable Long post_id) {
    	return postService.updatePost(postrequest, post_id);
    }
    
    @DeleteMapping("{post_id}")
	public boolean deletePost(@PathVariable Long post_id) {
    	return postService.deletePost(post_id);
    }



}
