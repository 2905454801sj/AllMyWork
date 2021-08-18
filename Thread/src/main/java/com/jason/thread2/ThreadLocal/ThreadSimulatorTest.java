package com.jason.thread2.ThreadLocal;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class ThreadSimulatorTest<T> {
    private final static ThreadSimulator<String> threadLocal=new ThreadSimulator<>(){};
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(()->{
            threadLocal.set("Thread-t1");
            try {
                Thread.sleep(1000);
                Optional.of(Thread.currentThread().getName()+"  "+threadLocal.get()).ifPresent(System.out::println);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Thread t2=new Thread(()->{
            threadLocal.set("Thread-t2");
            Optional.of(Thread.currentThread().getName()+"  "+threadLocal.get()).ifPresent(System.out::println);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        Optional.of(Thread.currentThread().getName()+"  "+threadLocal.get()).ifPresent(System.out::println);
    }
}
