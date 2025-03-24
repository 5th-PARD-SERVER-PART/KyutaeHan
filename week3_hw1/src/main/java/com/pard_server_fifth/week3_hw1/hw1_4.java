package com.pard_server_fifth.week3_hw1;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//controller 정적 데이터 가져오기
@Controller
public class hw1_4 {
    @RequestMapping("/studentList")
        public String studentList() {
            return "studentList.html";
        }

}
