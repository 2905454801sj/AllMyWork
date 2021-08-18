package com.jason.ssm.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

@Configuration
@EnableWebMvc
public class GlobalCorsConfig extends WebMvcConfigurationSupport {
        @Override
        public void addCorsMappings(CorsRegistry registry) {
            registry.addMapping("/**")
                    .allowedMethods("*")
                    .allowedOrigins("*")
                    .allowedHeaders("*").
                    allowCredentials(true).
                    exposedHeaders(HttpHeaders.SET_COOKIE).maxAge(3600L);
            super.addCorsMappings(registry);

    }
}
