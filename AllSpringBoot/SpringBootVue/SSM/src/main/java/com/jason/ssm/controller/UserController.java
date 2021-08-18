package com.jason.ssm.controller;

import com.jason.ssm.entity.User;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
@RequestMapping("user")

public class UserController {
    @RequestMapping(value = "regist",method = RequestMethod.GET)
    public String regist(@PathVariable String mail,
                         @PathVariable String password){
        return "success";
    }
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(@RequestBody User user){
        if("xm".equals(user.getName())&&"123".equals(user.getPassword())) {
            return "ok";
        }
        return "not ok";
    }
    @RequestMapping(value = "login1/{mail}/{password}",method = RequestMethod.GET)
    public String login1(@PathVariable("mail") String mail,
                         @PathVariable("password") String password){
        if("xm".equals(mail)&&"123456".equals(password)) {
            return "1";
        }
        return "not ok";
    }
    @RequestMapping(value = "test")
    public String test(){
        return "1";
    }
}
