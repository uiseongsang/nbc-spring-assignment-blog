package com.sparta.springlv2.service;

import com.sparta.springlv2.entity.*;
import com.sparta.springlv2.repository.CommentLikeRepository;
import com.sparta.springlv2.repository.CommentRepository;
import com.sparta.springlv2.repository.PostLikeRepository;
import com.sparta.springlv2.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentLikeService {
    private final PostLikeRepository postLikeRepository;
    private  final CommentLikeRepository commentLikeRepository;
    private final PostRepository postRepository;
    private final CommentRepository commentRepository;

    public boolean checkLikedComment(Long commentId, User user) {
        CommentLike commentLike = commentLikeRepository.findByCommentIdAndUser(commentId,user);
        return (commentLike != null) && commentLike.isLiked();
    }

    public void addLikeOnComment(Long postId, Long commentId, User user) {
        Post post = postRepository.findById(postId).orElseThrow(()
                -> new IllegalArgumentException("해당 게시글이 없습니다.")
        );
        Comment comment = commentRepository.findById(commentId).orElseThrow( ()
                -> new IllegalArgumentException("해당 댓글이 없습니다")
        );

        CommentLike commentLike = new CommentLike(true,user,post,comment);
        comment.setLikeCnt(comment.getLikeCnt()+1);
        commentLikeRepository.save(commentLike);

    }

    public void removeLikeOnComment(Long postId, Long commentId, User user) {
        Post post = postRepository.findById(postId).orElseThrow(()
                -> new IllegalArgumentException("해당 게시글이 없습니다.")
        );
        Comment comment = commentRepository.findById(commentId).orElseThrow( ()
                -> new IllegalArgumentException("해당 댓글이 없습니다")
        );

        CommentLike commentLike = commentLikeRepository.findByCommentIdAndUser(commentId,user);
        if(commentLike != null) {
            comment.setLikeCnt(comment.getLikeCnt()-1);
            commentLikeRepository.delete(commentLike);
        }
    }
}
