package com.sparta.springlv2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
//@Table(name = "likes")
@NoArgsConstructor
@IdClass(LikeId.class)
public class Likes {
    @Column
    private boolean isLiked;

    @Id
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

//    @Id
//    @ManyToOne
//    @JoinColumn(name = "comment_id")
//    private Comment comment;

    public Likes(boolean isLiked, User user, Post post) {
        this.isLiked = isLiked;
        this.user = user;
        this.post = post;
    }
}
