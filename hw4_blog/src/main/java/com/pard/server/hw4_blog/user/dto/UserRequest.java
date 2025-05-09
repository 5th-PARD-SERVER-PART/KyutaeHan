package com.pard.server.hw4_blog.user.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

public class UserRequest {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserCreateRequest {
        private String name;
        private String email;
        private List<BlogDto> blogs;
    }


    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class BlogDto {
        private String filename;
    }

    /*@Getter
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @NoArgsConstructor @AllArgsConstructor
    public static class UserCreateRequest {
        private String name;
        private List<Likes> Likes;
    }*/

}
