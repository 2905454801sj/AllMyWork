package com.example.springbootjdbc.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }
    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        ServletRegistrationBean servletRegistrationBean=new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map<String,String> map=new HashMap<>();
        map.put("loginUsername","admin");
        map.put("loginPassword","123456");
        map.put("allow","");

        servletRegistrationBean.setInitParameters(map);
        return servletRegistrationBean;
    }
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new WebStatFilter());
        Map<String,String> map=new HashMap<>();
        filterFilterRegistrationBean.setInitParameters(map);
        filterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        return filterFilterRegistrationBean;
    }
}
