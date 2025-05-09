package com.pard.server.seminar5.common.config;

import com.pard.server.seminar5.member.service.PrincipalOauth2UserService;
import lombok.RequiredArgsConstructor;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.AbstractConfiguredSecurityBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.oauth2.client.OAuth2LoginConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final PrincipalOauth2UserService principalOauth2UserService;

    private final CorsConfig corsConfig;

    @Bean
    public SecurityFilterChain FilterChain(HttpSecurity http) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable);

        http.addFilter(corsConfig.corsFilter());

        http.authorizeHttpRequests(au -> au.anyRequest().permitAll());

        http.oauth2Login(
                 oauth -> oauth
                .loginPage("/loginForm")
                .defaultSuccessUrl("/home")
                .userInfoEndpoint(
                    userInfo-> userInfo.userService(principalOauth2UserService)
                )
        );

        return http.build();




    }
}
