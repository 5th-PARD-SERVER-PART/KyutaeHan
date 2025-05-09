package com.pard.server.hw4_blog.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Swagger UI 설정을 관리하는 클래스
 * 
 * 이 설정은 API 문서화를 위한 Swagger UI의 설정을 정의합니다.
 * API 엔드포인트, 서버 정보, API 정보 등을 설정합니다.
 */
@Configuration
public class SwaggerConfig {
    /**
     * OpenAPI 설정을 생성하는 메서드
     * 
     * @return OpenAPI 객체
     * 
     * 설정된 내용:
     * - 서버 URL: /
     * - API 제목: Blog Platform API
     * - API 설명: 블로그 플랫폼의 API 문서
     * - API 버전: 1.0.0
     */
    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI()
                .addServersItem(new Server().url("/"))
                .components(new Components())
                .info(apiInfo());
    }

    /**
     * API 정보를 생성하는 메서드
     * 
     * @return Info 객체
     */
    private Info apiInfo() {
        return new Info()
                .title("Blog Platform API")
                .description("블로그 플랫폼의 API 문서")
                .version("1.0.0");
    }

    //http://localhost:8080/swagger-ui/index.html

}