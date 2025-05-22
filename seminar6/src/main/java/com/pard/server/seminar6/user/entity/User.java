package com.pard.server.seminar6.user.entity;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String part;

    public void updatePart(String part) {
        this.part = part;
    }
    public void updateName(String name) {
        this.name = name;
    }
//    public void updateid(Long id) {
//        this.id = id;
//    }
    public void updateAge(int age) {
        this.age = age;
    }
}
