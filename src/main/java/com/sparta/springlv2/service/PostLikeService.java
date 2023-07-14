package com.sparta.springlv2.service;

import com.sparta.springlv2.entity.Post;
import com.sparta.springlv2.entity.PostLike;
import com.sparta.springlv2.entity.User;
import com.sparta.springlv2.repository.PostLikeRepository;
import com.sparta.springlv2.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostLikeService {

    private final PostLikeRepository postLikeRepository;
    private final PostRepository postRepository;

    public boolean checkLiked(Long postId, User user) {
        PostLike postLike = postLikeRepository.findByPostIdAndUser(postId,user);
        return (postLike != null) && postLike.isLiked();
    }

    public void addLikeOnPost(Long postId, User user) {
        Post post = postRepository.findById(postId).orElseThrow( ()
            -> new IllegalArgumentException("해당 게시글은 존재하지 않습니다.")
        );

        PostLike postLike = new PostLike(true, user, post);
        post.setLikeCnt(post.getLikeCnt() + 1);
        postLikeRepository.save(postLike);
    }

    public void removeLikeOnPost(Long postId, User user) {
        Post post = postRepository.findById(postId).orElseThrow( ()
            -> new IllegalArgumentException("해당 게시글은 존재하지 않습니다.")
        );

        PostLike postLike = postLikeRepository.findByPostIdAndUser(postId,user);

        if(postLike != null) {
            post.setLikeCnt(post.getLikeCnt()-1);
            postLikeRepository.delete(postLike);
        }
    }
}
