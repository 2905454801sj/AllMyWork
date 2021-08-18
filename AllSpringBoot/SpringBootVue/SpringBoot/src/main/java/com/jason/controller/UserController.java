package com.jason.controller;


import com.jason.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
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
}
