package com.jason.thread.Thread;

import java.util.Optional;

public class ThreadException {
    private final static int A=10;
    private final static int B=0;
    public static void main(String[] args) {
        Thread t=new Thread(()->{
            try {
                Thread.sleep(1000);
                int result=A/B;
                Optional.of(result).ifPresent(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.setUncaughtExceptionHandler(((thread, throwable) -> {
            Optional.of(throwable).ifPresent(System.out::println);
            Optional.of(thread).ifPresent(System.out::println);
        }));
        t.start();
    }
}
