package com.sparta.springlv2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "postlikes")
@NoArgsConstructor
public class PostLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private boolean isLiked;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne(optional = true)
    @JoinColumn(name = "comment_id", nullable = true)
    private Comment comment;

    public PostLike(boolean isLiked, User user, Post post) {
        this.isLiked = isLiked;
        this.user = user;
        this.post = post;
    }
}


