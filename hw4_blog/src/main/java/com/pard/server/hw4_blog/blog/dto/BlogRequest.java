package com.pard.server.hw4_blog.blog.dto;

import lombok.*;

public class BlogRequest {
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BlogCreateRequest {
        private String filename;
        private Long userId;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BlogUpdateRequest {
        private String filename;
    }

}
