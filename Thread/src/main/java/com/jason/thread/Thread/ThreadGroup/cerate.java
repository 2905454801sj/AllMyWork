package com.jason.thread.Thread.ThreadGroup;

import java.util.Optional;

public class cerate {
    public static void main(String[] args) throws InterruptedException {
        /*
        Optional.of(Thread.currentThread().getName()).ifPresent(System.out::println);
        Optional.of(Thread.currentThread().getThreadGroup().getName()).ifPresent(System.out::println);
        */
        ThreadGroup threadGroup1=new ThreadGroup("tg1");
        Thread t1=new Thread(threadGroup1,"t1"){
            @Override
            public void run() {
                    try {
                        Optional.of(Thread.currentThread().getName()).ifPresent(System.out::println);
                        Optional.of(Thread.currentThread().getThreadGroup().getName()).ifPresent(System.out::println);
                        Optional.of(Thread.currentThread().getThreadGroup().getParent()).ifPresent(System.out::println);
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
            }
        };
        t1.start();
        t1.join();
        ThreadGroup threadGroup2=new ThreadGroup("tg2");
        Thread t2=new Thread(threadGroup2,"t2"){
            @Override
            public void run() {
                try {
                    Optional.of(threadGroup1.getName()).ifPresent(System.out::println);
                    Thread[] threads=new Thread[threadGroup1.activeCount()];
                    Optional.of(threadGroup1.enumerate(threads)).ifPresent(System.out::println);
                    Optional.of(Thread.currentThread().getName()).ifPresent(System.out::println);
                    Optional.of(Thread.currentThread().getThreadGroup().getName()).ifPresent(System.out::println);
                    Optional.of(Thread.currentThread().getThreadGroup().getParent()).ifPresent(System.out::println);
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t2.start();
    }
}
