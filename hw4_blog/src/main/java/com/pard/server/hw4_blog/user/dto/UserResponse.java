package com.pard.server.hw4_blog.user.dto;


import com.pard.server.hw4_blog.blog.dto.BlogResponse;
import com.pard.server.hw4_blog.user.entity.User;
import lombok.*;

import java.util.List;

public class UserResponse {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReadUser {
        private String name;
        private List<BlogResponse.BlogReadResponse> blogs;

//        public static ReadUser from(User user) {
//            return new ReadUser(user.getName(),
//                    BlogResponse.BlogReadResponse.blogToDto(
//                            user.getBlog()));
//
//        }
//
//        public static ReadUser of(User user) {
//            return ReadUser.builder()
//                   .name(user.getName())
//                    .blogs(BlogResponse.BlogReadResponse.blogToDto(
//                            user.getBlog()))
//                   .build();
//        }

    }

}
