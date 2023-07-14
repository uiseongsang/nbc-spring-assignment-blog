package com.sparta.springlv2.repository;

import com.sparta.springlv2.entity.CommentLike;
import com.sparta.springlv2.entity.PostLike;
import com.sparta.springlv2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentLikeRepository extends JpaRepository<CommentLike, Long> {
    CommentLike findByCommentIdAndUser(Long commentId, User user);

    CommentLike findByPostIdAndUser(Long id, User user);
}
