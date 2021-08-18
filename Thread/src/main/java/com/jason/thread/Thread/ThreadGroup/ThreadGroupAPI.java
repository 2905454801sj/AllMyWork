package com.jason.thread.Thread.ThreadGroup;

import java.util.Optional;

public class ThreadGroupAPI {
    public static void main(String[] args) throws InterruptedException {
        ThreadGroup tg=new ThreadGroup("tg");
        Thread t1=new Thread(tg,"t1"){
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t1.start();
        /*ThreadGroup tgg=new ThreadGroup(tg,"tg2");
        Thread t2=new Thread(tgg,"t2"){
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        t2.start();
        Optional.of(tg.activeCount()).ifPresent(System.out::println);
        Optional.of(tg.activeGroupCount()).ifPresent(System.out::println);*/
        tg.setDaemon(true);
        Thread.sleep(10000);
        Optional.of(tg.isDestroyed()).ifPresent(System.out::println);
        tg.destroy();
        Optional.of(tg.isDestroyed()).ifPresent(System.out::println);
    }
}
