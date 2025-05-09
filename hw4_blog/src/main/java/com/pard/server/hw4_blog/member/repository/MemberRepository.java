package com.pard.server.hw4_blog.member.repository;


import com.pard.server.hw4_blog.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByEmail(String email);


}
