package com.pard.server.hw4_blog.likes.service;

import com.pard.server.hw4_blog.blog.entity.Blog;
import com.pard.server.hw4_blog.blog.repo.BlogRepo;
import com.pard.server.hw4_blog.likes.entity.Likes;
import com.pard.server.hw4_blog.likes.repo.LikesRepo;
import com.pard.server.hw4_blog.user.entity.User;
import com.pard.server.hw4_blog.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LikesService {
    private final LikesRepo likesRepo;
    private final UserRepo userRepo;
    private final BlogRepo blogRepo;

    @Transactional
    public void toggleLike(Long userId, Long blogId) {
        Likes like = likesRepo.findByUserIdAndBlogId(userId, blogId).orElse(null);

        if (like == null) {
            User user = userRepo.findById(userId).orElseThrow(() -> new RuntimeException("유저 없음"));
            Blog blog = blogRepo.findById(blogId).orElseThrow(() -> new RuntimeException("블로그 없음"));
            likesRepo.save(Likes.of(user, blog));
        } else {
            likesRepo.delete(like); // 토글 → 취소
        }
    }

    public long countLikes(Long blogId) {
        return likesRepo.countByBlogId(blogId);
    }
}

