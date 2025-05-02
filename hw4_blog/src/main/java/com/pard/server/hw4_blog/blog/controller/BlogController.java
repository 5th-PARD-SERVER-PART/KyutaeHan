package com.pard.server.hw4_blog.blog.controller;

import com.pard.server.hw4_blog.blog.dto.BlogRequest;
import com.pard.server.hw4_blog.blog.dto.BlogResponse;
import com.pard.server.hw4_blog.blog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/blog")
public class BlogController {
    private final BlogService blogService;

    @PostMapping
    public void createBlog(@RequestBody BlogRequest.BlogCreateRequest req) {
        blogService.createBlog(req);
    }

    @GetMapping("/user/{userId}")
    public List<BlogResponse.BlogReadResponse> findByWriter(@PathVariable Long userId) {
        return blogService.findByWriter(userId);
    }

    @PutMapping("/{blogId}")
    public void updateBlog(@PathVariable Long blogId,
                           @RequestParam Long userId,
                           @RequestBody BlogRequest.BlogUpdateRequest req) {
        blogService.updateBlog(blogId, req, userId);
    }

    @DeleteMapping("/{blogId}")
    public void deleteBlog(@PathVariable Long blogId,
                           @RequestParam Long userId) {
        blogService.deleteBlog(blogId, userId);
    }

}
