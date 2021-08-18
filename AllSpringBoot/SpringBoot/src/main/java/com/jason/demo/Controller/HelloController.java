package com.jason.demo.Controller;

import com.jason.demo.exception.UserNotExist;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {
    @RequestMapping("/")
    public String index(){
        return "index";
    }
    @ResponseBody
    @RequestMapping("/hello")
    public String handle01(@RequestParam("user") String user) {
        if(user.equals("asd")){
            throw new UserNotExist();
        }
        return "hello,Spring Boot 2!";
    }
    @RequestMapping("/success")
    public String success(Map<String,Object> map){
        map.put("hello","<h1>你好！！！！！</h1>");
        map.put("users", Arrays.asList("111","222","333"));
        return "success";
    }
}
