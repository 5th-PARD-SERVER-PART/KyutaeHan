package com.pard.server.hw4_blog.likes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class LikesResponse {
    private Long blogId;
    private Long likeCount;
}
