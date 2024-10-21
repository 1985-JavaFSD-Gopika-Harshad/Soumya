package com.blog.system.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.blog.system.model.Comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder 
public class postResponse {
	private Long post_id;
	private String title;
	private String content;
	private LocalDateTime createdAt;
	
 	private List<Comment> comments;

}
