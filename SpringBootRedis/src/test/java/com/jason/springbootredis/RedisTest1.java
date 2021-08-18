package com.jason.springbootredis;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;

@SpringBootTest
public class RedisTest1 {
    @Resource
    private RedisTemplate<String,Object> redisTemplate;
    @Test
    public void contextLoads(){
        //RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        redisTemplate.opsForValue().set("a","2");
        System.out.println(redisTemplate.opsForValue().get("a"));
    }
}
