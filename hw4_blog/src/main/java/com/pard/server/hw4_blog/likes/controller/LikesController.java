package com.pard.server.hw4_blog.likes.controller;

import com.pard.server.hw4_blog.likes.dto.LikesResponse;
import com.pard.server.hw4_blog.likes.service.LikesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/blogs/{blogId}/likes")
public class LikesController {

    private final LikesService likesService;

    // 좋아요 토글 (등록 또는 취소)
    @PostMapping
    public ResponseEntity<Void> likeOrUnlike(@PathVariable Long blogId,
                                 @RequestParam Long userId) {
        likesService.toggleLike(userId, blogId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    // 좋아요 개수 조회
    @GetMapping("/count")
    public ResponseEntity<LikesResponse> countLikes(@PathVariable Long blogId) {
        long count = likesService.countLikes(blogId);
        return ResponseEntity.ok(new LikesResponse(blogId, count));
    }
}