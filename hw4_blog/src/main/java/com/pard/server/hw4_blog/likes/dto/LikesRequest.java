package com.pard.server.hw4_blog.likes.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LikesRequest {
    private Long userId;
    private Long blogId;
}

