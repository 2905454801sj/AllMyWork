package com.jason.thread.Thread;

import java.util.Optional;
import java.util.stream.IntStream;

public class ThreadJoin2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(()->{
            try {
                System.out.println("running");
                Thread.sleep(1000);
                System.out.println("end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();

        t1.join(100);

        Optional.of("All task done.").ifPresent(System.out::println);
        IntStream.range(0,1000).forEach(i-> System.out.println(
                Thread.currentThread().getName()+"  index  "+i
        ));
    }
}
