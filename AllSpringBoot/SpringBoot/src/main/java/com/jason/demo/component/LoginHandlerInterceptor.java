package com.jason.demo.component;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginHandlerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object o=request.getSession().getAttribute("usersign");
        if(o==null){
            //未登录
            request.setAttribute("msg","无权限，请先登录");
            request.getRequestDispatcher("index.html").forward(request,response);
            return false;
        }else{
            //已登录
            return true;
        }
    }
}
