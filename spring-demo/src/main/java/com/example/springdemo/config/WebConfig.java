package com.example.springdemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    /**
     * order() 메소드를 통해 인터셉터의 우선 순위를 줄 수 있고, 숫자가 낮을 수록 우선 순위가 높다.
     * 만약 별도의 우선 순위 설정이 없다면 등록순으로 실행된다.
     **/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new UserInterceptor())
                .addPathPatterns("/**") // 특정 URI 포함
                .excludePathPatterns("/boards") // 특정 URI 제외
                .order(1);
    }
}
