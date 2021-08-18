package com.jason.thread.Thread;

import java.util.Optional;
import java.util.stream.IntStream;

public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(()->{
            IntStream.range(0,1000).forEach(i-> System.out.println(
                    Thread.currentThread().getName()+"  index  "+i
            ));
        });

        Thread t2=new Thread(()->{
            IntStream.range(0,1000).forEach(i-> System.out.println(
                    Thread.currentThread().getName()+"  index  "+i
            ));
        });
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        Optional.of("All task done.").ifPresent(System.out::println);
        IntStream.range(0,1000).forEach(i-> System.out.println(
                Thread.currentThread().getName()+"  index  "+i
        ));
    }
}
