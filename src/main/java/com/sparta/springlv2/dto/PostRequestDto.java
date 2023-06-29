package com.sparta.springlv2.dto;

import lombok.Getter;

@Getter
public class PostRequestDto {
    private String title;
    private String content;
    private String author;
    private String password;
}

