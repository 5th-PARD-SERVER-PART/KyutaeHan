package com.pard.seminar2.user.entity;

import lombok.*;

@Getter //get함수를 쓰면서 private 함수를 조작할 수 있도록 만듦
@Setter //수정을 허용
@NoArgsConstructor //기본 생성자
@AllArgsConstructor//받을 수 있는 생성자
@Builder

public class User {
    //실행을 누르는 순간 테이블에 이런 컬럼이 생김
    private long studentID;
    private String studentName;




}
