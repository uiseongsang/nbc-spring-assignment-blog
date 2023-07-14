package com.sparta.springlv2.repository;

import com.sparta.springlv2.entity.Likes;
import com.sparta.springlv2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Likes, Long> {
    Likes findByPostIdAndUser(Long postId, User user);
}
