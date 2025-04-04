package com.pard.seminar2.user.controller;

import com.pard.seminar2.user.dto.UserDto;
import com.pard.seminar2.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor//생성자 final
@RequestMapping("/user")
public class UserController {
    private final UserService userService;//바뀌면 위험한 데이터 즉 그래서 final 로 설정


    @PostMapping("")
    public String save (@RequestBody UserDto userDto){//RequestBody 가 중요 json을 알아서 처리해줌
        userService.saveUser(userDto);
        return "저장완료";
    }

    @GetMapping("/{studentID}")
    public UserDto findByID(@PathVariable Long studentID){//userDto를 넘겨줌

        return userService.findByID(studentID);
    }

    @PatchMapping("/{studentID}")
    public String updateByID(@PathVariable Long studentID, @RequestBody UserDto userDto) {
        userService.updateByID(studentID, userDto);
        return "수정완료";
    }

    @DeleteMapping("/{studentID}")
    public String delete(@PathVariable Long studentID) {
        userService.delete(studentID);
        return "삭제완료";
    }

    @GetMapping("")
    public List<UserDto> findAll(){
        return userService.findAll();
    }

}
