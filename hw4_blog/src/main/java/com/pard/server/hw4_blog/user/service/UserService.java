package com.pard.server.hw4_blog.user.service;

import com.pard.server.hw4_blog.blog.entity.Blog;
import com.pard.server.hw4_blog.blog.mapper.BlogMapper;
import com.pard.server.hw4_blog.member.domain.Role;
import com.pard.server.hw4_blog.user.dto.UserRequest;
import com.pard.server.hw4_blog.user.dto.UserResponse;
import com.pard.server.hw4_blog.user.entity.User;
import com.pard.server.hw4_blog.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    @Transactional
    public User createOrUpdateUser(String email, String name) {
        Optional<User> userOptional = userRepo.findByEmail(email);
        
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            user.update(name);
            return user;
        }

        User user = User.builder()
                .email(email)
                .name(name)
                .role(Role.USER)
                .blog(new ArrayList<>())
                .likes(new ArrayList<>())
                .build();
        
        return userRepo.save(user);
    }

    public User findByEmail(String email) {
        return userRepo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    public void createUser(UserRequest.UserCreateRequest req) {
        User user = User.builder()
                .name(req.getName())
                .email(req.getEmail())
                .blog(new ArrayList<>())
                .likes(new ArrayList<>())
                .role(Role.USER)
                .build();

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
