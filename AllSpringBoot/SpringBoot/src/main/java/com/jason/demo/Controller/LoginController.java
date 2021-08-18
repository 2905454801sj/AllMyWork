package com.jason.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {
    //@RequestMapping(value = "/user/login",method = RequestMethod.POST)
    @PostMapping(value = "/static")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String,Object> map, HttpSession httpSession){
        if(!StringUtils.isEmpty(username)&&password.equals("123456")){
            httpSession.setAttribute("usersign",username);
            //登陆成功，防止表单重复提交，可以重定向到主页
            return "redirect:/main.html";
        }else{
            map.put("msg","用户名或密码错误");
            return "index";
        }
    }
}
