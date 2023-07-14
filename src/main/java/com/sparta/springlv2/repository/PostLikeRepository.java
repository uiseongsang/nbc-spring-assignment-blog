package com.sparta.springlv2.repository;

import com.sparta.springlv2.entity.PostLike;
import com.sparta.springlv2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostLikeRepository extends JpaRepository<PostLike, Long> {
    PostLike findByPostIdAndUser(Long postId, User user);
}
