package com.sparta.springlv2.dto;

import com.sparta.springlv2.entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;
    private LocalDateTime createAt;
    private LocalDateTime modifiedAt;
    private Boolean success;

    public PostResponseDto(Post post){
        this.id = post.getId();
        this.title = post.getTitle();
        this.content = post.getContent();
        this.author = post.getAuthor();
        this.createAt = post.getCreatedAt();
        this.modifiedAt = post.getModifiedAt();
    }

    public PostResponseDto(Boolean success) {
        this.success = success;
    }
}

