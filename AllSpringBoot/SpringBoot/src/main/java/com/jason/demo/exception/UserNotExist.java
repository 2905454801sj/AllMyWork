package com.jason.demo.exception;

public class UserNotExist extends RuntimeException{
    public UserNotExist() {
        super("用户不存在");
    }
}
