package com.pard.server.hw4_blog.member.service;

import com.pard.server.hw4_blog.member.domain.Member;
import com.pard.server.hw4_blog.member.domain.Role;
import com.pard.server.hw4_blog.member.repository.MemberRepository;
import com.pard.server.hw4_blog.user.entity.User;
import com.pard.server.hw4_blog.user.repo.UserRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@Slf4j
@RequiredArgsConstructor
public class PrincipalOauth2UserService extends DefaultOAuth2UserService {
    private final MemberRepository memberRepository;
    private final UserRepo userRepo;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest oAuth2UserRequest) throws OAuth2AuthenticationException {
        log.info("구글에서 받아온 UserRequest: "+oAuth2UserRequest);
        OAuth2User oAuth2User = super.loadUser(oAuth2UserRequest);
        log.info("oauth에서 받아온 정보 : " + oAuth2User.getAttributes());

        String email = (String) oAuth2User.getAttribute("email");
        String name = (String) oAuth2User.getAttributes().get("name");
        String socialId = (String) oAuth2User.getAttributes().get("sub");

        // Member 생성 또는 조회
        memberRepository.findByEmail(email)
                .orElseGet(() -> memberRepository.save(
                        Member.builder()
                                .email(email)
                                .name(name)
                                .socialId(socialId)
                                .role(Role.USER)
                                .build()
                ));

        // User 생성 또는 업데이트 
        userRepo.findByEmail(email).ifPresentOrElse(
            user -> {
                user.update(name);
                userRepo.save(user);
            },
            () -> {
                User user = User.builder()
                        .email(email)
                        .name(name)
                        .password("소셜로그인") // 소셜 로그인은 비밀번호 필요 없음
                        .role(Role.USER)
                        .blog(new ArrayList<>())
                        .likes(new ArrayList<>())
                        .build();
                userRepo.save(user);
            }
        );

        return oAuth2User;
    }
}
