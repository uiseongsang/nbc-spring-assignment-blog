package com.sparta.springlv2.repository;

import com.sparta.springlv2.entity.Like;
import com.sparta.springlv2.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<Like, Long> {
    Like findByPostIdAndUser(Long postId, User user);
}
