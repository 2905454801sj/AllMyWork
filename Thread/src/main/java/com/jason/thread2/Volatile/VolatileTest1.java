package com.jason.thread2.Volatile;

import java.util.Optional;

public class VolatileTest1 {
    private volatile static int initval=0;
    private final static int MAX=5;
    public static void main(String[] args) {
        new Thread(()->{
            int localval=initval;
            while(localval<MAX){
                if(localval!=initval){
                    Optional.of("The value updated to "+initval).ifPresent(System.out::println);
                    localval=initval;
                }
            }
        },"READER").start();

        new Thread(()->{
            int localval=initval;
            while(initval<MAX){
                Optional.of("Updated to "+(++localval)).ifPresent(System.out::println);
                initval=localval;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"UPDATE").start();
    }
}
