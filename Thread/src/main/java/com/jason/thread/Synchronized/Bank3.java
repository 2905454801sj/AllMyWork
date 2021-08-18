package com.jason.thread.Synchronized;

public class Bank3 {
    public static void main(String[] args) {
        final SynchronizedRunnable ticketWindowRunnable=new SynchronizedRunnable();
        Thread window1=new Thread(ticketWindowRunnable,"A");
        Thread window2=new Thread(ticketWindowRunnable,"B");
        Thread window3=new Thread(ticketWindowRunnable,"C");
        window1.start();
        window2.start();
        window3.start();
    }
}
