package com.pard.server.hw4_blog.blog.service;


import com.pard.server.hw4_blog.blog.dto.BlogRequest;
import com.pard.server.hw4_blog.blog.dto.BlogResponse;
import com.pard.server.hw4_blog.blog.entity.Blog;
import com.pard.server.hw4_blog.blog.mapper.BlogMapper;
import com.pard.server.hw4_blog.blog.repo.BlogRepo;
import com.pard.server.hw4_blog.user.entity.User;
import com.pard.server.hw4_blog.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BlogService {
    private final UserRepo userRepo;
    private final BlogRepo blogRepo;

    public void createBlog(BlogRequest.BlogCreateRequest req) {
        User user = userRepo.findById(req.getUserId())
                .orElseThrow(() -> new RuntimeException("유저 없음"));
        Blog blog = Blog.from(req.getFilename(), user);
        blogRepo.save(blog);
    }

    public List<BlogResponse.BlogReadResponse> findByWriter(Long userId) {
        return BlogMapper.toDtoList(blogRepo.findAllByUserId(userId));
    }

    @Transactional
    public void updateBlog(Long blogId, BlogRequest.BlogUpdateRequest req, Long userId) {
        Blog blog = blogRepo.findById(blogId)
                .orElseThrow(() -> new RuntimeException("블로그 없음"));
        if (!blog.getUser().getId().equals(userId)) {
            throw new RuntimeException("작성자만 수정 가능");
        }
        blog.updateFilename(req.getFilename());

        if (req.getFilename() != null) {
            blog.updateFilename(req.getFilename());
        }
    }

    public void deleteBlog(Long blogId, Long userId) {
        Blog blog = blogRepo.findById(blogId)
                .orElseThrow(() -> new RuntimeException("블로그 없음"));
        if (!blog.getUser().getId().equals(userId)) {
            throw new RuntimeException("작성자만 삭제 가능");
        }
        blogRepo.delete(blog);
    }

    public List<BlogResponse.BlogReadResponse> readAllBlogs() {
        List<Blog> blogs = blogRepo.findAll();
        return blogs.stream()
                .map(BlogResponse.BlogReadResponse::from)
                .toList();
    }
}
