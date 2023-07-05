package com.sparta.springlv2.service;

import com.sparta.springlv2.dto.PostListResponseDto;
import com.sparta.springlv2.dto.PostRequestDto;
import com.sparta.springlv2.dto.PostResponseDto;
import com.sparta.springlv2.entity.Post;
import com.sparta.springlv2.entity.User;
import com.sparta.springlv2.entity.UserRoleEnum;
import com.sparta.springlv2.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import java.util.stream.Collectors;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostResponseDto createPost(PostRequestDto requestDto, User user) {
        // RequestDto -> Entity -> ResponseDto

        // RequestDto -> Entity
        Post post = new Post(requestDto);
        post.setUser(user);

        // DB 저장
        postRepository.save(post);

        // Entity -> ResponseDto
        PostResponseDto postResponseDto = new PostResponseDto(post);

        return postResponseDto;
    }

    public PostListResponseDto getPosts() {
        // DB 조회
        List<PostResponseDto> postList = postRepository.findAll().stream()
                .map(PostResponseDto::new)
                .collect(Collectors.toList());
        return new PostListResponseDto(postList);
    }

    public PostResponseDto getPost(Long id) {
        // 해당 포스트가 DB에 있는지 체크
        Post post = findPost(id);

        return new PostResponseDto(post);
    }

    @Transactional
    public PostResponseDto updatePost(Long id, PostRequestDto requestDto, User user) {
        // 해당 포스트가 DB에 있는지 체크
        Post post = findPost(id);

        // 게시글 작성자(post.user)와 요청자(user)가 같은지 또는 어드민 인지 체크
        if(!user.getRole().equals(UserRoleEnum.ADMIN) && !post.getUser().equals(user)) {
            throw new RejectedExecutionException();
        }

        // 내용 수정
        post.setTitle(requestDto.getTitle());
        post.setContent(requestDto.getContent());

        return new PostResponseDto(post);
    }

    public void deletePost(Long id, User user) {
        // 해당 포스트가 DB에 있는지 체크
        Post post = findPost(id);

        // 사용자 체크
        if(!user.getRole().equals(UserRoleEnum.ADMIN) && !post.getUser().equals(user)) {
            throw new RejectedExecutionException();
        }
        // 내용 삭제
        postRepository.delete(post);
    }

    public Post findPost(Long id) {
        // Optional Check
        return postRepository.findById(id).orElseThrow( () ->
                new IllegalArgumentException("선택한 게시글은 존재하지 않습니다")
        );
    }
}

