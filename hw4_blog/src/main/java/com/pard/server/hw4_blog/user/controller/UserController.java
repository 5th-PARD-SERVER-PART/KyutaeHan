package com.pard.server.hw4_blog.user.controller;

import com.pard.server.hw4_blog.user.dto.UserRequest;
import com.pard.server.hw4_blog.user.dto.UserResponse;
import com.pard.server.hw4_blog.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<UserResponse.ReadUser>> getAllUsers() {
        return ResponseEntity.ok(userService.readAllUsers());
    }

    @GetMapping("/{userId}")
    @ResponseBody
    public ResponseEntity<UserResponse.ReadUser> getUser(@PathVariable Long userId) {
        return ResponseEntity.ok(userService.readUser(userId));
    }

    @PostMapping("")
    @ResponseBody
    public ResponseEntity<Void> createUser(@RequestBody UserRequest.UserCreateRequest req) {
        userService.createUser(req);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/join")
    public String join(@ModelAttribute UserRequest.UserCreateRequest req) {
        userService.join(req);
        return "redirect:/loginForm";
    }

    @DeleteMapping("/{userId}")
    @ResponseBody
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}
