package com.pard_server_fifth.week3_hw1;

import org.springframework.web.bind.annotation.*;

//RestMethod
@RestController
public class hw1_3 {
    @GetMapping("/get")
    public String getUsers(){
        return "Get Method Controller";
    }

    @PostMapping("")
    public String postUser(){
        return "add user";
    }

    @GetMapping("/{userId}")
    public String getUser(@PathVariable Long userId){

        return "userId : "+ userId;
    }

    @PatchMapping("/{userId}")
    public String patchUser(@PathVariable Long userId){
        return "patch user Id : " + userId;
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable Long userId){
        return "Delete UserId : " + userId;
    }
}
