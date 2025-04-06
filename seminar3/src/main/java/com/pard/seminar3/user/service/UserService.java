package com.pard.seminar3.user.service;

import com.pard.seminar3.user.dto.UserDto;
import com.pard.seminar3.user.entity.User;
import com.pard.seminar3.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    public void save(UserDto userDto){
        User user = User.builder()
                .email(userDto.getEmail())
                .password(userDto.getEmail())
                .build();

        userRepo.save(user);
    }

    public UserDto read(Long userId){
        User user = userRepo.findById(userId).get();
        return UserDto.builder()
                .email(user.getEmail())
                .password(user.getEmail())
                .build();
    }

    public Long getUserNum(String email) {
        User user = userRepo.findByEmail(email);
        return user.getUserId();
    }

    public List<UserDto> readAll() {
        List<User> users = userRepo.findAll();
        List<UserDto> userDtos =  users.stream().map(user->
                UserDto.builder()
                        .email(user.getEmail())
                        .password(user.getPassword())
                        .build()).toList();
    return userDtos;
    }//user 라는 값은 users를 알아서 단수로 만들어줌

    @Transactional//spring으로
    //100퍼센트 정상입력 안되면 롤백해라
    //중간에 데이터가 남지 않도록 해라
    //얘를 많으 쓰면 좋지 않음?? 왜??
    public void update(Long userId, UserDto userDto){
        User user = userRepo.findById(userId).get();//없을 경우를 처리
        //ispresent
        user.updateEmail(userDto.getEmail());
        user.updatePassword(userDto.getPassword());
        userRepo.save(user);
    }

}
