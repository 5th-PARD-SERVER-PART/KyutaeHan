package com.pard.server.hw4_blog.user.controller;


import com.pard.server.hw4_blog.user.dto.UserRequest;
import com.pard.server.hw4_blog.user.dto.UserResponse;
import com.pard.server.hw4_blog.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("")
    public List<UserResponse.ReadUser> getAllUsers() {
        return userService.readAllUsers();
    }

    @GetMapping("/{userId}")
    public UserResponse.ReadUser getUser(@PathVariable Long userId) {
        return userService.readUser(userId);
    }

    @PostMapping("")
    public void createUser(@RequestBody UserRequest.UserCreateRequest req) {
        userService.createUser(req);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }



}
