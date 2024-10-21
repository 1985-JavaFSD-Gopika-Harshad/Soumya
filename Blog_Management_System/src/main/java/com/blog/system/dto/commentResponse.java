package com.blog.system.dto;

import java.time.LocalDateTime;

import com.blog.system.model.Post;

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
public class commentResponse {
	
	private Long comment_id;
	private String content;
	private LocalDateTime createdAt;
	private Long post_id;



}
