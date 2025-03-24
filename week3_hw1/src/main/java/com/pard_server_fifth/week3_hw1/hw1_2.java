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
            @RequestParam(required = true, defaultValue = "no name") String name,
            @RequestParam(required = true, defaultValue = "-1") Integer age,
            HttpServletRequest request) {

        // 1. 잘못된 쿼리 형식 감지
        // 예: /RequestParameter?kyutae,23 처럼 key=value 형태가 아닌 경우
        String queryString = request.getQueryString();
        if (queryString != null && !queryString.contains("=")) {
            return "❌ Please give us the right parameter! Use ?name=xxx&age=yyy";
        }

        // 2. age가 숫자가 아닌 이상한 값이면 NumberFormatException이 발생해서 400 에러가 나는데
        //    이건 위에서 defaultValue = "-1"을 줬기 때문에 안전함!

        return "✅ RequestParam: 이름 = " + name + ", 나이 = " + age;
    }

}
