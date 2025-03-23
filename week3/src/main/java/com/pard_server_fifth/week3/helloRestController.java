package com.pard_server_fifth.week3;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class helloRestController {
    @RequestMapping("/helloRest")
    public String hello(){
        return "Hello, Rest World!";
    }
}
