package com.sparta.springlv2.service;

import com.sparta.springlv2.entity.Like;
import com.sparta.springlv2.entity.Post;
import com.sparta.springlv2.entity.User;
import com.sparta.springlv2.repository.CommentRepository;
import com.sparta.springlv2.repository.LikeRepository;
import com.sparta.springlv2.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;
    public boolean checkLiked(Long postId, User user) {
        Like like = likeRepository.findByPostIdAndUser(postId,user);
        return like != null && like.isLiked();
    }

    public void addLikeOnPost(Long postId, User user) {
        Post post = postRepository.findById(postId).orElseThrow( ()
            -> new IllegalArgumentException("해당 게시글은 존재하지 않습니다.")
        );

        Like like = likeRepository.findByPostIdAndUser(postId,user);

        if(like == null) {
            new Like(true, user, post);
            post.setLikeCnt(post.getLikeCnt() + 1);
            likeRepository.save(like);
        }
    }

    public void removeLikeOnPost(Long postId, User user) {
        Post post = postRepository.findById(postId).orElseThrow( ()
            -> new IllegalArgumentException("해당 게시글은 존재하지 않습니다.")
        );

        Like like = likeRepository.findByPostIdAndUser(postId,user);

        if(like != null) {
            post.setLikeCnt(post.getLikeCnt()-1);
            likeRepository.delete(like);
        }
    }
}
