package com.jason.demo.Config;

import com.jason.demo.filter.MyFilter;
import com.jason.demo.listener.MyListener;
import com.jason.demo.servlet.Myservlet;
import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletRegistration;
import java.util.Arrays;

@Configuration
public class MyServerConfig {
    @Bean
    public ServletRegistrationBean servletRegistration(){
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new Myservlet(),"/myServlet");
        return servletRegistrationBean;
    }
    @Bean
    public FilterRegistrationBean filterRegistration(){
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new MyFilter());
        filterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/hello","/myFilter"));
        return filterFilterRegistrationBean;
    }
    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean(){
        ServletListenerRegistrationBean<MyListener> myListenerServletListenerRegistrationBean = new ServletListenerRegistrationBean<>(new MyListener());
        return myListenerServletListenerRegistrationBean;
    }
    @Bean
    public WebServerFactoryCustomizer<ConfigurableWebServerFactory> webServerFactoryCustomizer(){
        return new WebServerFactoryCustomizer<ConfigurableWebServerFactory>() {
            @Override
            public void customize(ConfigurableWebServerFactory factory) {
                factory.setPort(8888);
            }
        };
    }
}
