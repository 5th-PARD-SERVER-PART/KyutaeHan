package com.pard.server.hw4_blog.blog.entity;

import com.pard.server.hw4_blog.likes.entity.Likes;
import com.pard.server.hw4_blog.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String filename;

    @ManyToOne(fetch = FetchType.LAZY) //earger 방식이 아닌 lazy 방식
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Likes> likes = new ArrayList<>();

    public static Blog from(String filename, User user) {
        return new Blog(null, filename, user, new ArrayList<>());
    }

    public void updateFilename(String filename) {
        this.filename = filename;
    }
}
