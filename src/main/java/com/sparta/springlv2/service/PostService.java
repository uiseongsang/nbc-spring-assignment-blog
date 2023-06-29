package com.sparta.springlv2.service;

import com.sparta.springlv2.dto.PostRequestDto;
import com.sparta.springlv2.dto.PostResponseDto;
import com.sparta.springlv2.entity.Post;
import com.sparta.springlv2.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostResponseDto createPost(PostRequestDto requestDto) {
        // RequestDto -> Entity -> ResponseDto

        // RequestDto -> Entity
        Post post = new Post(requestDto);

        // DB 저장
        Post savePost = postRepository.save(post);

        // Entity -> ResponseDto
        PostResponseDto postResponseDto = new PostResponseDto(post);

        return postResponseDto;
    }

    public List<PostResponseDto> getPosts() {
        // DB 조회
        return postRepository.findAllByOrderByCreatedAtDesc().stream().map(PostResponseDto::new).toList();
    }

    public PostResponseDto getPost(Long id, PostRequestDto requestDto) {
        // 해당 포스트가 DB에 있는지 체크
        Post post = findPost(id);

        return new PostResponseDto(post);
    }

    @Transactional
    public PostResponseDto updatePost(Long id, PostRequestDto requestDto) {
        // 해당 포스트가 DB에 있는지 체크
        Post post = findPost(id);

        if(validatePassword(post.getPassword(),requestDto.getPassword()) == true) {
            // 내용 수정
            post.update(requestDto);
        } else {
            System.out.println("비번이 틀립니다");
        }
        return new PostResponseDto(post);
    }

    public void deletePost(Long id, String password) {
        // 해당 포스트가 DB에 있는지 체크
        Post post = findPost(id);

        if(validatePassword(post.getPassword(),password) == true) {
            // 내용 삭제
            postRepository.delete(post);
        } else {
            System.out.println("비번이 틀립니다");
        }
    }

    private Boolean validatePassword(String password1, String password2){
        if(password1.equals(password2)) {
            return true;
        } else {
            return false;
        }
    }
    private Post findPost(Long id) {
        // Optional Check
        return postRepository.findById(id).orElseThrow( () ->
                new IllegalArgumentException()
        );
    }
}

