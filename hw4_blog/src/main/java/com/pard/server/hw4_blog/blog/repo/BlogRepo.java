package com.pard.server.hw4_blog.blog.repo;

import com.pard.server.hw4_blog.blog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BlogRepo extends JpaRepository<Blog, Long> {
    List<Blog> findAllByUserId(Long userId);
}
