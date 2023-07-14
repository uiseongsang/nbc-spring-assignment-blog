package com.sparta.springlv2.service;

import com.sparta.springlv2.entity.Likes;
import com.sparta.springlv2.entity.Post;
import com.sparta.springlv2.entity.User;
import com.sparta.springlv2.repository.LikeRepository;
import com.sparta.springlv2.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;
    private final PostRepository postRepository;
//    private final CommentRepository commentRepository;

    public boolean checkLiked(Long postId, User user) {
        Likes likes = likeRepository.findByPostIdAndUser(postId,user);
        return (likes != null) && likes.isLiked();
    }

    public void addLikeOnPost(Long postId, User user) {
        Post post = postRepository.findById(postId).orElseThrow( ()
            -> new IllegalArgumentException("해당 게시글은 존재하지 않습니다.")
        );

        Likes likes = new Likes(true, user, post);
        post.setLikeCnt(post.getLikeCnt() + 1);
        likeRepository.save(likes);
    }

    public void removeLikeOnPost(Long postId, User user) {
        Post post = postRepository.findById(postId).orElseThrow( ()
            -> new IllegalArgumentException("해당 게시글은 존재하지 않습니다.")
        );

        Likes likes = likeRepository.findByPostIdAndUser(postId,user);

        if(likes != null) {
            post.setLikeCnt(post.getLikeCnt()-1);
            likeRepository.delete(likes);
        }
    }
}
