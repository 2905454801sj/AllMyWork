package com.jason.thread.Thread;

public class DaemonThread2 {
    public static void main(String[] args) throws InterruptedException {
        Thread t= new Thread(() -> {
            Thread a=new Thread(()->{
                try {
                    while(true){
                        System.out.println("doing.......");
                        Thread.sleep(100);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            //a.setDaemon(true);
            a.start();
            try {
                Thread.sleep(1000);
                System.out.println("t over");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //t.setDaemon(true);
        t.start();
        //Thread.sleep(10000);
        //System.out.println(Thread.currentThread().getName());
    }
}
