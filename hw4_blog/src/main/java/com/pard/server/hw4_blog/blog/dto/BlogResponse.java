package com.pard.server.hw4_blog.blog.dto;


import lombok.*;



public class BlogResponse {

    @Getter
//    @Builder
    @AllArgsConstructor
//    @NoArgsConstructor

    public static class BlogReadResponse {
        private Long blogId;
        private String filename;

    }
}
