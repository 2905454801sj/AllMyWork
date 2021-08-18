package com.jason.demo.Controller;

import com.jason.demo.exception.UserNotExist;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {
    /*@ResponseBody
    @ExceptionHandler(UserNotExist.class)
    public Map<String,Object> ExceptionHandle(Exception exception){
        Map<String,Object> map=new HashMap<>();
        map.put("code","user.notexist");
        map.put("message",exception.getMessage());
        return map;
    }*/
    @ExceptionHandler(UserNotExist.class)
    public String ExceptionHandle(Exception exception, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        request.setAttribute("javax.servlet.error.status_code",500);
        map.put("code", "user.notexist");
        map.put("message", exception.getMessage());
        request.setAttribute("ext",map);
        return "forword:/error";
    }
}
