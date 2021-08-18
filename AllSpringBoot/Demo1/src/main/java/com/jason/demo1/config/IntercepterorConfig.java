package com.jason.demo1.config;

import com.jason.demo1.interceptor.UserInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class IntercepterorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        String[] add={"/stu/**"};
        String[] ex={"/stu/out","/stu/login","/stu/error"};
        registry.addInterceptor(new UserInterceptor()).addPathPatterns(add).excludePathPatterns(ex);
    }
}
