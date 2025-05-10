package com.pard.server.hw4_blog.blog.controller;

import com.pard.server.hw4_blog.blog.dto.BlogRequest;
import com.pard.server.hw4_blog.blog.dto.BlogResponse;
import com.pard.server.hw4_blog.blog.service.BlogService;
import com.pard.server.hw4_blog.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/blog")
public class BlogController {
    private final BlogService blogService;
    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<Void> createBlog(@RequestBody BlogRequest.BlogCreateRequest req) {
        blogService.createBlog(req);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<BlogResponse.BlogReadResponse>> findByWriter(@PathVariable Long userId) {
        return ResponseEntity.ok(blogService.findByWriter(userId));
    }

    @PatchMapping("/{blogId}")
    public ResponseEntity<Void> patchBlog(@PathVariable Long blogId,
                         @RequestBody BlogRequest.BlogUpdateRequest req,
                         @AuthenticationPrincipal OAuth2User oauth2User) {
        String email = oauth2User.getAttribute("email");
        Long userId = userService.findByEmail(email).getId();
        blogService.updateBlog(blogId, req, userId);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{blogId}")
    public ResponseEntity<Void> deleteBlog(@PathVariable Long blogId,
                          @AuthenticationPrincipal OAuth2User oauth2User) {
        String email = oauth2User.getAttribute("email");
        Long userId = userService.findByEmail(email).getId();
        blogService.deleteBlog(blogId, userId);
        return ResponseEntity.noContent().build();
    }
}
