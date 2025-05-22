package com.pard.server.seminar6.user.controller;


import com.pard.server.seminar6.user.dto.UserDto;
import com.pard.server.seminar6.user.entity.User;
import com.pard.server.seminar6.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;


    @GetMapping("")
    public List<User> findAllByPart(@RequestParam String part) {
        return userService.readUser(part);
    }


@PostMapping("")
public ResponseEntity<Void> save(@RequestBody UserDto userDto) {
    userService.save(userDto);
    return ResponseEntity.ok().build();
}

@PatchMapping("/{userId}")
public void update(@PathVariable Long userId, @RequestBody UserDto userDto){
    userService.update(userId, userDto);
}

@DeleteMapping("")
@ResponseBody
public ResponseEntity<Void> deleteUser(@RequestParam Long userId) {
    userService.deleteUser(userId);
    return ResponseEntity.noContent().build();
}


}



