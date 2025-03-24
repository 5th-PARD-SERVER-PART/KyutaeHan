package com.pard_server_fifth.week3_hw1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//PathVariable
@RestController
public class hw1 {
    @RequestMapping("/path/{name}/{studentId}")
    public String path3(@PathVariable String name, @PathVariable int studentId) {
        return "student name : " + name + "<br> student id is : " + studentId;
    }//html 형식으로 parsing 해주어야만 줄바꿈 처리가 됨
}
