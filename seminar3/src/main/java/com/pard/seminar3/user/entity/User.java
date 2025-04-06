package com.pard.seminar3.user.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User {
    @Id//primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //아이디 생성방식 , 순서대로 알아서 만들게
    private Long userId; //id는 long으로 하는 것이 정석 국룰..

    @Column(name = "email", length = 20)
    private String email;

    @Column(name = "password", length = 20)
    private String password;

    @CreationTimestamp
    private Timestamp userSignUpTime;
    //정보가 들어온 시간을 자동으로 입력해 줌

    public void updateEmail(String email) {
        this.email = email;
    }
    public void updatePassword(String password) {
        this.password = password;
    }//setter 쓰지 않는 이유 ; 업데이트만으로 쓰이게끔 중요한 것이라서
}
