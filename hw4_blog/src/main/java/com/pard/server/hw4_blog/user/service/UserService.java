package com.pard.server.hw4_blog.user.service;



import com.pard.server.hw4_blog.blog.dto.BlogResponse;
import com.pard.server.hw4_blog.blog.entity.Blog;
import com.pard.server.hw4_blog.blog.mapper.BlogMapper;
import com.pard.server.hw4_blog.user.dto.UserRequest;
import com.pard.server.hw4_blog.user.dto.UserResponse;
import com.pard.server.hw4_blog.user.entity.User;
import com.pard.server.hw4_blog.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class UserService {
    private final UserRepo userRepo;

    public void createUser(UserRequest.UserCreateRequest req) {
        User user = new User(null, req.getName(), new ArrayList<>());

        if (req.getBlogs() != null) {
            List<Blog> blogs = req.getBlogs().stream()
                    .map(dto -> Blog.from(dto.getFilename(), user))
                    .toList();
            user.getBlog().addAll(blogs);
        }

        userRepo.save(user);
    }

    public UserResponse.ReadUser readUser(Long userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("유저 없음"));

        return UserResponse.ReadUser.builder()
                .name(user.getName())
                .blogs(BlogMapper.toDtoList(user.getBlog()))
                .build();
    }

    public void deleteUser(Long userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("유저 없음"));
        userRepo.delete(user); // cascade 설정에 따라 블로그도 같이 삭제됨
    }

    public List<UserResponse.ReadUser> readAllUsers() {
        List<User> users = userRepo.findAll();

        return users.stream()
                .map(user -> UserResponse.ReadUser.builder()
                        .name(user.getName())
                        .blogs(BlogMapper.toDtoList(user.getBlog()))
                        .build())
                .toList();
    }





}
