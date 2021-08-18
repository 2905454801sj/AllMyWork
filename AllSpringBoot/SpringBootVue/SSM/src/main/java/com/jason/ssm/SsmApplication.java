package com.jason.ssm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class SsmApplication {

    public static void main(String[] args) {
        SpringApplication.run(SsmApplication.class, args);
    }

}
