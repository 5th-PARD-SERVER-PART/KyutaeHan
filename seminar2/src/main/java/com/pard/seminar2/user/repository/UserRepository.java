package com.pard.seminar2.user.repository;

import com.pard.seminar2.user.dto.UserDto;
import com.pard.seminar2.user.entity.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
     private static final Map<Long, User> handong = new HashMap<>();

    public void save(UserDto userDto){
        User user = User.builder()
                .studentID(userDto.getStudentID())
                .studentName(userDto.getStudentName())
                .build();
            handong.put(userDto.getStudentID(), user);
    }

    public UserDto findByID(Long studentID){

        User user = handong.get(studentID);
        //option 없으면 거부처리 등등 id가 있는지 찾아보기 위해서 get

        return UserDto.builder()
                .studentID(user.getStudentID())
                .studentName(user.getStudentName())
                .build();
    }

    public void updateByID(Long studentID, UserDto userDto){
        User user = handong.get(studentID);

        user.setStudentID(userDto.getStudentID());
        user.setStudentName(userDto.getStudentName());
    }

    public void delete(Long studentID) {
        handong.remove(studentID);
    }

    public List<UserDto> findAll() {
        return handong.values().stream()
                .map(user -> UserDto.builder() //람다식, map을 굉장히 많이씀
                        .studentID(user.getStudentID())
                        .studentName(user.getStudentName())
                        .build()).toList();
    }//무조건 Dto를 통해서 내보내려고 함 즉 필터링 하는 과정이라고 생각하면 됨
}
