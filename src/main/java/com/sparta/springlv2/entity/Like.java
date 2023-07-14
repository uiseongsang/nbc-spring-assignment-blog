package com.sparta.springlv2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.mapping.ToOne;

@Entity
@Getter
@Setter
@Table(name = "likes")
@IdClass(LikeId.class)
@NoArgsConstructor
public class Like {
    @Column
    private boolean isLiked;

    @Id
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    public Like(boolean isLiked, User user, Post post) {
        this.isLiked = isLiked;
        this.user = user;
        this.post = post;
    }
}
