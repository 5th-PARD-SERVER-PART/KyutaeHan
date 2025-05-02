package com.pard.server.hw4_blog.blog.entity;


import com.pard.server.hw4_blog.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

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

    public static Blog from(String filename, User user) {
        return new Blog(null, filename, user);
    }

    public void updateFilename(String filename) {
        this.filename = filename;
    }
}
