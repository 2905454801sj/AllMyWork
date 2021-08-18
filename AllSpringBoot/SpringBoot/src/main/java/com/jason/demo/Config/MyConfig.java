package com.jason.demo.Config;

import com.jason.demo.component.LoginHandlerInterceptor;
import com.jason.demo.component.MyLocaleResolver;
import com.jason.demo.servlet.Myservlet;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.Servlet;
import javax.servlet.ServletRegistration;

@Configuration
public class MyConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/newone").setViewName("success");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /*registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/index.html","/","/static");*/
    }

    /*@Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter=new WebMvcConfigurerAdapter(){
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("index");
            }
        };
        return adapter;

    }*/

    /*public ServletRegistrationBean registration(){
        ServletRegistrationBean servletRegistration = new ServletRegistrationBean(new Myservlet(),"/MyServlet");
        return servletRegistration;
    }*/
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
