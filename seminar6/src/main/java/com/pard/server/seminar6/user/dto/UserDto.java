package com.pard.server.seminar6.user.dto;

import com.pard.server.seminar6.user.entity.User;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter

public class UserDto {
    private Long id;
    private String name;
    private int age;
    private String part;

    public static UserDto from(User user) {
        return UserDto.builder()
                .name(user.getName())
                .id(user.getId())
                .age(user.getAge())
                .part(user.getPart())
                .build();
    }


}
