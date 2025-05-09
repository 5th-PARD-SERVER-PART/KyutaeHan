package com.pard.server.hw4_blog.member.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Builder.Default //일반적으로 빌더를 쓸 때 기본 값으로 유저를 사용
    private Role role = Role.USER;

    private String socialId; //구글에서 할당해주는 사용자 고유의 아이디
    //이 친구를 바로 pk로 만들어 세션에 넣을 수도 있음


}
