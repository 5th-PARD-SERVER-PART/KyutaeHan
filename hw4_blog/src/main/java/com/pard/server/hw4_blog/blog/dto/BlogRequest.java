package com.pard.server.hw4_blog.blog.dto;

import lombok.*;

public class BlogRequest {
    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BlogCreateRequest {
        private Long userId;
        private String filename;

        public void setUserId(Long userId) {
            this.userId = userId;
        }
    }

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BlogUpdateRequest {
        private String filename;
    }

}
