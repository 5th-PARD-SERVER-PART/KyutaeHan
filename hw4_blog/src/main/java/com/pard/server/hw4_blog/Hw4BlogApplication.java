/**
 * 블로그 플랫폼 애플리케이션의 메인 클래스
 * 
 * 이 애플리케이션은 다음과 같은 주요 기능을 제공합니다:
 * 1. 사용자 인증 및 권한 관리 (Google OAuth2 로그인 지원)
 * 2. 블로그 게시글 작성, 조회, 수정, 삭제
 * 3. 블로그 게시글에 대한 좋아요 기능
 * 4. 사용자 프로필 관리
 */
package com.pard.server.hw4_blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Hw4BlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(Hw4BlogApplication.class, args);
    }

}
