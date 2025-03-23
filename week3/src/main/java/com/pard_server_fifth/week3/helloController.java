package com.pard_server_fifth.week3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class helloController {
    @RequestMapping("/hello")
    public String hello() {
        return "hello.html";
    }
}
