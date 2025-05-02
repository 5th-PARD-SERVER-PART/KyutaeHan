package com.pard.server.hw4_blog.likes.repo;

import com.pard.server.hw4_blog.likes.entity.Likes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikesRepo extends JpaRepository<Likes, Long> {
    Optional<Likes> findByUserIdAndBlogId(Long userId, Long blogId);
    long countByBlogId(Long blogId);
}

