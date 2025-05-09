package com.pard.server.hw4_blog.user.controller;

import com.pard.server.hw4_blog.user.dto.UserRequest;
import com.pard.server.hw4_blog.user.dto.UserResponse;
import com.pard.server.hw4_blog.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping("")
    @ResponseBody
    public List<UserResponse.ReadUser> getAllUsers() {
        return userService.readAllUsers();
    }

    @GetMapping("/{userId}")
    @ResponseBody
    public UserResponse.ReadUser getUser(@PathVariable Long userId) {
        return userService.readUser(userId);
    }

    @PostMapping("")
    @ResponseBody
    public void createUser(@RequestBody UserRequest.UserCreateRequest req) {
        userService.createUser(req);
    }

    @PostMapping("/join")
    public String join(@ModelAttribute UserRequest.UserCreateRequest req) {
        userService.join(req);
        return "redirect:/loginForm";
    }

    @DeleteMapping("/{userId}")
    @ResponseBody
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }
}
