package com.jason.thread.Thread;

public class DaemonThread {
    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println(Thread.currentThread().getName()+"running");
                    Thread.sleep(10000);
                    System.out.println(Thread.currentThread().getName()+"end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.setDaemon(true);
        t.start();
        Thread.sleep(10000);
        System.out.println(Thread.currentThread().getName());
    }
}
