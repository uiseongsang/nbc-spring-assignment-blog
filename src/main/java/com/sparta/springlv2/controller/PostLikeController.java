package com.sparta.springlv2.controller;

import com.sparta.springlv2.dto.ApiResponseDto;
import com.sparta.springlv2.security.UserDetailsImpl;
import com.sparta.springlv2.service.PostLikeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.RejectedExecutionException;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class PostLikeController {

    private final PostLikeService postLikeService;

    @PostMapping("/post/{post_id}/likes")
    public ResponseEntity<ApiResponseDto> toggleLikeOnPost(@PathVariable Long post_id, @AuthenticationPrincipal UserDetailsImpl userDetails){

        try{
            boolean isLiked = postLikeService.checkLiked(post_id, userDetails.getUser());

            if(isLiked) {
                postLikeService.removeLikeOnPost(post_id,userDetails.getUser());
                return ResponseEntity.ok().body( new ApiResponseDto("게시글 좋아요 취소가 되었습니다.", HttpStatus.OK.value()));
            } else {
                postLikeService.addLikeOnPost(post_id,userDetails.getUser());
                return ResponseEntity.ok().body(new ApiResponseDto("게시글 좋아요 생성되었습니다", HttpStatus.CREATED.value()));
            }
        } catch (RejectedExecutionException e){
            return ResponseEntity.badRequest().body(new ApiResponseDto("유효하지 않는 토큰 입니다.", HttpStatus.UNAUTHORIZED.value()));
        }
    }
}
