package com.pard_server_fifth.week3_hw1;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Objects;

//RequestParam
@RestController
public class hw1_2 {

    @RequestMapping("/RequestParameter")
    public String Request(
            @RequestParam(required = false, defaultValue = "no name") String name,
            @RequestParam(required = false, defaultValue = "-1") Integer age
    )  {
        StringBuilder errorMessage = new StringBuilder();

        if (name.equals("no name")) {
            errorMessage.append("올바른 형식으로 name을 입력해주세요. 예: ?name=kyutaehan<br>");
        }

        if (age == -1) {
            errorMessage.append("올바른 형식으로 age를 입력해주세요. 예: ?age=24<br>");
        }

        if (!errorMessage.isEmpty()) {
            return errorMessage.toString();
        }

        return "RequestParam: 이름 = " + name + ", 나이 = " + age;
    }


}
