package com.blog.system.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.system.dto.commentRequest;
import com.blog.system.dto.commentResponse;
import com.blog.system.model.Comment;
import com.blog.system.model.Post;
import com.blog.system.repository.CommentRepository;
import com.blog.system.repository.PostRepository;

@Service
public class CommentService {
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	public CommentService(CommentRepository commentRepository, PostRepository postRepository ) {
		this.commentRepository = commentRepository;
		this.postRepository = postRepository;
	}
	
	public Comment mapToComment(commentRequest commentrequest) {
		return Comment.builder()
				.content(commentrequest.getContent())
				.createdAt(LocalDateTime.now())
				.build();
	}
	
	public commentResponse mapToCommentResponse(Comment comment) {
		return commentResponse.builder()
				.comment_id(comment.getComment_id())
				.content(comment.getContent())
				.createdAt(comment.getCreatedAt())
				.build();
	}
	
	//add a comment
	public commentResponse createComment(commentRequest commentrequest, Long post_id) {
		 Optional<Post> post = postRepository.findById(commentrequest.getPost_id());
		return mapToCommentResponse(post);
 				 
	}
	
	

}
