package com.pard_server_fifth.week3_hw1;

//동적으로 데이터 출력하기

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class hw1_5 {
    @RequestMapping("/hiStudent")
    public String hiStudent() {
        return """
               <h1>Hi student</h1>
               this is <B>PARD</B> server<br>
               nice to meet you
               """;
    }
}
