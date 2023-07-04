package com.sparta.springlv2.controller;

import com.sparta.springlv2.dto.ApiResponseDto;
import com.sparta.springlv2.dto.PostListResponseDto;
import com.sparta.springlv2.dto.PostResponseDto;
import com.sparta.springlv2.dto.PostRequestDto;
import com.sparta.springlv2.security.UserDetailsImpl;
import com.sparta.springlv2.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.RejectedExecutionException;


@RestController
@RequestMapping("/api")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/post")
    public ResponseEntity<PostResponseDto> createPost(@AuthenticationPrincipal UserDetailsImpl userDetails, @RequestBody PostRequestDto requestDto){
        PostResponseDto result = postService.createPost(requestDto, userDetails.getUser());

        return ResponseEntity.status(201).body(result);
    }

    @GetMapping("/posts")
    public ResponseEntity<PostListResponseDto> getPosts() {
        PostListResponseDto result = postService.getPosts();

        return ResponseEntity.ok().body(result);
    }

    @GetMapping("/post/{id}")
    public ResponseEntity<PostResponseDto> getPost(@PathVariable Long id){
        PostResponseDto result = postService.getPost(id);

        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/post/{id}")
    public ResponseEntity<PostResponseDto> updatePost(@AuthenticationPrincipal UserDetailsImpl userDetails ,@PathVariable Long id, @RequestBody PostRequestDto requestDto){

        try {
            PostResponseDto result = postService.updatePost(id,requestDto,userDetails.getUser());
            return ResponseEntity.ok().body(result);
        }
        catch (RejectedExecutionException e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/post/{id}")
    public ResponseEntity<ApiResponseDto> deletePost(@AuthenticationPrincipal UserDetailsImpl userDetails, @PathVariable Long id){
        try {
            postService.deletePost(id, userDetails.getUser());
            return ResponseEntity.ok().body(new ApiResponseDto("게시글 삭제 성공", HttpStatus.OK.value()));
        }
        catch (RejectedExecutionException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
