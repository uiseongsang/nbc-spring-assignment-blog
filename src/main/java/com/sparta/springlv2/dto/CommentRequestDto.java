package com.sparta.springlv2.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequestDto {
    private Long postId;
    private String body;
}