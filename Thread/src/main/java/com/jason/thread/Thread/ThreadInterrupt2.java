package com.jason.thread.Thread;

public class ThreadInterrupt2 {
    private static final Object MON=new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread t=new Thread(){
            @Override
            public void run() {
                while(true){

                }
            }
        };
        t.start();
        Thread  main =Thread.currentThread();
        Thread t2=new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                main.interrupt();
                System.out.println("main.interrupt()");
            }
        };
        t2.start();
        t.join();
    }
}
