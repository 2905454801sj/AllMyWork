package com.jason.thread2.WaitSet;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.IntStream;

public class WaitSet {
    private static final Object OBJECT=new Object();
    /*
    所有对象都有一个自己的waitset，又来存放调用了该对象wait()方法而进入block的线程
    线程被notify之后不一定立即得到执行
    线程从waitset中唤醒的顺序不一定是FIFO
     */
    public static void main(String[] args) {
        IntStream.rangeClosed(1,10).forEach(i->
            new Thread(String.valueOf(i)){
                @Override
                public void run() {
                   synchronized (OBJECT){
                       try {
                           Optional.of(Thread.currentThread().getName()+"come to waitset.").ifPresent(System.out::println);
                           OBJECT.wait();
                           Optional.of(Thread.currentThread().getName()+"leave to waitset.").ifPresent(System.out::println);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }
                }
            }.start());
        Thread[] threads = new Thread[Thread.activeCount()];
        Thread.enumerate(threads);
        IntStream.rangeClosed(1,10).forEach(i->{
            synchronized (OBJECT) {
                OBJECT.notify();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            Optional.of(Arrays.toString(threads)).ifPresent(System.out::println);
        });
    }
}
