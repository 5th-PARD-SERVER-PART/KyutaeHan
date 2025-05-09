package com.pard.server.hw4_blog.config;

import com.pard.server.hw4_blog.member.service.PrincipalOauth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Spring Security 설정을 관리하는 클래스
 * 애플리케이션의 보안 관련 설정을 담당
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final PrincipalOauth2UserService principalOauth2UserService;  // OAuth2 로그인 처리 서비스
    private final CorsConfig corsConfig;  // CORS 설정

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Spring Security의 필터 체인을 설정
     * CSRF 보호, CORS 설정, 인증/인가 규칙 등을 정의
     */
    @Bean
    public SecurityFilterChain FilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);  // CSRF 보호 비활성화
        http.addFilter(corsConfig.corsFilter());  // CORS 필터 추가
        
        // 인가 규칙 설정
        http.authorizeHttpRequests(auth -> auth
            .requestMatchers("/loginForm", "/joinForm", "/join", "/oauth2/**", "/user/join").permitAll()  // 로그인 및 회원가입 관련 URL은 모두 허용
            .requestMatchers("/blog/**").authenticated()  // 블로그 관련 URL은 인증된 사용자만 접근 가능
            .requestMatchers("/user/**").authenticated()  // 사용자 관련 URL은 인증된 사용자만 접근 가능
            .anyRequest().permitAll()  // 그 외 URL은 모두 허용
        );

        http.formLogin(form -> form
            .loginPage("/loginForm")
            .loginProcessingUrl("/login")
            .failureUrl("/loginForm?error")
            .defaultSuccessUrl("/", true)
            .permitAll()
        );

        http.oauth2Login(  // OAuth2 로그인 설정
                oauth -> oauth
                .loginPage("/loginForm")  // 로그인 페이지 경로
                .defaultSuccessUrl("/", true)  // 로그인 성공 시 리다이렉트 경로
                .userInfoEndpoint(  // OAuth2 사용자 정보 엔드포인트 설정
                    userInfo-> userInfo.userService(principalOauth2UserService)
                )
        );
        return http.build();
    }
}
