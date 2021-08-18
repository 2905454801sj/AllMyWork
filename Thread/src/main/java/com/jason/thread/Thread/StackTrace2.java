package com.jason.thread.Thread;

import java.util.Arrays;
import java.util.Optional;

public class StackTrace2 {
    public void test2(){
        Arrays.asList(Thread.currentThread().getStackTrace()).stream()
                .filter(e->!e.isNativeMethod())
                .forEach(e-> Optional.of(e.getClassName()+":"
                        +e.getMethodName()
                        +":"+e.getLineNumber())
                        .ifPresent(System.out::println));
    }
    public static void main(String[] args) {
        new StackTrace1().test1();
    }
}
