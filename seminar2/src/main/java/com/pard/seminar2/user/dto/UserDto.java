package com.pard.seminar2.user.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class UserDto {
    private long studentID;
    private String studentName;
}

//저 변수 중 몇개만 골라서 넘겨줄 수 도 있음 보내지 않을 것은 코멘트 처리하면 됨