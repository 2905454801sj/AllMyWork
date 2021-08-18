package com.jason.thread.Synchronized;

import java.util.Optional;

/**
 * 如果t1线程一直占用synchronized锁，则其他线程永远无法获得synchronized锁
 */
public class SynchronizedInterrupt {
    private synchronized static void run(){
        Optional.of(Thread.currentThread().getName()+" is running").ifPresent(System.out::println);
        while(true) {

        }
    }
    public static void main(String[] args) throws InterruptedException {
        Thread t1=new Thread(){
            @Override
            public void run() {
                SynchronizedInterrupt.run();
            }
        };
        t1.start();
        Thread.sleep(5000);
        Thread t2=new Thread(){
            @Override
            public void run() {
                SynchronizedInterrupt.run();
            }
        };
        t2.start();
        Thread.sleep(1000);
        t2.interrupt();
        Optional.of(t2.isInterrupted()).ifPresent(System.out::println);
    }
}
