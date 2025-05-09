package com.pard.server.hw4_blog.config;

import org.springframework.boot.web.servlet.view.MustacheViewResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Spring Web MVC 설정을 관리하는 클래스
 * 
 * 이 설정은 웹 애플리케이션의 MVC 관련 설정을 정의합니다.
 * 주로 정적 리소스 처리, 뷰 리졸버, 인터셉터 등의 설정을 포함합니다.
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    /**
     * 정적 리소스 핸들러를 추가하는 메서드
     * 
     * @param registry 정적 리소스 핸들러 레지스트리
     * 
     * 설정된 내용:
     * - 정적 리소스 위치: /static/
     * - 캐시 기간: 1년
     * - 리소스 체인 활성화: true
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/")
                .setCachePeriod(31536000)
                .resourceChain(true);
    }

    @Override
    public void  configureViewResolvers(ViewResolverRegistry registry){
        MustacheViewResolver resolver = new MustacheViewResolver();

        resolver.setCharset("UTF-8");

        resolver.setContentType("test/html;charset=UTF-8");

        resolver.setPrefix("classpath:/templates/");

        resolver.setSuffix(".html");

        registry.viewResolver(resolver);

    }
}
