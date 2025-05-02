package com.pard.server.hw4_blog.likes.controller;

import com.pard.server.hw4_blog.likes.service.LikesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/likes")
public class LikesController {

    private final LikesService likesService;

    @PostMapping("/{blogId}")
    public void toggleLike(@RequestParam Long userId,
                           @PathVariable Long blogId) {
        likesService.toggleLike(userId, blogId);
    }

    @GetMapping("/{blogId}/count")
    public long countLikes(@PathVariable Long blogId) {
        return likesService.countLikes(blogId);
    }
}
