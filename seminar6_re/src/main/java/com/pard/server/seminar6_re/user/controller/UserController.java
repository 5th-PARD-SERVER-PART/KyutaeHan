package com.pard.server.seminar6_re.user.controller;

import com.pard.server.seminar6_re.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.pard.server.seminar6_re.user.dto.UserDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @PostMapping("")
    public ResponseEntity<Void> createUser(@RequestBody UserDto req){
        userService.createUser(req);
        return ResponseEntity.status(HttpStatus.CREATED).build;
    }

}
