package com.pard.server.seminar6.user.service;

import com.pard.server.seminar6.user.dto.UserDto;
import com.pard.server.seminar6.user.entity.User;
import com.pard.server.seminar6.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    public void save(UserDto userDto) {
        User user = User.builder()
                .name(userDto.getName())
                .age(userDto.getAge())
                .part(userDto.getPart())
                .build();


            userRepo.save(user);

    }

//    public Long getUserPart(String part) {
//        User user = userRepo.findByPart(part);
//        return user.getId();
//    }


    public void update(Long userId, UserDto userDto) {

            User user = userRepo.findById(userId).get();
//            user.updateId(userDto.getId());
            user.updateName(userDto.getName());
            user.updateAge(userDto.getAge());
            user.updatePart(userDto.getPart());
            userRepo.save(user);

    }

    public void deleteUser(Long userId) {
        User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("유저 없음"));
        userRepo.delete(user); // cascade 설정에 따라 블로그도 같이 삭제됨
    }

    //모르는 부분 공부할 것
    public List<User> readUser(String part){
        if(Objects.equals(part, "all")){
            return userRepo.findAll();
        }
        else {

            return userRepo.findAllByPart(part);
        }
    }
}
