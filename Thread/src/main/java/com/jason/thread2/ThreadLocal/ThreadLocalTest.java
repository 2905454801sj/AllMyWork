package com.jason.thread2.ThreadLocal;

import java.util.Optional;

public class ThreadLocalTest {
    private static ThreadLocal threadLocal=new ThreadLocal(){
        @Override
        protected Object initialValue() {
            return new Object();
        }
    };
    public static void main(String[] args) {
        //threadLocal.set("Jason");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Optional.of(threadLocal.get()).ifPresent(System.out::println);
    }
}
