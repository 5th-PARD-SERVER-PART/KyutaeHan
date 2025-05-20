package com.pard.server.seminar6_re.user.service;

import com.pard.server.seminar6_re.user.dto.UserDto;
import com.pard.server.seminar6_re.user.entity.User;
import com.pard.server.seminar6_re.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    public void createUser(UserDto userDto) {
        User user = User.builder()
                .name(userDto.getName())
                .age(userDto.getAge())
                .part(userDto.getPart())
                .build();


        userRepo.save(user);
    }
}
