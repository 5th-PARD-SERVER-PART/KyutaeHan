package com.pard.server.hw4_blog.blog.mapper;

import com.pard.server.hw4_blog.blog.dto.BlogResponse;
import com.pard.server.hw4_blog.blog.entity.Blog;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class BlogMapper {
    public static BlogResponse.BlogReadResponse toDto(Blog blog) {
        return BlogResponse.BlogReadResponse.builder()
                .blog_id(blog.getId())
                .filename(blog.getFilename())
                .writerName(blog.getUser().getName())
                .writerId(blog.getUser().getId())
                .likeCount((long) blog.getLikes().size())
                .build();
    }

    public static List<BlogResponse.BlogReadResponse> toDtoList(List<Blog> blogs) {
        return blogs.stream()
                .map(BlogMapper::toDto)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }
}
