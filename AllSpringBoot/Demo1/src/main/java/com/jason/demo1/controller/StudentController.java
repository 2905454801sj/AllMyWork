package com.jason.demo1.controller;

import com.jason.demo1.dao.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/stu")
public class StudentController {
    @Autowired
    Student student=new Student();
    @RequestMapping(value = "/login")
    public Object myStu(HttpServletRequest httpServletRequest){
        student.setName("Jason");
        student.setAge(20);
        httpServletRequest.getSession().setAttribute("student",student);
        return "login success";
    }
    @RequestMapping(value = "/buy")
    public Object buy(){
        return "shopping";
    }
    @RequestMapping("/out")
    public String out(){
        return "out";
    }
    @RequestMapping("/error")
    public String error(){
        return "error";
    }
}
